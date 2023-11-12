<template>
	<div id="page">
		<a @click="changePage(currentPage - 1)">&lt;</a>
		<a v-for="(paging, index) in props.totalPages" :key="index" @click="changePage(paging -1)">{{ paging }}</a>
		<a @click="changePage(currentPage + 1)">&gt;</a>
	</div>
</template>
<script setup>
import {defineProps,ref} from 'vue'

const v = ref(3);

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
<style scoped>
#page {
	margin: 10px 0;
	text-align: center;
}

#page>a {
	margin: 0 5px;
	cursor: pointer;
}
</style>