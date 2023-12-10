<template>
	<div id="event_wrap">
		<EventHgroup name="이벤트" :onSeeMore="seeMore"/>
		<EventItem :info="info" v-if="info !== null"/>
		<NoDataView v-else/>				
	</div>
</template>
<script setup>
import EventHgroup from '@/components/mainpage/EventHgroup'
import EventItem from '@/components/mainpage/EventItem'
import {ref,computed,defineProps} from 'vue'
const v = ref(28);

const props = defineProps({
	event_data : {
		id :{
			type: String,
			default: ''
		},
		image : {
			type: String,
			default: ''
		}
	}
});

const info = computed(() => {
	return props.event_data;
});

const seeMore = () => {
	alert('이벤트 페이지는 준비중입니다.');
}



</script>
<style scoped>
#event_wrap {
	height : 200px;
	width : 1000px;
	padding : 5px;
	margin : 5px 0px 25px 0px;
}

#event_wrap > hgroup > div > span {
	margin-right: 10px;
	font-size: 20px;
}
</style>