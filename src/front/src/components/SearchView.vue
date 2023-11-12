<template>
	<div id="search">
		<div id="search_wrap">
			<button @click="search(search_name)" class="search_button"><img :src="getFormat('search_product.png', 'image')" /></button>
			<input v-model="search_name" type="text" :search_place_holder="info.search_place_holder" />
			<button class="cancel_button"><img :src="getFormat('cancel.png', 'image')" /></button>
		</div>
	</div>
</template>
<script setup>
import {getCurrentInstance,defineProps,ref,computed} from 'vue'
const {proxy} = getCurrentInstance();

const v = ref(3);

const props = defineProps({
	search_place_holder : {
		type: String,
		required: true
	},
	onSearch: {
		type: Function
	}
});

const search_name = ref('');

const info = computed(()=>{
	return props;
});

const search = (search_name) => {
	info.value.onSearch(search_name);
}

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
<style scoped>
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