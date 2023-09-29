<template>
	<div id="event_wrap">
		<img v-bind:src="getImg(test)"/>			
	</div>
</template>
<script setup>
const test = "event1.png";
const getImg = (img) =>{
	return require(`../assets/img/${img}`);
};
</script>
<style>
#event_wrap {
	margin-top: 5px;
	margin-bottom : 25px;
	padding : 5px;
	text-align: center;
}

#event_wrap > img {
	
	height : 140px;
	width : 700px;
}
</style>