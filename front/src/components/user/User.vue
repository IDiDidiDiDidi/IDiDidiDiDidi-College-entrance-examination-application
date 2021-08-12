<!--  -->
<template>
  <div class="">
    <el-card> 123 </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      queryInfo: {
        query: "",
        pagenum: 1,
        pagesize: 2,
      },
      searchInfo: {
        score: 660,
        scoreRange: 5,
        pageNum: 1,
        pageSize: 2,
      },
    };
  },
  created() {
    this.getUserList();
  },
  methods: {
    async getUserList() {
      const { data: res } = await this.$http.get("users", {
        params: this.queryInfo,
      });
      console.log(res);
    },
    async getSearch() {
      let that = this.$router;
      const { data: res } = await this.$http.get("search/list", {
        params: this.searchInfo,
      });
      console.log(res);
    },
  },
};
</script>
<style lang='less' scoped>
</style>