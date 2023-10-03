<template>
	<div id="login">
		
		<h1> 로그인 페이지</h1>
	</div>
</template>
<script setup>
	import {useStore} from 'vuex'
	import {onMounted} from 'vue'
	
	const store = useStore();
	
	onMounted(async()=>{
		await store.dispatch('login');		
	})
	
	console.log(new Date());
</script>
<style>
</style>