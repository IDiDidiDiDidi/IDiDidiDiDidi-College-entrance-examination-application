<template>
  <el-container class="home-container">
    <el-main>
      <el-row :gutter="20">
        <el-col :span="2"><div class="grid-content"></div></el-col>
        <el-col :span="20">
          <div class="grid-content">
            <!-- 中间搜索card -->
            <el-card class="box-card">
              <h2>2021 年山东高考成绩查询</h2>
              <el-form
                class="login_form"
                :model="queryInfoForm"
                ref="loginFromRef"
              >
                <div class="search_school">
                  <el-input
                    v-model="queryInfoForm.schoolName"
                    placeholder="请输入搜索学校"
                  ></el-input>
                  <el-form-item class="btns">&nbsp;
                    <el-button type="primary" @click="querySchool"
                      >搜索</el-button
                    >
                  </el-form-item>
                </div>
              </el-form>
              <el-table
                ref="singleTable"
                :data="schoolList"
                highlight-current-row
                @current-change="handleCurrentChange"
                style="width: 100%"
              >
                <!-- 多选框 -->
                <el-table-column type="selection" width="55"></el-table-column>
                <!-- 序号 -->
                <el-table-column
                  type="index"
                  width="50"
                  label="序号"
                ></el-table-column>
                <!--  -->
                <el-table-column property="schoolNo" label="学校编号">
                </el-table-column>
                <el-table-column property="schoolName" label="学校">
                </el-table-column>
                <el-table-column property="address" label="地址">
                </el-table-column>
                <el-table-column label="详情">
                  <template slot-scope="scope">
                    <el-button
                      size="mini"
                      type="text"
                      icon="el-icon-view"
                      @click.stop="handleDetail(scope.row)"
                      >详情</el-button
                    >
                  </template>
                </el-table-column>
              </el-table>
              <div class="block">
                <span class="demonstration"></span>
                <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="queryInfoForm.pageNum"
                  :page-sizes="[10, 20, 30, 50]"
                  :page-size="queryInfoForm.pageSize"
                  layout="total, sizes, prev, pager, next, jumper"
                  :total="total"
                >
                </el-pagination>
              </div>
            </el-card>
          </div>
        </el-col>
        <el-col :span="2"><div class="grid-content"></div></el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      //   查询参数
      queryInfoForm: {
        schoolName: "",
        pageNum: 1,
        // 当前每页显示多少条数据
        pageSize: 10,
      },
      schoolList: [],
      total: 0,
      ipt2List: [
        { label: "5", value: "5" },
        { label: "10", value: "10" },
        { label: "20", value: "20" },
        { label: "30", value: "30" },
      ],
    };
  },
  created() {
    this.querySchool();
  },
  methods: {
    async querySchool() {
      console.log("========== search school " + this.queryInfoForm.schoolName);
      const { data: res } = await this.$http.get("/search/school", {
        params: this.queryInfoForm,
      });
      console.log(res);
      if (res.code !== 0) {
        return this.$message.error("获取学校列表失败");
      }
      this.schoolList = res.obj.content;
      // console.log(this.scoreList);
      this.total = res.obj.totalCount;
    },
    // 监听页码值改变的事件
    handleCurrentChange(newPage) {
      console.log(newPage);
      this.queryInfoForm.pageNum = newPage;
      console.log(
        "=======this.queryInfoForm.pageNum" + this.queryInfoForm.pageNum
      );
      this.querySchool();
    },
    // 监听pagesize改变的事件
    handleSizeChange(newSize) {
      console.log(newSize);
      this.queryInfo.pageSize = newSize;
      this.getSearch();
    },
    handleDetail(val) {
      console.log("===============schoolNo: " + val.schoolNo);
      // this.baseId = val.baseId;
      const { href } = this.$router.resolve({
        path: "/detail",
        query: { schoolNo: val.schoolNo, schoolName: val.schoolName },
      });
      // window.open("#/smartSearch/detail", "_blank");
      window.open(href, "_blank");
    },
  },
};
</script>

<style lang='less' scoped>
.home-container {
  height: 100%;
}

.el-main {
  background-color: #eaedf1;
}

.iconfont {
  margin-right: 10px;
}

.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}

.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.box-card {
  margin: 10px auto;
  //   position: absolute;
  //   left: 50%;
  //   top: 50%;
  //   transform: translate(-50%, 50%);
}

.table_div {
  display: flex;
  flex-direction: column;
  //   display: -webkit-flex;
  align-items: center;
  -webkit-align-items: center;
  justify-content: center;
}

.search_div {
  margin: 20px;
}

.search_school {
  display: flex;
  padding: 0 20px;
  height: 50px;
  .font {
    margin: 0 auto;
    vertical-align: middle;
    line-height: 40px; /*让黄色div中的文字内容垂直居中*/
    text-align: center;
  }
  .el-input {
    width: 400px;
  }
}
</style>
