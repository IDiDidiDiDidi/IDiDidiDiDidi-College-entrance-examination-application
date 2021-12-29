<template>
  <el-container class="home-container">
    <el-header>
      <h1></h1>
      <el-button type="info" @click="logout">退出</el-button>
    </el-header>
    <el-main>
      <div class="schoolName_div">
        <h2>{{ this.$route.query.schoolName }}</h2>
      </div>
      <h3>往年平均录取排名折线图</h3>
      <div class="chart_div">
        <div class="left">左
          <div id="myChart" :style="{ width: '300px', height: '300px' }"></div>


        </div>
        <div class="right">右
        </div>
      </div>

      <h3>可选专业如下</h3>
      <div v-for="(value, name, index) in detailList">
        <el-card class="box-card">
          <li>{{ name }} 年各专业录取成绩和排名</li>
          <el-alert
                 title="部分年份只有排名没有成绩"
                 type="info">
                </el-alert>
          <!-- <div v-for="(item, index) in value">
            <li>{{ item }} -- {{ index }}</li>
          </div> -->
          <el-table
            ref="singleTable"
            :data="value"
            highlight-current-row
            style="width: 100%"
            height="500"
            border
          >
            <!-- 多选框 -->
            <el-table-column type="selection" width="55"></el-table-column>
            <!-- 序号 -->
            <el-table-column type="index" width="50" label="序号">
            </el-table-column>
            <el-table-column
              property="major"
              label="专业名称"
            ></el-table-column>
            <el-table-column
              property="majorNo"
              label="专业编号"
              width="50"
            ></el-table-column>
            <el-table-column
              property="lowestScore"
              label="最低录取分数"
            ></el-table-column>
            <el-table-column
              property="lowestPosition"
              label="最低录取名次"
            ></el-table-column>
            <el-table-column
              property="plansNumber"
              label="计划数"
              width="50"
            ></el-table-column>
            <el-table-column
              property="pitchPlansNumber"
              label="投档计划数"
              width="50"
            ></el-table-column>
            <el-table-column
              property="castNumber"
              label="投出数"
              width="50"
            ></el-table-column>
            <el-table-column
              property="batch"
              label="投档批次"
              width="50"
            ></el-table-column>
            <el-table-column
              property="level"
              label="学校类型"
              width="100"
            ></el-table-column>
            <!-- <el-table-column property="schoolName" label="专业"></el-table-column> -->
            <el-table-column label="专业详情">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-view"
                  @click.stop="handleDetail(scope.row)"
                  >专业详情</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </div>
    </el-main>
    <el-footer>Footer</el-footer>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      detailList: [],
      positionMinMaxList: [],
      scoreMinMaxList: [],
      sets: [
        [1, 2, 3, 4, 5],
        [6, 7, 8, 9, 10],
      ],
      msg: "Welcome to Your Vue.js App",
    };
  },
  created() {
    this.getDetail();
  },
  mounted() {
    this.drawLine();
  },
  methods: {
    even: function (numbers) {
      return numbers.filter(function (number) {
        return number % 2 === 0;
      });
    },
    logout() {
      window.sessionStorage.clear();
      this.$router.push("/login");
    },
    async getDetail() {
      // console.log("===== getDetail =====");
      const { data: res } = await this.$http.get(
        "/search/" + this.$route.query.schoolNo
      );
      if (res.code !== 0) {
        return this.$message.error("获取用户列表失败");
      }
      this.detailList = res.obj.sdVoluntaryReportList;
      this.positionMinMaxList = res.obj.positionMinMaxList;
      this.scoreMinMaxList = res.obj.scoreMinMaxList;
      console.log("=========: this.detail: " + this.detailList);
      // console.log("=========: this.positionMinMaxList: " + this.positionMinMaxList[0].year);
      // console.log("=========: this.scoreMinMaxList: " + this.scoreMinMaxList);
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
    // 页面跳转
    handleDetail(val) {
      console.log("===============majorNo: " + val.majorNo);
      // this.baseId = val.baseId;
      const { href } = this.$router.resolve({
        path: "/major",
        query: { majorNo: val.majorNo, major: val.major },
      });
      // window.open("#/smartSearch/detail", "_blank");
      window.open(href, "_blank");
    },
    drawLine() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      // 绘制图表
      myChart.setOption({
        title: {
          text: "",
        },
        tooltip: {
          trigger: "axis",
        },
        legend: {},
        toolbox: {
          show: true,
          feature: {
            dataZoom: {
              yAxisIndex: "none",
            },
            dataView: { readOnly: false },
            magicType: { type: ["line", "bar"] },
            restore: {},
            saveAsImage: {},
          },
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
        },
        yAxis: {
          type: "value",
          axisLabel: {
            formatter: "{value} °C",
          },
        },
        series: [
          {
            name: "Highest",
            type: "line",
            data: [10, 11, 13, 11, 12, 12, 9],
            markPoint: {
              data: [
                { type: "max", name: "Max" },
                { type: "min", name: "Min" },
              ],
            },
            markLine: {
              data: [{ type: "average", name: "Avg" }],
            },
          },
          {
            name: "Lowest",
            type: "line",
            data: [1, -2, 2, 5, 3, 2, 0],
            markPoint: {
              data: [{ name: "周最低", value: -2, xAxis: 1, yAxis: -1.5 }],
            },
            markLine: {
              data: [
                { type: "average", name: "Avg" },
                [
                  {
                    symbol: "none",
                    x: "90%",
                    yAxis: "max",
                  },
                  {
                    symbol: "circle",
                    label: {
                      position: "start",
                      formatter: "Max",
                    },
                    type: "max",
                    name: "最高点",
                  },
                ],
              ],
            },
          },
        ],
      });
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

.schoolName_div {
  width: 300px;
  height: 20px;
  margin: 0 auto;
}
.chart_div {
  display: flex;
  padding: 0 20px;
}
</style>