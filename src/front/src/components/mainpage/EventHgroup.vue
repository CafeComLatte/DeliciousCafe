<template>
	<hgroup class="flex space-between align-items-center">
		<h1 class="f-40">{{info.name}}</h1>
		<div @click="seeMore" class="inline-flex align-items-center pointer">
			<span>더보기</span>
			<!--<button><img :src="getImg('see_more.png')" /></button>-->
			<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="20">
				<path d="M480-80q-75 0-140.5-28.5t-114-77q-48.5-48.5-77-114T120-440h80q0 117 81.5 198.5T480-160q117 0 198.5-81.5T760-440q0-117-81.5-198.5T480-720h-6l62 62-56 58-160-160 160-160 56 58-62 62h6q75 0 140.5 28.5t114 77q48.5 48.5 77 114T840-440q0 75-28.5 140.5t-77 114q-48.5 48.5-114 77T480-80Z"/>
			</svg>
		</div>
	</hgroup>
</template>
<script setup>
import {ref,defineProps,computed,getCurrentInstance} from 'vue'

const v = ref(10);

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