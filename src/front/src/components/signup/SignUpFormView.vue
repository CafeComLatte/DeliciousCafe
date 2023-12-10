<template>
	<AlertDialog v-if="dialog_alert" :dialog="dialog_alert" :onClose="close" :content="dialog_alert_info.content"
		:dialog_type="dialog_alert_info.dialog_type">
	</AlertDialog>

	<form id="signUpForm">
		<SignUpFormItem name="id" v-model="signup_data.id" :error_message="error_message.id"/>
		<SignUpFormItem name="password" v-model="signup_data.password" :error_message="error_message.password"/>
		<SignUpFormItem name="password" v-model="check_password" :error_message="error_message.check_password"/>
		<SignUpFormItem name="name" v-model="signup_data.name" :error_message="error_message.name"/>
		<SignUpFormItem name="email" v-model="signup_data.email" :error_message="error_message.email"/>
		<SignUpFormItem name="phone" v-model="signup_data.phone" :error_message="error_message.phone"/>
		<button @click="signUp" :disabled="true" class="w-500 h-50 f-20 background-silver pointer radius-20">회원가입</button>
	</form>
</template>
<script setup>
import rules from '@/utils/rules'
import SignUpFormItem from '@/components/signup/SignUpFormItem'
import { ref, getCurrentInstance, computed,watch } from 'vue'
const v = ref(108);
const { proxy } = getCurrentInstance();

const id_duplication = ref(true);

const signup_data = ref({ id: '', password: '', name: '', email: '', phone: '' });
const check_password = ref('');

const error_message = ref({id:'',password:'',check_password:'',name:'',email:'',phone:''});

const signUpForm = document.querySelector('signUpForm');


const signUp = () => {
	proxy.$store.dispatch('signUp', signup_data.value).then(res => {
		if (res.data.error === '') {
			localStorage.setItem('id', res.data.data.id);

			openDialogAlert({ content: localStorage.getItem('id') + "님 회원가입 성공", dialog_type: "", callback_type: "signupSuccess" });
		} else {
			openDialogAlert({ content: "회원가입 실패", dialog_type: "", callback_type: "signupFailed" });
			//formElement.value.reset();
		}
	});

};

const idCheck = (id) => {
	proxy.$store.dispatch('idCheck', { params: { id: id } }).then(res => {
		try {
			if (res.data.error === '') {
				if (res.data.data === 'ok') {
					id_duplication.value = false;

				} else {
					id_duplication.value = true;
				}
			} else {
				id_duplication.value = true;
			}
		} catch (error) {
			id_duplication.value = true;
		}
	});

};

const dialog_alert_info = computed(() => {
	return proxy.$store.state.dialog_alert_info;
});

const dialog_alert = computed(() => {
	return proxy.$store.state.dialog_alert;
});

const openDialogAlert = (data) => {
	proxy.$store.dispatch('openDialogAlert', data);
};

const close = () => {
	const type = proxy.$store.state.dialog_alert_info.callback_type;
	proxy.$store.dispatch('closeDialogAlert');
	if (type === 'signupSuccess') {
		proxy.$router.push('/site/main');
	}
}

watch(()=>signup_data.value.id,(value)=>{
	error_message.value.id = rules('id',value);
})

watch(()=>signup_data.value.password,(value)=>{
	error_message.value.password = rules('password',{first:value,second:check_password.value});
	if(error_message.value.password === '' && check_password.value !== '') 
		error_message.value.check_password = error_message.value.password;
})

watch(()=>check_password.value,(value)=>{
	error_message.value.check_password = rules('password',{first:value,second:signup_data.value.password});
	error_message.value.password = error_message.value.check_password;
})

watch(()=>signup_data.value.name,(value)=>{
	error_message.value.name = rules('name',value);
})

watch(()=>signup_data.value.email,(value)=>{
	error_message.value.email = rules('email',value);
})

watch(()=>signup_data.value.phone,(value)=>{
	error_message.value.phone = rules('phone',value);
})

watch([error_message.value],()=>{
	if(error_message.value.id === '' && error_message.value.password === '' && error_message.value.check_password === ''
		&& error_message.value.name === '' && error_message.value.email === '' && error_message.value.phone === ''
	) {
		if(signup_data.value.id !== '' && signup_data.value.password !== '' && signup_data.value.name !== ''
		&& signup_data.value.email !== '' && signup_data.value.phone !== ''){
			console.log('test');
		}
	}
})

</script>
<style></style>