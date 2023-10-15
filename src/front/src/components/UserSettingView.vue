<template>
	<div id="userSetting">
		<div id="userSetting_wrap">
			<ul>
				<li>
					<div class="left">
						<img :src="getImg('phone.png')" />
						<span>휴대전화</span>
					</div>
					<div class="right">
						<input v-model="notification.phone" true-value="true" false-value="false" role="switch" type="checkbox"/>
					</div>
				</li>
				<li>
					<div class="left">
						<img :src="getImg('mail.png')" />
						<span>이메일</span>
					</div>
					<div class="right">
						<input v-model="notification.email" true-value="true" false-value="false" role="switch" type="checkbox"/>
					</div>
				</li>
			</ul>
		</div>
	</div>
</template>
<script setup>
import {ref, getCurrentInstance,onMounted} from 'vue'
const v = ref(true);

const {proxy} = getCurrentInstance();
const notification = ref({id:'',phone:false,email:false});

onMounted(async()=>{
	await proxy.$store.dispatch('userSetting').then(res=>{
		if(res.data.result === true){
			console.log(res.data.data);
			notification.value = res.data.data;
			console.log(notification.value.email);
			console.log(notification.value.phone);
		}
	});
});

const getImg = (img) =>{
	return require(`../assets/img/${img}`);
};
</script>
<style>
#userPage > #userPage_wrap > #userSetting {
	padding : 0 20px;
	height : 130px;
	width : 1000px;
	background-color: white;
	border-radius: 20px;
}

#userPage > #userPage_wrap > #userSetting > #userSetting_wrap {
	height : 130px;
	width : 960px;
}

#userPage > #userPage_wrap > #userSetting > #userSetting_wrap > ul > li {
	height : 65px;
	width : 960px;
}

#userPage > #userPage_wrap > #userSetting > #userSetting_wrap > ul > li:nth-child(1) {
	border-bottom: 1px solid silver;
}

#userPage > #userPage_wrap > #userSetting > #userSetting_wrap > ul > li:nth-child(1) > .left {
	margin : 20px 0;	
	display:flex;
	justify-content: center;
}

#userPage > #userPage_wrap > #userSetting > #userSetting_wrap > ul > li:nth-child(1) > .right {
	margin-top : 23px;
	display : inline;	
}

#userPage > #userPage_wrap > #userSetting > #userSetting_wrap > ul > li:nth-child(2) > .left {
	margin : 20px 0;	
	display:flex;
	justify-content: center;	
}

#userPage > #userPage_wrap > #userSetting > #userSetting_wrap > ul > li:nth-child(2) > .right {
	margin-top : 23px;	
	display : inline;
}

[type="checkbox"] {
  appearance: none;
  position: relative;
  border: max(2px, 0.1em) solid gray;
  border-radius: 1.25em;
  width: 2.25em;
  height: 1.25em;
}

[type="checkbox"]::before {
  content: "";
  position: absolute;
  left: 0;
  width: 1em;
  height: 1em;
  border-radius: 50%;
  transform: scale(0.8);
  background-color: gray;
  transition: left 250ms linear;
}

[type="checkbox"]:checked {
  background-color: tomato;
  border-color: tomato;
}

[type="checkbox"]:checked::before {
  background-color: white;
  left: 1em;
}

[type="checkbox"]:disabled {
  border-color: lightgray;
  opacity: 0.7;
  cursor: not-allowed;
}

[type="checkbox"]:disabled:before {
  background-color: lightgray;
}

[type="checkbox"]:disabled + span {
  opacity: 0.7;
  cursor: not-allowed;
}

[type="checkbox"]:focus-visible {
  outline-offset: max(2px, 0.1em);
  outline: max(2px, 0.1em) solid tomato;
}

[type="checkbox"]:enabled:hover {
  box-shadow: 0 0 0 max(4px, 0.2em) lightgray;
}
</style>