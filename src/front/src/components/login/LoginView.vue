<template>
	<div id="login">
		<div id="login_image_wrap">
			<img id="login_image" :src="getImg('login_picture.jpg')" />
		</div>
		<div id="login_wrap">
			<LoginFormView/>
		</div>
	</div>
</template>
<script setup>
import LoginFormView from '@/components/login/LoginFormView'
import { ref, getCurrentInstance } from 'vue'

const { proxy } = getCurrentInstance();

const a = ref(17);

const getImg = (img) => {
	return proxy.$getImgFormat(img);
};
</script>
<style scoped>
#login {
	width: 1263px;
	height: 600px;
	margin: 0 auto;
}

#login>#login_wrap {
	padding-top: 30px;
	margin-left: auto;
	margin-right: auto;
	height: 250px;
	width: 600px;
}

#login>#login_image_wrap {
	padding-top: 20px;
	margin-left: auto;
	margin-right: auto;
	height: 350px;
	width: 600px;
}

#login>#login_image_wrap>#login_image {
	height: 350px;
	width: 600px;
}
</style>