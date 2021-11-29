import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'
// import Home from '../components/smartSearch/Home.vue'
// import Login from '../components/Login.vue'
Vue.use(VueRouter)

const routes = [
	{
		path: '/',
		component: () => import('../components/smartSearch/Home.vue'),
		redirect: '/welcome',
	},
	{
		path: '/home',
		name: 'Home',
		component: () => import('../components/smartSearch/Home.vue'),
		redirect: '/welcome',
		children: [
			{
				path: '/welcome',
				name: 'welcome',
				component: () => import('../components/smartSearch/Welcome')
			},
			{
				path: '/sm2020',
				name: 'sm2020',
				component: () => import('../components/smartSearch/sm2020/Sm2020')
			},
			{
				path: '/sm2021',
				name: 'sm2021',
				component: () => import('../components/smartSearch/sm2021/Sm2021')
			},
			// {
			// 	path:'/detail',
			// 	name:'detail',
			// 	component:()=>import('../components/smartSearch/detail/Detail')
			// },
		]
	},
	{
		path: '/detail',
		name: 'detail',
		component: () => import('../components/smartSearch/detail/Detail')
	},
	{
		path: '/detailTest',
		name: 'DetailTest',
		component: () => import('../components/smartSearch/detail/DetailTest')
	},
	{
		path: '/echart',
		name: 'echart',
		component: () => import('../components/EchartTest')
	},
]

const router = new VueRouter({
	routes
})

// router.beforeEach((to,from,next)=>{
// 	const token = window.sessionStorage.getItem('token');
// 	if(to.path!=='/login'){
// 		if(!token){
// 			next('/login')
// 		}else{
// 			next()
// 		}
// 	}else{   
// 		next()
// 	}

// })



export default router
