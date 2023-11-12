<template>
	<hgroup>
		<h1 class="f-40">{{info.name}}</h1>
		<div>
			<span>더보기</span>
			<button @click="seeMore"><img :src="getImg('see_more.png')" /></button>
		</div>
	</hgroup>
</template>
<script setup>
import {defineProps,computed,getCurrentInstance} from 'vue'
const {proxy} = getCurrentInstance();

const props = defineProps({
	name : {
		type: String
	},
	onSeeMore : {
		type: Function
	}
});

const seeMore = () => {
	info.value.onSeeMore();
};

const info = computed(()=>{
	return props;
});

const getImg = (img) =>{
	return proxy.$getImgFormat(img);
};
</script>
<style scoped>
hgroup {
	display: flex;
	justify-content: space-between;
	margin: 0 5px;
}

hgroup>div {
	display: inline-flex;
	align-items: center;
}

hgroup>div>span {
	margin-right: 10px;
	font-size: 20px;
}

</style>