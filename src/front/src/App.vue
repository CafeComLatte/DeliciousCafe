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
import { ref } from 'vue'

const v = ref(38);

console.log("current mode : " + process.env.VUE_APP_TEST);

</script>
<style scoped>
:global(*) {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	font-family: "Nanum HaNaSonGeurSsi";
	list-style: none;
	text-overflow: ellipsis;
	/*overflow: hidden;*/
	white-space: nowrap;
}

:global(.clearfix::after){
	content:""; 
	display:table; 
	clear:both;
}

:global(.left) {
	float: left;
}

:global(.right) {
	float: right;
}

:global(.f-40) {
	font-size: 40px;
}

:global(.f-30) {
	font-size: 30px;
}
:global(.f-20) {
	font-size: 20px;
}
:global(.f-10) {
	font-size: 10px;
}
</style>
