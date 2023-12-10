<template>
	<div id="signup_item" class="flex column">
		<div id="signup_item-wrap" class="flex align-items-center">			
			<input :value="modelValue" :type="item_style.type" @input="$emit('update:modelValue', $event.target.value)" :placeholder="item_style.placeholder"/>
		</div>
		<p v-if="error_message !== ''" class="f-15 red">{{error_message}}</p>
		<p v-else></p>
	</div>
</template>
<script setup>
import {ref,getCurrentInstance,defineProps,defineEmits} from 'vue'
const v = ref(69);
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

if(props.name === 'id'){
	item_style.value.type = 'text';
	item_style.value.placeholder = '아이디*';
}else if(props.name === 'password'){
	item_style.value.type = 'password';
	item_style.value.placeholder = '비밀번호*';
}else if(props.name === 'name'){
	item_style.value.type = 'text';
	item_style.value.placeholder = '이름*';	
}else if(props.name === 'email'){
	item_style.value.type = 'email';
	item_style.value.placeholder = '이메일*';
}else if(props.name === 'phone'){
	item_style.value.type = 'phone';
	item_style.value.placeholder = '핸드폰번호*';	
}else if(props.name === 'check_password'){
	item_style.value.type = 'password';
	item_style.value.placeholder = '비밀번호 확인*';
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
	border : solid 1px #d1d1d1;
}

#signup_item-wrap > input {
	width : 400px;
	height : 40px;
	font-size : 20px;
}
</style>