<template>
  <el-container class="home-container">
    <el-main>
      <el-row :gutter="20">
        <el-col :span="2"><div class="grid-content"></div></el-col>
        <el-col :span="20">
          <div class="grid-content">
            <!-- 中间搜索card -->
            <el-card class="box-card">
              <h2>es 搜索测试</h2>
              <div> 
                <el-alert
                 title="搜索测试"
                 center
                 type="info">
                </el-alert>
              </div>
              <!-- 搜索 -->
              <div class="search_div">
                <!-- 搜索框 -->
                <el-form ref="form" label-width="80px">
                  <div class="search_school">
                  <el-input
                    v-model="name"
                    placeholder="请输入搜索内容"
                  ></el-input>
                  <el-form-item class="btns">&nbsp;
                    <el-button type="primary" @click="esQuery"
                      >搜索</el-button
                    >
                  </el-form-item>
                </div>
                </el-form>


              <div class="table_div">
                <!-- 下方excel 表格 -->
                <el-table
                  ref="singleTable"
                  :data="esSearchList"
                  highlight-current-row
                  @current-change="handleCurrentChange"
                  style="width: 100%"
                >
                  <!-- 多选框 -->
                  <el-table-column
                    type="selection"
                  ></el-table-column>
                  <!-- 序号 -->
                  <!-- <el-table-column type="index" width="50" label="序号"></el-table-column> -->
                  <!--  -->

                  <el-table-column property="id" label="id" width="50">
                  </el-table-column>
                  <el-table-column property="keywords" label="keywords">
                  </el-table-column>
                  <el-table-column property="visittime" label="visittime">
                  </el-table-column>
                  <el-table-column property="userid" label="userid">
                  </el-table-column>
                  <el-table-column property="rank" label="rank" width="50">
                  </el-table-column>
                  <el-table-column property="clicknum" label="clicknum" width="100">
                  </el-table-column>
                  <el-table-column property="url" label="url">
                  </el-table-column>
                  <el-table-column label="详情">
                    <template slot-scope="scope">
                        <el-button
                        size="mini"
                        type="text"
                        icon="el-icon-view"
                        @click.stop="handleDetail(scope.row)"
                        >详情</el-button>
                    </template>
                  </el-table-column>
                </el-table>

                <div class="block">
                  <span class="demonstration"></span>
                  <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[10, 20, 30, 50]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total"
                  >
                  </el-pagination>
                </div>
              </div>


              </div>
            </el-card>
          </div>
        </el-col>
        <el-col :span="4"><div class="grid-content"></div></el-col>
      </el-row>
    </el-main>
  </el-container>
</template>



<script>
export default {
  data() {
    return {
        name: "",
        pageNum: 1,
        // 当前每页显示多少条数据
        pageSize: 10,
        esSearchList: [],
        total: 0,
    };
  },
  created() {
    this.esQuery();
  },
  methods: {
      async esQuery() {
      console.log("========== search school " + this.name);
      const { data: res } = await this.$http.get("/es/" + this.name);
      console.log(res);
      if (res.code !== 0) {
        return this.$message.error("获取列表失败");
      }
      this.esSearchList = res.obj;
      console.log("==========esSearchList" + this.esSearchList);
      this.total = res.obj.totalCount;
    },
    // 监听pagesize改变的事件
    handleSizeChange(newSize) {
      console.log(newSize);
      this.pageSize = newSize;
      this.esQuery();
    },
    // 监听页码值改变的事件
    handleCurrentChange(newPage) {
      console.log(newPage);
      this.pageNum = newPage;
      console.log("=======this.pageNum" + this.pageNum);
      this.esQuery();
    },
    
  },
};
</script>

<style lang='less' scoped>
.em {
	color: red
}
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
