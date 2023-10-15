<template>
	<div id="signUp">
		<div class="signUp_wrap">

			<h1> 회원가입 </h1>

			<v-form ref="signUpForm" validate-on="input" v-model="isValid">
				<v-responsive>
					<v-text-field v-model="user_data.id" label="아이디*" type="text"
						:rules="[rules.required, rules.lengthCheck]" />
					<v-text-field ref="refPassword" v-model="user_data.password" label="새 비밀번호*" type="password"
						autocomplete="on" @input="validPassword"
						:rules="[rules.required, rules.lengthCheck, rules.passwordDoubleCheck]" />
					<v-text-field ref="refPasswordConfirm" v-model="check_password" label="새 비밀번호 확인*" type="password"
						autocomplete="on" @input="validPassword"
						:rules="[rules.required, rules.lengthCheck, rules.passwordDoubleCheck]" />
					<v-text-field v-model="user_data.name" label="이름*" type="text" :rules="[rules.required]" />
					<v-text-field v-model="user_data.email" label="이메일*" type="email"
						:rules="[rules.required, rules.emailCheck]" />
					<v-text-field v-model="user_data.phone" label="핸드폰번호*" type="phone"
						:rules="[rules.required, rules.phoneCheck]" />
					<v-btn @click="signUp(user_data)" :disabled="!isValid">로그인</v-btn>
				</v-responsive>
			</v-form>
		</div>
	</div>
</template>
<script setup>
import { ref, getCurrentInstance } from 'vue'
import router from '../router/router'

const { proxy } = getCurrentInstance();

const a = ref(57);
const check_password = ref('')

const isPasswordValid = ref(false);

const isValid = ref(false);

const signUpForm = ref('');
const refPassword = ref('');
const refPasswordConfirm = ref('');

const user_data = ref({ id: '', password: '', name: '', email: '', phone: '' });

const rules = {};
rules.required = value => !!value || '필수입력 사항입니다.';
rules.lengthCheck = value => (value && value.length >= 5 && value.length < 12) || '5글자 이상, 12글자 미만이어야 합니다.';
rules.emailCheck = value => /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(value) || '이메일 형식이 아닙니다.';
rules.phoneCheck = value => /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/.test(value) || '핸드폰번호 형식이 아닙니다.';
rules.passwordDoubleCheck = value => (value && user_data.value.password === check_password.value) || '비밀번호를 다시 확인해주세요.';

const signUp = async (user_data) => {
	await proxy.$store.dispatch('signUp', user_data).then(res => {
		console.log('data1 : ' + res);
		if (res.data.result === true) {
			localStorage.setItem('id', user_data.id);

			console.log("signup success id :" + localStorage.getItem('id') + ', name : ' + localStorage.getItem('name'));
			router.push('/site/main');
		}else{
			signUpForm.value.reset();	
		}
	});

};

const validPassword = () => {
	var flag = false;
	user_data.value.password === check_password.value ? flag = true : flag = false;
	isPasswordValid.value = flag;
	if (isPasswordValid.value) {
		refPassword.value.validate();
		refPasswordConfirm.value.validate();
	}
}

</script>
<style>
#signUp {
	margin: 0 auto;
	height: 600px;
	width: 700px;
}</style>