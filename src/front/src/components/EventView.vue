<template>
	<div id="event_wrap">
		<img v-if="store.getters.getEvent.image" v-bind:src="getImg(store.getters.getEvent.image)" />				
	</div>
</template>
<script setup>
import {useStore} from 'vuex'

const store = useStore();

const getImg = (img) =>{
	return require(`../assets/img/${img}`);
};



</script>
<style>
#event_wrap {
	height : 140px;
	width : 700px;
	padding : 5px;
	margin : 5px auto 25px auto;
}

#event_wrap > img {
	
	height : 140px;
	width : 700px;
}
</style>