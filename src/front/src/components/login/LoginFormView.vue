<template>
	<AlertDialog v-if="userStore.dialog_alert" :dialog="userStore.dialog_alert" :onClose="close"
		:content="userStore.dialog_alert_info.content" :dialog_type="userStore.dialog_alert_info.dialog_type">
	</AlertDialog>

	<form ref="loginForm" @submit.prevent="login">
		<LoginFormItem 
					name="id"
					:value="login_data.id"
					@update:value="newValue => login_data.id = newValue"/>
		<LoginFormItem 
					name="password"
					:value="login_data.password"
					@update:value="newValue => login_data.password = newValue"/>
		<button @keyup.enter="submit" :disabled="disabled" type="submit" tabIndex="3" class="w-500 h-50 f-20 background-silver pointer radius-5">로그인</button>	
	</form>
	<router-link to="/signUp" class="left f-20 gray">회원가입</router-link>
	<router-link to="#" class="right f-20 gray">아이디/비밀번호 찾기</router-link>
</template>
<script setup>
import LoginFormItem from '@/components/login/LoginFormItem'
import { ref, getCurrentInstance, computed} from 'vue'

const v = ref(57);

const { proxy } = getCurrentInstance();

const login_data = ref({id:'',password:''});

const loginForm = ref('');

const login = async () => {	
	try {
		const response = await proxy.$store.dispatch('user/login',login_data.value);
		if (response.data.error === '') {
			localStorage.setItem('id', response.data.data.id);
			openDialogAlert({ content: "로그인 성공", dialog_type: "", callback_type: "loginSuccess" });
		} else {
			openDialogAlert({ content: "로그인 실패", dialog_type: "", callback_type: "loginFail" });
			initLogin();
			
		}
	} catch (error) {
		openDialogAlert({ content: "로그인 실패", dialog_type: "", callback_type: "loginFail" });
		console.error("login front error : " + error);
		initLogin();
	}
};

const initLogin = () => {
	loginForm.value.reset();
	login_data.value.id = '';
	login_data.value.password = '';
};

const userStore = computed(() => {
	return proxy.$store.state.user;
});

const disabled = computed(() => {
	if(login_data.value.id === '' || login_data.value.password === '') return true;
	return false;
});

const openDialogAlert = (data) => {
	proxy.$store.dispatch('user/openDialogAlert', data);
};

const close = () => {
	const type = userStore.value.dialog_alert_info.callback_type;
	proxy.$store.dispatch('user/closeDialogAlert');
	if (type === 'loginSuccess') {
		proxy.$router.push('/site/main');
	}
};
</script>
<style></style>