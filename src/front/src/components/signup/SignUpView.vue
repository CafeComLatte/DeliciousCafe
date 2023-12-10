<template>
	<div id="signUp">
		<div class="signUp_wrap">
			<h1 class="m-bottom-20"> 회원가입 </h1>
			<SignUpFormView/>
		</div>
	</div>
</template>
<script setup>
import SignUpFormView from '@/components/signup/SignUpFormView'
import { ref } from 'vue'

const a = ref(60);

</script>
<style>
#signUp {
	margin: 0 auto;
	height: 600px;
	width: 500px;
}</style>