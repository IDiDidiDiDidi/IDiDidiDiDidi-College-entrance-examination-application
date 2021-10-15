<template>
  <div id="ServiceDetail">
    <div class="banner container-fuild text-center">相关服务</div>
    <div class="container">
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-3" id="myScrollspy">
          <ul class="nav nav-tabs nav-stacked center-block" id="myNav">
            <p>汽车吊</p>
            <li
              :class="item.id == id ? 'active' : ''"
              v-for="(item, index) in serviceNavList"
              :key="index"
            >
              <a :href="'#' + item.id">{{ item.title }}</a>
            </li>
          </ul>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-9 content wow zoomIn">
          <div class="content-name">
            <h1>{{ this.detail.name }}</h1>
          </div>
          <el-divider></el-divider>
          <!-- img  -->
          <div class="demo-image__lazy" id='img'>
            <el-image v-for="url in imgs" :key="url" :src="url" lazy></el-image>
          </div>
          <el-divider></el-divider>
          <!-- 参数表 -->
          <!-- <el-card class="box-card"> -->
          <el-descriptions
            class="margin-top"
            title="产品参数"
            :column="2"
            border
            id="description"
          >
            <!-- <template slot="extra">
              <el-button type="primary" size="small">操作</el-button>
            </template> -->
            <el-descriptions-item>
              <template slot="label"> 型号 </template>
              {{ this.detail.chassisBrand }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 主钩绞车 </template>
              {{ this.detail.mainHookWinch }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 底盘型号 </template>
              {{ this.detail.chassisModel }}
            </el-descriptions-item>

            <template v-if="detail.tonnage != '8'">
              <el-descriptions-item>
                <template slot="label"> 副钩绞车 </template>
                {{ this.detail.secondaryHookWinch }}
              </el-descriptions-item>
            </template>

            <el-descriptions-item>
              <template slot="label"> 最大起重量 </template>
              {{ this.detail.tonnage }}吨
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 减速机型号 </template>
              {{ this.detail.reducerModel }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 最大起升高度 </template>
              {{ this.detail.liftingHeight }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 回转支撑 </template>
              {{ this.detail.slewingSupport }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 吊臂U型 </template>
              {{ this.detail.ushapedBoom }}
            </el-descriptions-item>

            <template v-if="detail.tonnage === '8'">
              <el-descriptions-item>
                <template slot="label"> 液压系统 </template>
                {{ this.detail.hydraulicSystem }}
              </el-descriptions-item>
            </template>
            <template v-else>
              <el-descriptions-item>
                <template slot="label"> 发动机三泵 </template>
                {{ this.detail.engineThreePumps }}
              </el-descriptions-item>
            </template>

            <el-descriptions-item>
              <template slot="label"> 支腿跨距（横*纵） </template>
              {{ this.detail.outriggerSpan }}
            </el-descriptions-item>

            <template v-if="detail.tonnage != '8'">
              <el-descriptions-item>
                <template slot="label"> 电机三泵 </template>
                {{ this.detail.motorThreePumps }}
              </el-descriptions-item>
            </template>

            <el-descriptions-item>
              <template slot="label"> 大架 </template>
              {{ this.detail.bigFrame }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 外形尺寸 </template>
              {{ this.detail.dimensions }}
            </el-descriptions-item>

            <template v-if="detail.tonnage != '8'">
              <el-descriptions-item>
                <template slot="label"> 中心回转 </template>
                {{ this.detail.centerRotation }}
              </el-descriptions-item>
            </template>

            <template v-if="detail.tonnage != '8'">
              <el-descriptions-item>
                <template slot="label"> 电机功率 </template>
                {{ this.detail.motorPower }}
              </el-descriptions-item>
            </template>

            <template v-if="detail.tonnage != '8'">
              <el-descriptions-item>
                <template slot="label"> 起升速度（副主钩） </template>
                {{ this.detail.liftingSpeed }}
              </el-descriptions-item>
            </template>

            <template v-if="detail.tonnage != '8'">
              <el-descriptions-item>
                <template slot="label"> 大臂 </template>
                {{ this.detail.bigArm }}
              </el-descriptions-item>
            </template>

            <template v-if="detail.tonnage != '8'">
              <el-descriptions-item>
                <template slot="label"> 回转速度 </template>
                {{ this.detail.swingSpeed }}
              </el-descriptions-item>
            </template>

            <el-descriptions-item>
              <template slot="label"> 后移位项 </template>
              {{ this.detail.backShift }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 发动机型号 </template>
              {{ this.detail.engineModel }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 方向形式 </template>
              {{ this.detail.directionForm }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 发动机功率 </template>
              {{ this.detail.enginePower }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 刹车形式 </template>
              {{ this.detail.brakingForm }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 轮胎型号 </template>
              {{ this.detail.tyreModel }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 变速箱 </template>
              {{ this.detail.gearbox }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 行驶速度 </template>
              {{ this.detail.speed }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 操作室 </template>
              {{ this.detail.operatingRoom }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 轴距 </template>
              {{ this.detail.wheelbase }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 实例/公告重量 </template>
              {{ this.detail.weight }}
            </el-descriptions-item>
          </el-descriptions>
          <el-descriptions class="margin-top" :column="1" border>
            <el-descriptions-item>
              <template slot="label"> 其他配置 </template>
              {{ this.detail.otherConfiguration }}
            </el-descriptions-item>
            <el-descriptions-item>
              <template slot="label"> 选配 </template>
              {{ this.detail.optional }}
            </el-descriptions-item>
          </el-descriptions>
          <!-- </el-card> -->
          <div
            class="content-block"
            v-for="(item, index) in serviceContentList"
            :key="index"
          >
            <h2 :id="item.id">
              {{ item.title }}
              <small>/ {{ item.eng_title }}</small>
            </h2>
            <div v-html="item.content"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { WOW } from "wowjs";
// import axios from 'axios'
export default {
  name: "ServiceDetail",
  data() {
    return {
      detail: "",
      name: "",
      imgs: "",
      urls: [
          'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg',
          'https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg',
          'https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg',
          'https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg',
          'https://fuss10.elemecdn.com/d/e6/c4d93a3805b3ce3f323f7974e6f78jpeg.jpeg',
          'https://fuss10.elemecdn.com/3/28/bbf893f792f03a54408b3b7a7ebf0jpeg.jpeg',
          'https://fuss10.elemecdn.com/2/11/6535bcfb26e4c79b48ddde44f4b6fjpeg.jpeg'
        ],
      //   查询参数
      queryInfo: {
        baseId: "",
      },
      id: "section-1",
      serviceNavList: [
        {
          id: "img",
          title: "产品详情",
        },
        {
          id: "description",
          title: "产品参数",
        },
        {
          id: "section-3",
          title: "产品优势",
        },
        {
          id: "section-4",
          title: "关于我们",
        },
      ],
      serviceContentList: [
        {
          id: "section-3",
          title: "产品优势",
          eng_title: "Product advantages",
          content:
            "<h3>这是标题1</h3><p>这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。</p><h3>这是标题2</h3><p>这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。</p>",
        },
        {
          id: "section-4",
          title: "关于我们",
          eng_title: "About Us",
          content:
            "<h3>这是标题1</h3><p>这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。</p><h3>这是标题2</h3><p>这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。这里是内容，请根据实际需要修改。</p>",
        },
      ],
    };
  },
  created() {
    this.getSearch();
    this.getImgs();
  },
  methods: {
    async getSearch() {
      // console.log("=========: start getDetail", this.$route.params.baseId);
      console.log("=========: start getDetail", this.$route.query.id);

      const { data: res } = await this.axios.get(
        "/crane/" + this.$route.query.id
      );
      // console.log(res);
      console.log("=========: res", res);
      if (res.code !== 0) {
        return this.$message.error("获取用户列表失败");
      }
      this.detail = res.obj;
      // this.name = this.detail.name;
      console.log("=========: this.detail.name: " + this.name);
    },
    async getImgs() {
      // console.log("=========: start getDetail", this.$route.params.baseId);
      console.log("=========: start getDetail", this.$route.query.id);

      const { data: res } = await this.axios.get(
        "/crane/img/" + this.$route.query.id
      );
      // console.log(res);
      console.log("=========: res", res);
      if (res.code !== 0) {
        return this.$message.error("获取照片信息列表失败");
      }
      this.imgs = res.obj;
      // this.name = this.detail.name;
      console.log("=========: this.imgs: " + this.imgs);
    },
  },
  mounted() {
    this.id = this.$route.params.id;
    // var top = document.getElementById(this.id).offsetTop;
    $(window).scrollTop(top + 300);
    $("#myNav").affix({
      offset: {
        top: 300,
      },
    });
    var wow = new WOW();
    wow.init();
  },
};
</script>
<style scoped>
.banner {
  color: #fff;
  font-size: 30px;
  height: 150px;
  line-height: 150px;
  background-image: url("../assets/img/banner_2.jpg");
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: scroll;
  background-position: center center;
}
ul.nav-tabs {
  width: 200px;
  margin-top: 40px;
  border-radius: 4px;
  background: #fff;
  z-index: 99999;
  border: 1px solid #474747;
  box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
}
ul.nav-tabs li {
  text-align: center;
  margin: 0;
  border-top: 1px solid #474747;
}
ul.nav-tabs p {
  color: #fff;
  font-size: 18px;
  font-weight: bold;
  text-align: center;
  background: #474747;
  margin: 0;
  padding: 10px 0;
}
ul.nav-tabs li:first-child {
  border-top: none;
}
ul.nav-tabs li a {
  margin: 0;
  padding: 8px 16px;
  border-radius: 0;
}
ul.nav-tabs li.active a,
ul.nav-tabs li.active a:hover {
  color: #fff;
  background: #474747;
  border: 1px solid #474747;
}
ul.nav-tabs li:first-child a {
  border-radius: 4px 4px 0 0;
}
ul.nav-tabs li:last-child a {
  border-radius: 0 0 4px 4px;
}
ul.nav-tabs.affix {
  top: 30px;
}
.content-block {
  margin: 50px 0;
}
.content-block > h2 {
  padding: 20px 0;
  border-bottom: 1px solid #ccc;
}
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 480px;
}
</style>
