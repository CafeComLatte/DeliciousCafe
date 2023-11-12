<template>
	<div class="carousel__item" @click="eventProduct">
		<img :src="getFormat(info.image, 'image')" />
		<p class="eventproduct_name left">{{ info.name }}</p>
		<p class="eventproduct_price right">{{ getFormat(info.price, 'price') }}</p>
	</div>
</template>
<script setup>
import { getCurrentInstance, defineProps, computed, ref } from 'vue'
const v = ref(8);
const { proxy } = getCurrentInstance();

const props = defineProps({
	product: {
		type: Object
	}
});

const info = computed(() => {
	return props.product;
});

const eventProduct = () => {
	alert('이벤트 상품 준비중입니다.');
};

const getFormat = (data, type) => {
	if (type === 'image') {
		return proxy.$getImgFormat(data);
	} else if (type === 'price') {
		return proxy.$getPriceFormat(data);
	} else if (type === 'date') {
		return proxy.$getDateFormat(data);
	} else {
		return;
	}
};
</script>
<style>
.carousel__item {
	height: 100%;
	width: 100%;
	font-size: 20px;
	border-radius: 8px;
	margin: 5px;
	cursor:pointer;
}

.carousel__item>img {
	height: 170px;
	width: 190px;
}
</style>