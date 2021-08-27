<template>
  <el-container class="home-container">
    <el-header>
      <h1></h1>
      <el-button type="info" @click="logout">退出</el-button>
    </el-header>
    <el-main>
      <el-row :gutter="20">
        <el-col :span="4"><div class="grid-content"></div></el-col>
        <el-col :span="16">
          <div class="grid-content">
            <!-- 中间搜索card -->
            <el-card class="box-card">
              <!-- 搜索 -->
              <div class="search_div">
                <!-- 搜索框 -->
                <el-form ref="form" :model="queryInfo" label-width="80px">
                  <el-row>
                    <el-col :span="3">
                      <el-form-item label="分数">
                        <el-input v-model="queryInfo.score"></el-input>
                      </el-form-item>
                    </el-col>

                    <el-col :span="3">
                      <el-form-item label="分数范围">
                        <el-input v-model="queryInfo.scoreRange"></el-input>
                      </el-form-item>
                    </el-col>

                    <el-col :span="3">
                      <el-form-item label="专业">
                        <el-input v-model="queryInfo.score"></el-input>
                      </el-form-item>
                    </el-col>

                    <el-col :span="4">
                      <el-form-item label="省份">
                        <el-select v-model="province" placeholder="请选择" @change="sysCityArea">
                        <el-option
                          v-for="item in areaProvinceList"
                          :key="item.baseId"
                          :label="item.baseName"
                          :value="item.baseId"
                          :disabled="item.disabled"
                        >
                        </el-option>
                      </el-select>
                      </el-form-item>
                    </el-col>

                    <el-col :span="4">
                      <el-form-item label="市">
                        <el-select v-model="city" placeholder="请选择">
                        <el-option
                          v-for="item in areaCityList"
                          :key="item.baseId"
                          :label="item.baseName"
                          :value="item.baseId"
                          :disabled="item.disabled"
                        >
                        </el-option>
                      </el-select>
                      </el-form-item>
                    </el-col>

                    <el-col :span="4">
                      <el-form-item label="">
                      <el-button type="primary" @click="getSearch">
                        搜索
                      </el-button>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-form>
              </div>
              <div class="table_div">
                <!-- 下方excel 表格 -->
                <el-table
                  ref="singleTable"
                  :data="scoreList"
                  highlight-current-row
                  @current-change="handleCurrentChange"
                  style="width: 100%"
                >
                  <!-- 多选框 -->
                  <el-table-column
                    type="selection"
                    width="55"
                  ></el-table-column>
                  <!-- 序号 -->
                  <el-table-column type="index" width="50"> </el-table-column>
                  <!--  -->
                  <el-table-column property="schoolName" label="学校">
                  </el-table-column>
                  <el-table-column property="address" label="地址">
                  </el-table-column>
                  <el-table-column property="count" label="可选专业数量">
                  </el-table-column>
                  <el-table-column property="lowestScore" label="最低录取分数">
                  </el-table-column>
                  <el-table-column
                    property="lowestPosition"
                    label="最低录取名次"
                  >
                  </el-table-column>
                  <el-table-column property="schoolName" label="详情">
                  </el-table-column>
                </el-table>

                <div class="block">
                  <span class="demonstration"></span>
                  <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="queryInfo.pageNum"
                    :page-sizes="[10, 20, 30, 50]"
                    :page-size="queryInfo.pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total"
                  >
                  </el-pagination>
                </div>
              </div>
            </el-card>
          </div>
        </el-col>
        <el-col :span="4"><div class="grid-content"></div></el-col>
      </el-row>
    </el-main>
    <el-footer>Footer</el-footer>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      //   查询参数
      queryInfo: {
        score: 610,
        scoreRange: 5,
        // 当前页码
        pageNum: 1,
        // 当前每页显示多少条数据
        pageSize: 10,
      },
      scoreList: [],
      total: 0,
      ipt2List: [
        { label: "5", value: "5" },
        { label: "10", value: "10" },
        { label: "20", value: "20" },
        { label: "30", value: "30" },
      ],
      areaQuery: {
        areaLevel: 1,
        baseParentId: ''
      },
      areaProvinceList: [],
      areaCityList: [],
      province: '',
      city: '',
    };
  },
  created() {
    this.getSearch();
    this.sysProvinceArea();
  },
  methods: {
    logout() {
      window.sessionStorage.clear();
      this.$router.push("/login");
    },
    async getSearch() {
      const { data: res } = await this.$http.get("/search/list", {
        params: this.queryInfo,
      });
      // console.log(res);
      if (res.code !== 0) {
        return this.$message.error("获取用户列表失败");
      }
      this.scoreList = res.obj.content;
      // console.log(this.scoreList);
      this.total = res.obj.totalCount;
    },
    async sysProvinceArea() {
      console.log('===== area =====' + this.province); 
      const { data: res } = await this.$http.get("/sysArea/sysAreaLink", {
        params: this.areaQuery,
      });
      
      if (res.code !== 0) {
        return this.$message.error("获取地址列表失败");
      }
      this.areaProvinceList = res.obj;
      console.log(this.areaProvinceList);
    },

   async sysCityArea() {
      console.log('===== area =====' + this.province); 
      this.areaQuery.areaLevel = 2
      this.areaQuery.baseParentId = this.province;

      const { data: res } = await this.$http.get("/sysArea/sysAreaLink", {
        params: this.areaQuery,
      });
      
      if (res.code !== 0) {
        return this.$message.error("获取地址列表失败");
      }
      this.areaCityList = res.obj;
      console.log(this.areaCityList);
    },




    tableRowClassName({ row, rowIndex }) {
      if (rowIndex === 1) {
        return "warning-row";
        1;
      } else if (rowIndex === 3) {
        return "success-row";
      }
      return "";
    },
    // 监听pagesize改变的事件
    handleSizeChange(newSize) {
      console.log(newSize);
      this.queryInfo.pageSize = newSize;
      this.getSearch();
    },
    // 监听页码值改变的事件
    handleCurrentChange(newPage) {
      console.log(newPage);
      this.queryInfo.pageNum = newPage;
      this.getSearch();
    },
  },
};
</script>

<style lang='less' scoped>
.home-container {
  height: 100%;
}

.el-header {
  background-color: #373d41;
  display: flex;
  justify-content: space-between;
  padding-left: 0%;
  color: #fff;
  font-size: 20px;
  > div {
    display: flex;
    align-items: center;
    span {
      margin-left: 15px;
    }
  }
}

.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
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
  margin: 50px auto;
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
</style>