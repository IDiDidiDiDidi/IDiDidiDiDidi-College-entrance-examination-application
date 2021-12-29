<template>
  <el-container class="home-container">
    <el-header>
      <h1></h1>
      <el-button type="info" @click="logout">退出</el-button>
    </el-header>
    <el-main>
      <div class="schoolName_div">
        <h2>{{ this.$route.query.major }}</h2>
      </div>
    </el-main>
    <el-footer>Footer</el-footer>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      detail: [],
    };
  },
  created() {
    this.getMajorDetail();
  },
  methods: {
    async getDetail() {
      // console.log("===== getDetail =====");
      const { data: res } = await this.$http.get(
        "/search/" + this.$route.query.schoolNo + "/major"
      );
      if (res.code !== 0) {
        return this.$message.error("获取专业信息列表失败");
      }
      this.detail = res.obj.data;
      console.log("============ majorDetail: " + this.detail);
    },
  },
};
</script>

<style>
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
</style>