import {createRouter, createWebHistory} from 'vue-router'


const routes = [
	
	{path: "/site", name : "MainPageView", component:()=> import('@/components/MainPageView.vue')},
	{path: "/site/login", name : "LoginView", component:()=> import('@/components/LoginView.vue')},
	
]

const router = createRouter({
	history: createWebHistory(),
	base: process.env.BASE_URL,
	routes
});

export default router;