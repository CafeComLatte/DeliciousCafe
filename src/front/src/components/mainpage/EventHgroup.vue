<template>
	<hgroup class="flex space-between align-items-center">
		<h1 class="f-40">{{info.name}}</h1>
		<div class="inline-flex align-items-center">
			<span>더보기</span>
			<button @click="seeMore"><img :src="getImg('see_more.png')" /></button>
		</div>
	</hgroup>
</template>
<script setup>
import {ref,defineProps,computed,getCurrentInstance} from 'vue'

const v = ref(4);

const props = defineProps({
	name : {
		type: String
	},
	onSeeMore : {
		type: Function
	}
});

const {proxy} = getCurrentInstance();



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
	margin: 0 5px;
}

hgroup>div>span {
	margin-right: 10px;
	font-size: 20px;
}

</style>