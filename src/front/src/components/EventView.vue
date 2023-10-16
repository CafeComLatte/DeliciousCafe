<template>
	<div id="event_wrap">
		<hgroup>
			<h1 class="f-40">이벤트</h1>
			<div>
				<span>더보기</span>
				<button><img :src="getImg('see_more.png')"/></button>
			</div>
		</hgroup>
		<img v-if="store.getters.getEvent.image" v-bind:src="getImg(store.getters.getEvent.image)" />				
	</div>
</template>
<script setup>
import {useStore} from 'vuex'
import {ref} from 'vue'

const v = ref(9);

const store = useStore();

const getImg = (img) =>{
	return require(`../assets/img/${img}`);
};



</script>
<style scoped>
#event_wrap {
	height : 200px;
	width : 1000px;
	padding : 5px;
	margin : 5px auto 25px auto;
}

#event_wrap > img {
	margin : 0 12px;
	height : 140px;
	width : 960px;
}

#event_wrap > hgroup {
	display : flex;
	justify-content: space-between;
	margin: 0 20px;
}

#event_wrap > hgroup > div {
	display : inline-flex;
	align-items: center;
}

#event_wrap > hgroup > div > span {
	margin-right: 10px;
	font-size: 20px;
}
</style>