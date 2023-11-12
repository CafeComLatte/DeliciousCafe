<template>
	<div id="eventproduct_wrap">
		<EventHgroup name="이벤트 상품" :onSeeMore="seeMore"/>
		<Carousel :items-to-show="5" :wrap-around="true" v-if="data !== null">
			<Slide v-for="(product,index) in data" :key="index">
				<EventProductItem :product="product"/>
			</Slide>
			<template #addons>
				<Navigation />
			</template>
		</Carousel>
		<NoDataView v-else/>
	</div>
</template>
<script setup>
import EventHgroup from '@/components/mainpage/EventHgroup'
import EventProductItem from '@/components/mainpage/EventProductItem'
import { ref, getCurrentInstance, computed,defineProps } from 'vue'

import { Carousel, Navigation, Slide } from 'vue3-carousel'
import 'vue3-carousel/dist/carousel.css';
const v = ref(53);

const { proxy } = getCurrentInstance();

const props = defineProps({
	data : {
		type:Object
	}
});

const data = computed(() => {
	return props.data;
});

const seeMore = () => {
	proxy.$router.push('/site/products');
};
</script>
<style scoped>

#eventproduct_wrap {
	height: 340px;
	width: 1000px;
}

</style>