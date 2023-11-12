<template>
	<div id="product_list">
		<div id="product_list_wrap">
			<SearchView search_place_holder="상품 검색" :onSearch="search"/>
			<ProductTableView :items="items"/>
			<PageView :totalPages="totalPages" :currentPage="currentPage" :onChangePage="changePage"/>
		</div>
	</div>
</template>
<script setup>
import SearchView from '@/components/SearchView'
import ProductTableView from '@/components/product/ProductTableView'
import PageView from '@/components/PageView'
import { ref,getCurrentInstance } from 'vue'

const { proxy } = getCurrentInstance();

const v = ref(12);
const items = ref([]);
const totalPages = ref(0);
const currentPage = ref(0);
const params = ref({ params: { page: 0, size: 3, search_name:'' } });

init();

const changePage = async (page) => {
	if (page >= 0 && page < totalPages.value) {
		await searchPage(page).then(res => {
			items.value = [];
			items.value.push(...res.data.elements);
			totalPages.value = res.data.totalPages;
			currentPage.value = res.data.currentPage;
		});
	}
};

const search = (search_name) => {
	params.value.params.search_name = search_name;
	searchPageProduct();
};

function init(){
	searchPageProduct();
}

function searchPageProduct() {
	searchPage(params.value.params.page).then(res => {
		items.value = [];
		items.value.push(...res.data.elements);
		totalPages.value = res.data.totalPages;
		currentPage.value = res.data.currentPage;
	});
}

function searchPage(page) {
	params.value.params.page = page;
	return proxy.$store.dispatch('getProducts', params.value);
}
</script>
<style></style>