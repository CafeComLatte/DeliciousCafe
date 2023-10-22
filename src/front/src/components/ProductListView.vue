<template>
	<div id="product_list">
		<div id="product_list_wrap">
			<div id="search">
				<div id="search_wrap">
					<button class="search_button"><img :src="getFormat('search_product.png','image')" /></button>
					<input type="text" placeholder="상품 검색" />
					<button class="cancel_button"><img :src="getFormat('cancel.png','image')" /></button>
				</div>
			</div>
			<div id="product">
				<table>
					<tbody>
						<tr v-for="(item, index) in itemList" :key="index">
							<img :src="getFormat(item.image,'image')"/>
							<div class="product_content">
								<p class="f-40">{{item.name}}</p>
								<p>{{ item.contents }}</p>
								<p>{{ getFormat(item.sys_date,'date') }}</p>
							</div>
							<span>{{getFormat(item.price,'price')}}</span>
							
						</tr>
					</tbody>
				</table>
			</div>
			<div class="page">
				<a @click="changePage(currentPage - 1)">&lt;</a>
				<a v-for="(paging, index) in totalPages" :key="index">{{ paging }}</a>
				<a @click="changePage(currentPage + 1)">&gt;</a>
			</div>
			<div>

			</div>
		</div>
	</div>
</template>
<script setup>
import { ref, onMounted, getCurrentInstance } from 'vue'

const { proxy } = getCurrentInstance();


const v = ref(47);
const itemList = ref([]);
const totalPages = ref(0);
const currentPage = ref(0);
const params = ref({ params: { page: 0, size: 3 } });

onMounted(async () => {
	await searchPage(params.value.params.page).then(res => {

		itemList.value.push(...res.data.elements);
		totalPages.value = res.data.totalPages;
		currentPage.value = res.data.currentPage;
	});
});

const searchPage = (page) => {
	params.value.params.page = page;
	console.log(params.value);
	return proxy.$store.dispatch('getProducts', params.value);
};

const changePage = async (page) => {
	if (page >= 0 && page < totalPages.value) {
		await searchPage(page).then(res => {
			console.log(res.data);
			itemList.value = [];
			itemList.value.push(...res.data.elements);
			totalPages.value = res.data.totalPages;
			currentPage.value = res.data.currentPage;
		});
	}
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
#product_list {
	height: 600px;
	width: 1263px;
}

#product_list>#product_list_wrap {
	height: 600px;
	padding-top: 30px;
	margin: 0 auto;
	width: 1000px;
}

#product_list>#product_list_wrap>#search{
	width: 1000px;
	height: 60px;	
}


#product_list>#product_list_wrap>#search>#search_wrap {
	display: flex;
	justify-content: space-between;
	border: 1px solid black;
	border-radius: 20px;
	
}

#product_list>#product_list_wrap>#search>#search_wrap>* {
	display: inline-flex;
	align-items: center;
}

#product_list>#product_list_wrap>#search>#search_wrap>input {
	width: 900px;
	outline: none;
}

#product_list>#product_list_wrap>#search>#search_wrap>button {
	padding: 10px;
}

#product_list>#product_list_wrap>#search>#search_wrap>.cancel_button {
	visibility: hidden;
}

#product_list>#product_list_wrap>#search>#search_wrap>button>img {
	width: 25px;
	height: 25px;
}

#product_list>#product_list_wrap>#product {
	width: 1000px;
	height: 450px;
}

#product_list>#product_list_wrap>#product>table>tbody>tr {
	width: 1000px;
	height: 150px;
	display:flex;
	justify-content: space-between;
	padding : 10px 0;
}

#product_list>#product_list_wrap>#product>table>tbody>tr > img {
	width : 200px;
}

#product_list>#product_list_wrap>#product>table>tbody>tr>.product_content{
	width: 600px;
	display:inline-flex;
	justify-content: space-between;
	flex-direction: column;
	padding-left: 10px;
}


#product_list>#product_list_wrap>#product>table>tbody>tr>span{
	width: 200px;
	display:inline-flex;
	justify-content: center;
	align-items: center;
}

#product_list>#product_list_wrap>#product>table>tbody>tr:nth-child(-n+2){
	border-bottom: 1px silver solid;
}



#product_list>#product_list_wrap>.page {
	margin: 10px 0;
	text-align: center;
}

#product_list>#product_list_wrap>.page>a {
	margin: 0 5px;
	cursor: pointer;
}
</style>