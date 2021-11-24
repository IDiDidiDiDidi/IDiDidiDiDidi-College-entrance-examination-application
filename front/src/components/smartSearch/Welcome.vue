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

              <el-form class="login_form" :model="loginForm" ref="loginFromRef">
                <!-- 用户名 -->
                <!-- <el-form-item prop="username">
                  <el-input
                    prefix-icon="iconfont icon-user"
                    v-model="loginForm.username"
                  ></el-input>
                </el-form-item>
                <el-form-item class="btns">
                  <el-button type="primary" @click="login">登录</el-button>
                </el-form-item> -->
                <div class="search_school">
                  <el-input
                    v-model="schoolName"
                    placeholder="请输入搜索学校"
                  ></el-input>
                  <el-form-item class="btns">
                    <el-button type="primary" @click="login">搜索</el-button>
                  </el-form-item>
                </div>
              </el-form>
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
      schoolName: "",
      //   查询参数
      queryInfo: {},
      loginForm: {},
    };
  },
  created() {},
  methods: {
    login() {},
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
