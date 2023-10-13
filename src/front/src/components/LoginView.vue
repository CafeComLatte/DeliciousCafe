<template>
	<div id="login">
		<div id="login_image_wrap">
			<img id="login_image" :src="getImg('login_picture.jpg')" />	
		</div>		
		<div id="login_wrap">
			<v-form ref="loginForm" validate-on="input" v-model="isValid">
				<v-responsive>
					<v-text-field v-model="user_data.id" label="id" type="id" :rules="[rules.required]" variant="solo" prepend-inner-icon="getImg('person_uncheck.png')"/>
					<v-text-field v-model="user_data.password" label="password" type="password" :rules="[rules.required]" autoComplete="on" variant="solo" prepend-inner-icon="mdi-map-marker"/>
					<v-btn @click="login(user_data)" :disabled="!isValid">로그인</v-btn>
				</v-responsive>
			</v-form>
		</div>
	</div>
</template>
<script setup>
	import router from '../router/router'
	import { ref, getCurrentInstance } from 'vue'

	const {proxy} = getCurrentInstance();

	const a = ref(7);

	const isValid = ref(false);

	const user_data = ref({id:'',password:''});

	const loginForm = ref('');

	const rules = {};
	rules.required = value => !!value || '필수입력 사항입니다.';

	const login = async(user_data) => {
		await proxy.$store.dispatch('login',user_data).then(res=>{
			console.log('login data : ' + res);
			if (res.data.result === true) {
				localStorage.setItem('id', user_data.id);
				localStorage.setItem('name', user_data.name);

				console.log("login success id :" + localStorage.getItem('id') + ', name : ' + localStorage.getItem('name'));
				router.push('/site');
			}else{
				loginForm.value.reset();	
			}
		});
	};

	const getImg = (img) =>{
		return require(`../assets/img/${img}`);
	};
</script>
<style scoped>
#login {
	width: 1263px;
	background-color: #f7f7f7;
}

#login > #login_wrap {
	margin-left: auto;
	margin-right: auto;
	height: 290px;
	width: 600px;
}

#login > #login_image_wrap{
	margin-left: auto;
	margin-right: auto;
	height: 300px;
	width: 600px;
}

#login > #login_image_wrap > #login_image {
	height: 300px;
	width: 600px;
}

</style>