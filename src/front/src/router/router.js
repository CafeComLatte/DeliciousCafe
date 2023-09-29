import {createRouter, createWebHistory} from 'vue-router'


const routes = [
	
	{path: "/hello", name : "MainPageView", component:()=> import('@/components/MainPageView.vue')},
	{path: "/test", name : "TestWorld", component:()=> import('@/components/TestWorld.vue')}
]

const router = createRouter({
	history: createWebHistory(),
	base: process.env.BASE_URL,
	routes
});

export default router;