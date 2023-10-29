<template>
	<div id="product_list">
		<div id="product_list_wrap">
			<SearchView searchPlaceholder="상품 검색"/>
			<div id="product">
				<table>
					<tbody>
						<tr v-for="(item, index) in itemList" :key="index" @click="goDetails(item.id)">
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
			<PageView :totalPages="totalPages" :currentPage="currentPage" :onChangePage="changePage"/>
		</div>
	</div>
</template>
<script setup>
import SearchView from '@/components/SearchView'
import PageView from '@/components/PageView'
import { ref, onMounted, getCurrentInstance } from 'vue'
import {useRouter} from 'vue-router'

const { proxy } = getCurrentInstance();
const router = useRouter();

const v = ref(8);
const itemList = ref([]);
const totalPages = ref(0);
const currentPage = ref(0);
const params = ref({ params: { page: 0, size: 3 } });

onMounted(async () => {
	await searchPage(params.value.params.page).then(res => {
		itemList.value.push(...res.data.elements);
		console.log(res.data.totalPages);
		totalPages.value = res.data.totalPages;
		currentPage.value = res.data.currentPage;
	});
});

const searchPage = (page) => {
	params.value.params.page = page;
	return proxy.$store.dispatch('getProducts', params.value);
};

const changePage = async (page) => {
	if (page >= 0 && page < totalPages.value) {
		await searchPage(page).then(res => {
			itemList.value = [];
			itemList.value.push(...res.data.elements);
			totalPages.value = res.data.totalPages;
			currentPage.value = res.data.currentPage;
		});
	}
};

const goDetails = (id) => {
	router.push('/site/products/'+id);
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
	border-bottom: 1px #e3e5e8 solid;
}

</style>