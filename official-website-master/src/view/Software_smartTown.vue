<template>
  <div id="smartTown">
    <!-- <div class="tqichediao">8吨汽车吊</div> -->
    <div id="Service">
      <div class="Service-container row">
        <div
          class="Service-item col-xs-12 col-sm-6 col-md-4 wow bounceInLeft"
          v-for="(item, index) in craneList2"
          :key="index"
          @click="ServiceClick(item.baseId)"
        >
          <div class="Service-item-wrapper">
            <div class="Service-item-top">
              <h4>{{ item.name }}</h4>
              <i></i>
              <p>{{ item.baseId }}</p>
            </div>
            <div class="Service-item-img">
              <img :src="item.img" alt="服务" />
              <!-- <img src="@/assets/img/diaoche/8t_tangjun_1.jpg" alt="服务" /> -->
            </div>
            <div class="Service-item-border"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { WOW } from "wowjs";
export default {
  name: "smartTown",
  data() {
    return {
      // ** 吨 吊车 列表
      craneList2: "",
    };
  },
  created() {
    this.getList();
  },
  mounted() {
    var wow = new WOW();
    wow.init();
  },
  methods: {
    async getList() {
      console.log("=========: start getDetail");

      const { data: res } = await this.axios.get(
        "/crane/tonnage/" + this.$route.query.t
      );
      // console.log(res);
      console.log("=========: res", res);
      if (res.code !== 0) {
        return this.$message.error("获取用户列表失败");
      }
      this.craneList2 = res.obj;
      console.log("=========: this.craneList2: " + this.craneList2);
    },
    ServiceClick(id) {
      this.$router.push({
        name: "craneetail",
        params: {
          baseId: id,
        },
      });
    },
  },
};
</script>
<style scoped>
/* .tqichediao{
    background-color: aqua;
} */
.smartTown {
  width: 60%;
}
.Service-container {
  padding: 30px 50px;
}
.Service-item {
  margin-bottom: 50px;
}
.Service-item-wrapper {
  cursor: pointer;
  background: rgba(244, 244, 244, 1);
  overflow: hidden;
  position: relative;
}
.Service-item-top {
  width: 100%;
  height: 120px;
  padding: 30px;
  text-align: center;
}
.Service-item-top > i {
  display: inline-block;
  width: 25px;
  height: 2px;
  background: #28f;
}
.Service-item-top > p {
  color: #b2b2b2;
  opacity: 0;
  transform: translateY(10px);
  transition: all 0.5s ease;
}
.Service-item-img {
  width: 100%;
  overflow: hidden;
}
.Service-item-img img {
  width: 100%;
  transition: all 0.5s ease;
}
.Service-item-border {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  margin: auto;
  z-index: 9999999;
  width: 100%;
  height: 100%;
  transition: all 0.5s ease;
  border: 1px solid #000;
  opacity: 0;
}
.Service-item-wrapper:hover .Service-item-top > i {
  opacity: 0;
}
.Service-item-wrapper:hover .Service-item-top > p {
  opacity: 1;
  transform: translateY(-10px);
}
.Service-item-wrapper:hover .Service-item-img > img {
  transform: scale(1.1, 1.1);
}
.Service-item-wrapper:hover > .Service-item-border {
  opacity: 1;
  width: 90%;
  height: 90%;
}
</style>


