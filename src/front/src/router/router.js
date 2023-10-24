import {createRouter, createWebHistory} from 'vue-router'
import {ref} from 'vue'

const v = ref(5);

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
			},
			{
				path : 'products',
				component:()=> import('@/components/ProductListView.vue'),
				hash: '#product_list'
			},
			{
				path : 'payments',
				component:()=> import('@/components/PaymentListView.vue'),
				hash: '#payment_list'
			},
		]
	},
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