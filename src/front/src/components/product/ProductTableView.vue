<template>
	<div id="product">
		<table>
			<tbody>
				<tr v-for="(item, index) in items" :key="index" @click="goDetails(item.id)" class="flex space-between">
					<img :src="getFormat(item.image, 'image')" />
					<div class="product_content inline-flex space-between column">
						<p class="f-40">{{ item.name }}</p>
						<p>{{ item.contents }}</p>
						<p>{{ getFormat(item.sys_date, 'date') }}</p>
					</div>
					<span class="inline-flex center align-items-center">{{ getFormat(item.price, 'price') }}</span>
				</tr>
			</tbody>
		</table>
	</div>
</template>
<script setup>
import {ref,getCurrentInstance,defineProps} from 'vue'
const v = ref(5);

const {proxy} = getCurrentInstance();

const props = defineProps({
	items: {
		type: Array
	}
});

const goDetails = (id) => {
	proxy.$router.push('/site/products/'+id);
};

const getFormat = (data,type) => {
	if(type === 'image'){
		return proxy.$getImgFormat(data);
	}else if( type === 'price'){
		return proxy.$getPriceFormat(data);
	}else if( type === 'date'){
		return proxy.$getDateFormat(data);
	}else{
		return;
	}
	
};

</script>
<style>
#product {
	width: 1000px;
	height: 450px;
}

#product>table>tbody>tr {
	width: 1000px;
	height: 150px;
	padding : 10px 0;
	cursor: pointer;
}

#product>table>tbody>tr > img {
	width : 200px;
}

#product>table>tbody>tr>.product_content{
	width: 600px;
	padding-left: 10px;
}


#product>table>tbody>tr>span{
	width: 200px;
}

#product>table>tbody>tr:nth-child(-n+2){
	border-bottom: 1px #e3e5e8 solid;
}

</style>