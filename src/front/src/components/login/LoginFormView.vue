<template>
	<AlertDialog v-if="userStore.dialog_alert"
				:dialog="userStore.dialog_alert" 
				:onClose="close" 
				:content="userStore.dialog_alert_info.content" 
				:dialog_type="userStore.dialog_alert_info.dialog_type">
	</AlertDialog>
		
	<v-form ref="loginForm" validate-on="input" v-model="valid">
		<v-responsive>
			<v-text-field v-model="user_data.id" label="id" type="id" :rules="[rules.required]" variant="solo"
				prepend-inner-icon="getImg('person_uncheck.png')" />
			<v-text-field v-model="user_data.password" label="password" type="password" :rules="[rules.required]"
				autoComplete="on" variant="solo" prepend-inner-icon="mdi-map-marker" />
			<v-btn @click="login" :disabled="!valid">로그인</v-btn>
		</v-responsive>
	</v-form>
</template>
<script setup>
import { ref, getCurrentInstance, computed } from 'vue'

const v = ref(22);

const { proxy } = getCurrentInstance();

const valid = ref(false);

const user_data = ref({ id: '', password: '' });

const loginForm = ref('');

const rules = {};
rules.required = value => !!value || '필수입력 사항입니다.';

const login = () => {
	proxy.$store.dispatch('user/login', user_data.value).then(res => {
		try {
			if (res.data.error === '') {
				localStorage.setItem('id', user_data.value.id);
				
				openDialogAlert({content : "로그인 성공",dialog_type : "",callback_type:"loginSuccess"});
				
			} else {
				openDialogAlert({content : "로그인 실패",dialog_type : "",callback_type:"loginFail"});
				loginForm.value.reset();
			}
		} catch (error) {
			openDialogAlert({content : "로그인 실패",dialog_type : "",callback_type:"loginFail"});
			console.error("login front error : " + error);
		}
	}).catch(error => {
		openDialogAlert({content : "로그인 실패",dialog_type : "",callback_type:"loginFail"});
		console.error("login front error : " + error.response);
	});
};

const userStore = computed(() => {	
	return proxy.$store.state.user;
});

const openDialogAlert = (data) => {
	proxy.$store.dispatch('user/openDialogAlert',data);
};

const close = () => {
	const type = userStore.value.dialog_alert_info.callback_type;
	proxy.$store.dispatch('user/closeDialogAlert');
	if(type === 'loginSuccess'){
		proxy.$router.push('/site/main');
	}
};
</script>
<style></style>