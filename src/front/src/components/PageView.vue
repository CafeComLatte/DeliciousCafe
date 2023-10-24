<template>
	<div id="page">
		<a @click="changePage(currentPage - 1)">&lt;</a>
		<a v-for="(paging, index) in totalPages" :key="index">{{ paging }}</a>
		<a @click="changePage(currentPage + 1)">&gt;</a>
	</div>
</template>
<script setup>
import {defineProps} from 'vue'

const props = defineProps({
	totalPages : {
		type: Number,
		default: 0,
		required:true
	},
	currentPage : {
		type: Number,
		default: 0,
		required:true
	},
	onChangePage : {
		type: Function,
		required:true
	}
});

const changePage = (page) => {
	props.onChangePage(page);
};

</script>
<style>
#page {
	margin: 10px 0;
	text-align: center;
}

#page>a {
	margin: 0 5px;
	cursor: pointer;
}
</style>