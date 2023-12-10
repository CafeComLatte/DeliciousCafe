import {createRouter, createWebHistory} from 'vue-router'
import {ref} from 'vue'
import HeaderView from '@/components/HeaderView.vue'
import NaviView from '@/components/NaviView.vue'
import MainView from '@/components/MainView.vue'
import FooterView from '@/components/FooterView.vue'

const v = ref(13);

const routes = [
	
	{path: "/site", name : "MainDefaultView", components: {header:HeaderView,navi:NaviView,main:MainView,footer:FooterView},
		children : [
			{
				path : 'main',
				component:()=> import(/* webpackChunkName: "main" */ '@/components/mainpage/MainPageView.vue')
			},
			{
				path : 'user',
				component:()=> import(/* webpackChunkName: "user" */ '@/components/user/UserView.vue')
			},
			{
				path : 'products',
				component:()=> import(/* webpackChunkName: "products" */ '@/components/product/ProductListView.vue')
			},
			{
				path : 'payments',
				component:()=> import(/* webpackChunkName: "payments" */ '@/components/PaymentListView.vue'),
				hash: '#payment_list'
			},
			{
				path : 'products/:id',
				component:()=> import(/* webpackChunkName: "productsid" */ '@/components/product/ProductDetailsView.vue'),
				props:true
			}
		]
	},
	{path: "/login", name : "LoginView", component:()=> import(/* webpackChunkName: "login" */ '@/components/login/LoginView.vue')},
	{path: "/signUp", name : "SignUpView", component:()=> import(/* webpackChunkName: "signup" */ '@/components/signup/SignUpView.vue')}
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