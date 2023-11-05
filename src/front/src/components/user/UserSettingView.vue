<template>
	<div id="userSetting">
		<div id="userSetting_wrap">
			<ul>
				<UserSettingInfoItemView :name="user_setting_info.phone.name" 
										:image="user_setting_info.phone.image" 
										:value="user_setting_info.phone.value" />
				<UserSettingInfoItemView :name="user_setting_info.email.name" 
										:image="user_setting_info.email.image" 
										:value="user_setting_info.email.value" />
				</ul>
		</div>
	</div>
</template>
<script setup>
import UserSettingInfoItemView from '@/components/user/UserSettingInfoItemView'
import {ref, getCurrentInstance} from 'vue'
const v = ref(3);

const {proxy} = getCurrentInstance();
const user_setting_info = ref({
							email : {
								name : '이메일',
								image : 'mail.png',
								value : ''
							},
							phone : {
								name : '휴대전화',
								image : 'phone.png',
								value : ''
							}
						});

getUserSettingInformation();

async function getUserSettingInformation(){
	await proxy.$store.dispatch('userSetting').then(res=>{
		if(res.data.error === ''){
			user_setting_info.value.email.value = res.data.data.email;
			user_setting_info.value.phone.value = res.data.data.phone;
		}
	});
}
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

</style>