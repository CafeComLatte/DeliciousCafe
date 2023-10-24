<template>
	<div id="search">
		<div id="search_wrap">
			<button class="search_button"><img :src="getFormat('search_product.png', 'image')" /></button>
			<input type="text" :placeholder="searchPlaceholder" />
			<button class="cancel_button"><img :src="getFormat('cancel.png', 'image')" /></button>
		</div>
	</div>
</template>
<script setup>
import {getCurrentInstance,defineProps,ref} from 'vue'
const {proxy} = getCurrentInstance();

const v = ref(0);

const searchPlaceholder = ref(props.searchPlaceholder);

const props = defineProps({
	searchPlaceholder : {
		type: String,
		default: '상품 검색',
		required: true
	}
});


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
#search{
	width: 1000px;
	height: 60px;	
}


#search>#search_wrap {
	display: flex;
	justify-content: space-between;
	border: 1px solid black;
	border-radius: 20px;
	
}

#search>#search_wrap>* {
	display: inline-flex;
	align-items: center;
}

#search>#search_wrap>input {
	width: 900px;
	outline: none;
}

#search>#search_wrap>button {
	padding: 10px;
}

#search>#search_wrap>.cancel_button {
	visibility: hidden;
}

#search>#search_wrap>button>img {
	width: 25px;
	height: 25px;
}
</style>