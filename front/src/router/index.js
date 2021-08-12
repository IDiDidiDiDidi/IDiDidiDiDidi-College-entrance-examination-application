import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import User from '../components/user/User.vue'
import SmartSearch from '../components/SmartSearch.vue'

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    { path: '/', redirect: '/login' },
    { path: '/login', component: Login },
    { path: '/home', component: Home },
    { path: '/user', component: User },
    { path: '/smartSearch', component: SmartSearch },
  ]
})

// 挂载路由导航卫士
router.beforeEach((to, from, next) => {
  if(to.path === '/login') return next()

  if(to.path === '/smartSearch') return next()
  if(to.path === '/user') return next()

  // 获取 token
  const tokenStr = window.sessionStorage.getItem('token')
  if(!tokenStr) return next('/login')
  next()
})


export default router