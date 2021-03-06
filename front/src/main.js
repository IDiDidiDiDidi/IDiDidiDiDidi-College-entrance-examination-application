import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
// 导入字体图标
import './assets/fonts/iconfont.css'
import './assets/css/global.css'
import axios from 'axios'
// 引入echarts
const echarts = require('echarts');
Vue.prototype.$echarts = echarts

// axios.defaults.baseURL = 'http://39.96.72.22:7350'
axios.defaults.baseURL = 'http://localhost:7350'
// axios.defaults.baseURL = 'http://127.0.0.1:8888/api/private/v1/'
Vue.prototype.$http = axios
axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
