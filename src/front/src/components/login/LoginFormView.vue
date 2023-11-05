<template>
	<AlertDialog v-if="dialog_alert"
				:dialog="dialog_alert" 
				:onClose="close" 
				:content="dialog_alert_info.content" 
				:dialog_type="dialog_alert_info.dialog_type">
	</AlertDialog>
		
	<v-form ref="loginForm" validate-on="input" v-model="isValid">
		<v-responsive>
			<v-text-field v-model="user_data.id" label="id" type="id" :rules="[rules.required]" variant="solo"
				prepend-inner-icon="getImg('person_uncheck.png')" />
			<v-text-field v-model="user_data.password" label="password" type="password" :rules="[rules.required]"
				autoComplete="on" variant="solo" prepend-inner-icon="mdi-map-marker" />
			<v-btn @click="login" :disabled="!isValid">로그인</v-btn>
		</v-responsive>
	</v-form>
</template>
<script setup>
import { ref, getCurrentInstance, computed } from 'vue'

const v = ref(19);

const { proxy } = getCurrentInstance();

const isValid = ref(false);

const user_data = ref({ id: '', password: '' });

const loginForm = ref('');

const rules = {};
rules.required = value => !!value || '필수입력 사항입니다.';

const login = () => {
	proxy.$store.dispatch('login', user_data.value).then(res => {
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

const dialog_alert = computed(() => {	
	return proxy.$store.state.dialog_alert;
});

const dialog_alert_info = computed(()=>{
	return proxy.$store.state.dialog_alert_info;
});

const openDialogAlert = (data) => {	
	proxy.$store.dispatch('openDialogAlert',data);
};

const close = () => {
	const type = proxy.$store.state.dialog_alert_info.callback_type;
	proxy.$store.dispatch('closeDialogAlert');
	if(type === 'loginSuccess'){
		proxy.$router.push('/site/main');
	}
};
</script>
<style></style>