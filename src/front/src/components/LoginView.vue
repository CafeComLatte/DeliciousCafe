<template>
	<div id="login">
		<h1>로그인페이지</h1>
	</div>
</template>
<script setup>
	import {onMounted} from 'vue'
	import {useStore} from 'vuex'
	const store = useStore();
	
	onMounted(async()=>{
		await store.dispatch('login');		
	})
	
	console.log(new Date());
</script>
<style scoped>
	
	
</style>