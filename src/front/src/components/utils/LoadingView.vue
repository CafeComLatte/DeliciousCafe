<template>
  <div class="spinner-container">
    <div class="spinner" />
  </div>
</template>

<script setup>
import {ref} from 'vue'
const v = ref(2);
</script>

<style scoped>
.spinner-container {
	position : absolute;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 50px;
	top : 40%;
	right : 50%;
}
.spinner {
	width: 50px;
	height: 50px;
	border-radius: 50%;
	border: 5px solid #e0e0e0;
	border-bottom: 5px solid #fe9616;
	animation: spin 1s linear infinite;
}
@keyframes spin {
	from {
		transform: rotate(0deg);
	}
	to {
		transform: rotate(360deg);
	}
}
</style>