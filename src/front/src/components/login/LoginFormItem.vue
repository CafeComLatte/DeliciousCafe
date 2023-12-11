<template>
	<div id="login_item" class="flex column">
		<div class="flex space-between align-items-center login-input" :class="isFocus === true?'login-input-focus':'login-input-unFocus'">			
			<svg v-if="name === 'id'" xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="#c8c8c8">
				<path d="M480-480q-66 0-113-47t-47-113q0-66 47-113t113-47q66 0 113 47t47 113q0 66-47 113t-113 47ZM160-160v-112q0-34 17.5-62.5T224-378q62-31 126-46.5T480-440q66 0 130 15.5T736-378q29 15 46.5 43.5T800-272v112H160Zm80-80h480v-32q0-11-5.5-20T700-306q-54-27-109-40.5T480-360q-56 0-111 13.5T260-306q-9 5-14.5 14t-5.5 20v32Zm240-320q33 0 56.5-23.5T560-640q0-33-23.5-56.5T480-720q-33 0-56.5 23.5T400-640q0 33 23.5 56.5T480-560Zm0-80Zm0 400Z"/>
			</svg>
			<svg v-else-if="name === 'password'"  xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="#c8c8c8">
				<path d="M240-80q-33 0-56.5-23.5T160-160v-400q0-33 23.5-56.5T240-640h40v-80q0-83 58.5-141.5T480-920q83 0 141.5 58.5T680-720v80h40q33 0 56.5 23.5T800-560v400q0 33-23.5 56.5T720-80H240Zm0-80h480v-400H240v400Zm240-120q33 0 56.5-23.5T560-360q0-33-23.5-56.5T480-440q-33 0-56.5 23.5T400-360q0 33 23.5 56.5T480-280ZM360-640h240v-80q0-50-35-85t-85-35q-50 0-85 35t-35 85v80ZM240-160v-400 400Z"/>
			</svg>
			<input v-model="model" :tabIndex="item_style.index" :type="item_style.type" @input="check" @focus.capture="focus" @blur.capture="unFocus" :placeholder="item_style.placeholder"/>
			<button @click="removeContent" :class="{hidden:hidden}" class="pointer" type="button">
				<svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 -960 960 960" width="24" fill="#c8c8c8">
					<path d="m336-280 144-144 144 144 56-56-144-144 144-144-56-56-144 144-144-144-56 56 144 144-144 144 56 56ZM480-80q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"/>
				</svg>
			</button>
		</div>
		<p v-if="error === true" class="f-15 red">{{error_message}}</p>
		<p v-else></p>
	</div>
</template>
<script setup>
import {ref,getCurrentInstance,defineProps,defineEmits,computed,watch} from 'vue'
const v = ref(74);
const { proxy } = getCurrentInstance();

const props = defineProps({
	name: {
		type : String
	},
	value: {
		type : String
	}
});
const emit = defineEmits(["update:value"]);

const model = computed({
  get() {
    return props.value;
  }, 
  set(value) {
    emit("update:value", value);
  }, 
});

const item_style = ref({index:'1',type:'',placeholder:''});
const error = ref(false);
const error_message = ref('');

const hidden = ref(true);
const isFocus = ref(false);

if(props.name === 'id'){
	item_style.value.index = '1';
	item_style.value.type = 'text';
	item_style.value.placeholder = '아이디';
}else if(props.name === 'password'){
	item_style.value.index = '2';
	item_style.value.type = 'password';
	item_style.value.placeholder = '비밀번호';
}

watch(()=>model.value,(value)=>{
	if(model.value === ''){
		hidden.value = true;
	}else{
		hidden.value = false;
	}
})

const check = () =>{
	if(model.value === ''){
		error.value = true;
		error_message.value = item_style.value.placeholder + ' 입력이 필요합니다.'; 
	}else{
		error.value = false;
		error_message.value = '';
	}
};

const removeContent = () => {
	model.value = '';
	hidden.value = true;
};

const focus = () => {
	isFocus.value = true;
}

const unFocus = () => {
	isFocus.value = false;	
}
</script>
<style scoped>
#login_item {
	margin-bottom: 10px;
}

</style>