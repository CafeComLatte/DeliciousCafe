import {createRouter, createWebHistory} from 'vue-router'
import HelloWorld from '@/components/HelloWorld.vue'
import TestWorld from '@/components/TestWorld.vue'

const routes = [
	
	{path: "/hello", name : "HelloWorld", component:HelloWorld},
	{path: "/test", name : "TestWorld", component:TestWorld}
]

const router = createRouter({
	history: createWebHistory(),
	base: process.env.BASE_URL,
	routes
});

export default router;