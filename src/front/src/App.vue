<template>
	<div>
		<router-view name="header"></router-view>
		<router-view name="navi"></router-view>
		<router-view name="main"></router-view>
		<router-view name="footer"></router-view>
		<router-view></router-view>
	</div>
</template>
<script setup>
import '@/assets/css/main.min.css'
import { ref } from 'vue'

const v = ref(40);

console.log("current mode : " + process.env);

</script>
<style></style>