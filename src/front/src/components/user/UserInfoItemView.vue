<template>	
	<li>
		<div v-if="info.type === 'account'" class="left">
			<p class="f-40">{{ info.info_value }}</p>
			<p>{{ user_id }}</p>
		</div>
		<div v-else class="left">
			<p>{{ info.info_value }}</p>
		</div>

		<div class="right">
			<button @click="openUserInfoChangeDialog"><img :src="getImg('edit.png')" /></button>
		</div>
	</li>
</template>
<script setup>
import { ref, defineProps, computed, getCurrentInstance } from 'vue'
const v = ref(25);

const { proxy } = getCurrentInstance();
const props = defineProps({
	info_name : {
		type: String		
	},
	info_value : {
		type: String
	},
	type : {
		type: String
	}
});

const info = computed(() => {
	return props;
});

const openUserInfoChangeDialog = () => {
	proxy.$store.dispatch('user/openUserInfoChangeDialog',{item_name:info.value.info_name,item_value:info.value.info_value});
};

const getImg = (img) => {
	return proxy.$getImgFormat(img);
};

const user_id = computed(() => {
	return localStorage.getItem('id');
});


</script>
<style scoped>
li:nth-child(1) {
	height: 130px;
	width: 960px;
	border-bottom: 1px solid silver;
}

li:nth-child(1)>.left {
	display: inline-block;
	margin: 20px 0;
}

li:nth-child(1)>.right {
	display: inline-block;
	margin: 48px 0;
}

li:nth-child(2) {
	height: 85px;
	width: 960px;
	border-bottom: 1px solid silver;
}

li:nth-child(2)>.left {
	display: inline-block;
	margin: 30px 0;
}

li:nth-child(2)>.right {
	display: inline-block;
	margin: 26px 0;
}

li:nth-child(3) {
	height: 85px;
	width: 960px;
}

li:nth-child(3)>.left {
	display: inline-block;
	margin: 30px 0;
}

li:nth-child(3)>.right {
	display: inline-block;
	margin: 26px 0;
}
</style>