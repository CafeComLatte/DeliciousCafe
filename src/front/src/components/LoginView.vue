<template>
	<div id="login">
		<h1> 로그인 페이지</h1>
		
		<v-form validate-on="input" v-model="isValid">
			<v-responsive>
				<v-text-field label="아이디*" type="text" :rules="[rules.required,rules.lengthCheck]"/>
				<v-text-field label="새 비밀번호*" type="new-password" :rules="[rules.required,rules.lengthCheck]"/>
				<v-text-field label="새 비밀번호 확인*" type="new-password" :rules="[rules.required,rules.lengthCheck]"/>
				<v-text-field label="이름*" type="text" :rules="[rules.required]"/>
				<v-text-field label="이메일*" type="email" :rules="[rules.required,rules.emailCheck]"/>
				<v-text-field label="핸드폰번호*" type="phone" :rules="[rules.required,rules.phoneCheck]"/>
				<v-btn :disabled="!isValid">로그인</v-btn>
			</v-responsive>
		</v-form>
	</div>
</template>
<script setup>
	import {useStore} from 'vuex'
	import {onMounted,ref} from 'vue'
	
	const store = useStore();
	
	const isValid = ref(false);
	
	const rules = {};
	rules.required = value => !!value || '필수입력 사항입니다.';
    rules.lengthCheck = value => (value && value.length >= 5 && value.length < 12) || '5글자 이상, 12글자 미만이어야 합니다.';  
	rules.emailCheck = value => /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(value) || '이메일 형식이 아닙니다.';
	rules.phoneCheck = value => /^[0-9]{3}-[0-9]{3}-[0-9]{4}$/.test(value) || '핸드폰번호 형식이 아닙니다.';
	
	
	onMounted(async()=>{
		await store.dispatch('login');		
	})
	
	console.log(new Date());
</script>
<style>
	#login > form > input {
		display:block;
		width : 100px;
		height : 10px;
		margin : 10px;
	}
	#login > form > span {
		
		display:block;
		color:red;
		font-size: 5px;
		width : 100px;
		height : 7px;
		margin : 2px 10px 5px 10px;
	}
	
</style>