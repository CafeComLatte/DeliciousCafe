<template>
	<AlertDialog v-if="dialog_alert"
				:dialog="dialog_alert" 
				:onClose="close" 
				:content="dialog_alert_info.content" 
				:dialog_type="dialog_alert_info.dialog_type">
	</AlertDialog>
	
	<v-form ref="formElement" validate-on="input" v-model="isValid.form">
		<v-responsive>
			<v-text-field ref="idElement" v-model="user_data.id" label="아이디*" type="text" @input="idCheck(user_data.id)" :rules="[rules.required, rules.length, rules.idDuplicate]" />
			<v-text-field ref="firstPasswordElement" v-model="user_data.password" label="새 비밀번호*" type="password" autocomplete="on"
				@input="validPassword" :rules="[rules.required, rules.length, rules.passwordDouble]" />
			<v-text-field ref="secondPasswordElement" v-model="second_password" label="새 비밀번호 확인*" type="password"
				autocomplete="on" @input="validPassword"
				:rules="[rules.required, rules.length, rules.passwordDouble]" />
			<v-text-field v-model="user_data.name" label="이름*" type="text" :rules="[rules.required]" />
			<v-text-field v-model="user_data.email" label="이메일*" type="email" :rules="[rules.required, rules.email]" />
			<v-text-field v-model="user_data.phone" label="핸드폰번호*" type="phone"
				:rules="[rules.required, rules.phone]" />
			<v-btn @click="signUp" :disabled="!isValid">회원가입</v-btn>
		</v-responsive>
	</v-form>
</template>
<script setup>
import {ref,getCurrentInstance,computed} from 'vue'
const v = ref(55);
const {proxy} = getCurrentInstance();

const isValid = ref({form:false,password:false});
const id_duplication = ref(true);

const user_data = ref({ id: '', password: '', name: '', email: '', phone: '' });
const second_password = ref('')


const formElement = ref('');
const idElement = ref('');
const firstPasswordElement = ref('');
const secondPasswordElement = ref('');

const rules = {};
rules.required = value => !!value || '필수입력 사항입니다.';
rules.length = value => (value && value.length >= 5 && value.length < 12) || '5글자 이상, 12글자 미만이어야 합니다.';
rules.email = value => /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(value) || '이메일 형식이 아닙니다.';
rules.phone = value => /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/.test(value) || '핸드폰번호 형식이 아닙니다.';
rules.passwordDouble = value => (value && user_data.value.password === second_password.value) || '비밀번호를 다시 확인해주세요.';
rules.idDuplicate = value => (value && id_duplication.value === false) || '중복되는 아이디가 존재합니다.';

const signUp = () => {
	proxy.$store.dispatch('signUp', user_data.value).then(res => {
		if (res.data.error === '') {
			localStorage.setItem('id', user_data.value.id);

			openDialogAlert({content : localStorage.getItem('id') + "님 회원가입 성공",dialog_type : "",callback_type:"signupSuccess"});
		}else{
			openDialogAlert({content : "회원가입 실패",dialog_type : "",callback_type:"signupFailed"});		
			formElement.value.reset();		
		}
	});

};


const validPassword = () => {
	var flag = false;
	flag = user_data.value.password === second_password.value ? true : false;
	isValid.value.password = flag;
	if (isValid.value.password) {
		firstPasswordElement.value.validate();
		secondPasswordElement.value.validate();
	}
}

const idCheck = (id) => {	
	proxy.$store.dispatch('idCheck',{params:{id:id}}).then(res=>{
		try{
			if(res.data.error === ''){
				if(res.data.data === 'ok'){
					id_duplication.value = false;
					
				}else{
					id_duplication.value = true;
				}
			}else{
				id_duplication.value = true;
			}			
		}catch(error){
			id_duplication.value = true;
		}
		idElement.value.validate();
	});
	
};

const dialog_alert_info = computed(()=>{
	return proxy.$store.state.dialog_alert_info;
});

const dialog_alert = computed(()=>{
	return proxy.$store.state.dialog_alert;
});

const openDialogAlert = (data) => {	
	proxy.$store.dispatch('openDialogAlert',data);
};

const close = () => {
	const type = proxy.$store.state.dialog_alert_info.callback_type;
	proxy.$store.dispatch('closeDialogAlert');
	if(type === 'signupSuccess'){
		proxy.$router.push('/site/main');
	}
}

</script>
<style></style>