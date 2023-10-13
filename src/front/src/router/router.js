import {createRouter, createWebHistory} from 'vue-router'


const routes = [
	
	{path: "/site", name : "MainView", component:()=> import('@/components/MainView.vue')},
	{path: "/login", name : "LoginView", component:()=> import('@/components/LoginView.vue')},
	{path: "/signUp", name : "SignUpView", component:()=> import('@/components/SignUpView.vue')}
	
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