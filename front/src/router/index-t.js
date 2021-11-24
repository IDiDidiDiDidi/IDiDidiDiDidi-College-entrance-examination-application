import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import User from '../components/user/User.vue'

import SmHome from '../components/smartSearch/Home.vue'
import SmartSearch from '../components/smartSearch/SmartSearch.vue'
import SmartSearch2021 from '../components/smartSearch/SmartSearch2021.vue'
import Detail from '../components/smartSearch/Detail.vue'
import Demo from '../components/smartSearch/demo/Demo.vue'

Vue.use(VueRouter)

const router = new VueRouter({
  routes: [
    { path: '/', redirect: '/smartSearch' },
    { path: '/login', component: Login },
    { path: '/home', component: Home },
    { path: '/user', component: User },
    { path: '/sm/home', component: SmHome },
    { path: '/smartSearch', component: SmartSearch },
    { path: '/sm2021', component: SmartSearch2021 },
    { path: '/smartSearch/detail', component: Detail },
    { path: '/smartSearch/demo', component: Demo }
  ]
})

// 挂载路由导航卫士
router.beforeEach((to, from, next) => {
  if(to.path === '/login') return next()
  if(to.path === '/sm/home') return next()
  if(to.path === '/smartSearch') return next()
  if(to.path === '/sm2021') return next()
  if(to.path === '/smartSearch/detail') return next()
  if(to.path === '/smartSearch/demo') return next()
  if(to.path === '/user') return next()

  // 获取 token
  const tokenStr = window.sessionStorage.getItem('token')
  if(!tokenStr) return next('/smartSearch')
  next()
})


export default router