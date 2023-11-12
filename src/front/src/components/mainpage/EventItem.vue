<template>
	<div id="event_item">
		<img v-if="info.image!==''" :src="getFormat(info.image,'image')"/>		
	</div>	
</template>
<script setup>
import {ref,getCurrentInstance,defineProps} from 'vue'
const v = ref(32);
const {proxy} = getCurrentInstance();

const props = defineProps({
	info : {
		id:{
			type:String,
			default:''
		},
		image:{
			type:String,
			default:''
		}
	}
});


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
<style scoped>
#event_item {
	height : 200px;
	width : 990px;
}

#event_item > img {
	height : 140px;
	width : 990px;
}
</style>