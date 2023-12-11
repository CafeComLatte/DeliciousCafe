<template>
	<div id="signup_item" class="flex column">
		<div id="signup_item-wrap" class="flex align-items-center" :class="isFocus === true?'login-input-focus':'login-input-unFocus'">			
			<input :value="modelValue" :tabIndex="index" :type="item_style.type" @input="$emit('update:modelValue', $event.target.value)" :placeholder="item_style.placeholder" @focus.capture="focus" @blur.capture="unFocus"/>
		</div>
		<p v-if="error_message !== ''" class="f-15 red">{{error_message}}</p>
		<p v-else></p>
	</div>
</template>
<script setup>
import {ref,getCurrentInstance,defineProps,defineEmits} from 'vue'
const v = ref(73);
const { proxy } = getCurrentInstance();

const props = defineProps({
	name: {
		type : String
	},
	modelValue: {
		type : String
	},
	error_message : {
		type : String,
		default : ''
	}
});
const emit = defineEmits(["check"]);

const item_style = ref({type:'',placeholder:''});
const index = ref('1');

const isFocus = ref(false);

if(props.name === 'id'){
	index.value = '1';
	item_style.value.type = 'text';
	item_style.value.placeholder = '아이디*';
}else if(props.name === 'password'){
	index.value = '2';
	item_style.value.type = 'password';
	item_style.value.placeholder = '비밀번호*';
}else if(props.name === 'check_password'){
	index.value = '3';
	item_style.value.type = 'password';
	item_style.value.placeholder = '비밀번호 확인*';
}
else if(props.name === 'name'){
	index.value = '4';
	item_style.value.type = 'text';
	item_style.value.placeholder = '이름*';	
}else if(props.name === 'email'){
	index.value = '5';
	item_style.value.type = 'email';
	item_style.value.placeholder = '이메일*';
}else if(props.name === 'phone'){
	index.value = '6';
	item_style.value.type = 'phone';
	item_style.value.placeholder = '핸드폰번호*';	
}

const focus = () => {
	isFocus.value = true;
}

const unFocus = () => {
	isFocus.value = false;	
}

</script>
<style scoped>
#signup_item {
	margin-bottom: 10px;
}

#signup_item-wrap {
	width : 500px;
	height : 50px;
	padding : 5px 10px;
}

#signup_item-wrap > input {
	width : 400px;
	height : 40px;
	font-size : 20px;
}
</style>