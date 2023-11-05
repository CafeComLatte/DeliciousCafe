<template>
	<li>
		<div class="left">
			<img :src="getImg(user_setting_info.image)" />
			<span>{{user_setting_info.name}}</span>
		</div>
		<div class="right">
			<input v-model="user_setting_info.value" true-value="true" false-value="false" role="switch" type="checkbox" />
		</div>
	</li>
</template>
<script setup>
import { ref,getCurrentInstance,defineProps,computed } from 'vue'
const v = ref(2);

const { proxy } = getCurrentInstance();

const props = defineProps({
	name : {
		type: String
	},
	image : {
		type: String	
	},
	value : {
		type: Boolean
	}
});

const user_setting_info = computed(()=>{
	return props;
});

const getImg = (img) => {
	return proxy.$getImgFormat(img);
};
</script>
<style scoped>
li {
	height: 65px;
	width: 960px;
}

li:nth-child(1) {
	border-bottom: 1px solid silver;
}

li:nth-child(1)>.left {
	margin: 20px 0;
	display: flex;
	justify-content: center;
}

li:nth-child(1)>.right {
	margin-top: 23px;
	display: inline;
}

li:nth-child(2)>.left {
	margin: 20px 0;
	display: flex;
	justify-content: center;
}

li:nth-child(2)>.right {
	margin-top: 23px;
	display: inline;
}

[type="checkbox"] {
	appearance: none;
	position: relative;
	border: max(2px, 0.1em) solid gray;
	border-radius: 1.25em;
	width: 2.25em;
	height: 1.25em;
}

[type="checkbox"]::before {
	content: "";
	position: absolute;
	left: 0;
	width: 1em;
	height: 1em;
	border-radius: 50%;
	transform: scale(0.8);
	background-color: gray;
	transition: left 250ms linear;
}

[type="checkbox"]:checked {
	background-color: tomato;
	border-color: tomato;
}

[type="checkbox"]:checked::before {
	background-color: white;
	left: 1em;
}

[type="checkbox"]:disabled {
	border-color: lightgray;
	opacity: 0.7;
	cursor: not-allowed;
}

[type="checkbox"]:disabled:before {
	background-color: lightgray;
}

[type="checkbox"]:disabled+span {
	opacity: 0.7;
	cursor: not-allowed;
}

[type="checkbox"]:focus-visible {
	outline-offset: max(2px, 0.1em);
	outline: max(2px, 0.1em) solid tomato;
}

[type="checkbox"]:enabled:hover {
	box-shadow: 0 0 0 max(4px, 0.2em) lightgray;
}
</style>