<template></template>

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
</style>