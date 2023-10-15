import {createRouter, createWebHistory} from 'vue-router'


const routes = [
	
	{path: "/site", name : "MainView", component:()=> import('@/components/MainView.vue'),
		children : [
			{
				path : 'main',
				component:()=> import('@/components/MainPageView.vue')
			},
			{
				path : 'user',
				component:()=> import('@/components/UserView.vue')
			}
		]
	},
	{path: "/login", name : "LoginView", component:()=> import('@/components/LoginView.vue')},
	{path: "/signUp", name : "SignUpView", component:()=> import('@/components/SignUpView.vue')},
	{path: "/site/user", name : "UserView", component:()=> import('@/components/UserView.vue')}
	
]

const router = createRouter({
	history: createWebHistory(),
	base: process.env.BASE_URL,
	routes
});
/*
router.beforeEach((from)=>{
	if(from.name === 'MainView'){
		return {name:'MainView'};
	}
})
*/
export default router;