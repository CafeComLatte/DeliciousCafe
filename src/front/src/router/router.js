import {createRouter, createWebHistory} from 'vue-router'
import {ref} from 'vue'

const v = ref(6);

const routes = [
	
	{path: "/site", name : "MainView", component:()=> import('@/components/MainView.vue'),
		children : [
			{
				path : 'main',
				component:()=> import('@/components/MainPageView.vue')
			},
			{
				path : 'user',
				component:()=> import('@/components/user/UserView.vue')
			},
			{
				path : 'products',
				component:()=> import('@/components/ProductListView.vue')
			},
			{
				path : 'payments',
				component:()=> import('@/components/PaymentListView.vue'),
				hash: '#payment_list'
			},
			{
				path : 'products/:id',
				component:()=> import('@/components/ProductDetailsView.vue'),
				props:true
			}
		]
	},
	{path: "/login", name : "LoginView", component:()=> import('@/components/login/LoginView.vue')},
	{path: "/signUp", name : "SignUpView", component:()=> import('@/components/signup/SignUpView.vue')}
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