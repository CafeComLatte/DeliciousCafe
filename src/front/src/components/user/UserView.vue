<template>
	<div id="userPage">
		<UserInfoChangeDialog v-if="dialog_alert" 
								:dialog="dialog_alert" 
								:onCloseDialog="closeDialog"
								:onSaveDialog="saveDialog">
		</UserInfoChangeDialog>
		<div id="userPage_wrap">
			<UserInfoView :info="user_data" />
			<UserSettingView :info="user_setting_info"
							@update:info="changeSetting"/>
		</div>
	</div>
</template>
<script setup>
import UserInfoView from '@/components/user/UserInfoView'
import UserSettingView from '@/components/user/UserSettingView'
import { ref, getCurrentInstance, computed, watch} from 'vue'

const { proxy } = getCurrentInstance();

const v = ref(66);

const user_data = ref({ id: '', password: '', name: '', email: '', phone: '' });
const user_setting_info = ref({email : false,phone : false});


init();

async function init() {
	await asyncGetUserInfo();
	await asyncGetUserSettingInfo();
}

async function asyncGetUserInfo() {
	proxy.$store.dispatch('user/user').then(res => {
		if (res.data.error === '') {
			user_data.value = res.data.data;
		}
	});
}

async function asyncGetUserSettingInfo(){
	await proxy.$store.dispatch('user/userSetting').then(res=>{
		if(res.data.error === ''){
			user_setting_info.value.email = res.data.data.email;
			user_setting_info.value.phone = res.data.data.phone;
		}
	});
}


//////////////////////user info dialog

const dialog_alert = computed(() => {
	return proxy.$store.state.user.user_dialog_alert;
});

const saveDialog = async (name, val) => {
	try{
		proxy.$store.dispatch('user/closeUserInfoChangeDialog');
		proxy.$store.dispatch('openLoading');
		await proxy.$store.dispatch('user/updateUserInfo', { name: name, value: val });
		await init();
		proxy.$store.dispatch('closeLoading');
	}catch(error){
		console.log("UserView saveDialog error : " + error);
	}
}

const closeDialog = () => {
	proxy.$store.dispatch('closeUserInfoChangeDialog');
};

//////////////////////////user setting info

watch(()=> user_setting_info.value.phone,async(cur,prev)=>{ 
	try{
		proxy.$store.dispatch('openLoading');
		await proxy.$store.dispatch('user/updateUserSettingInfo', { name: "phone", value: cur });
		await init();
		proxy.$store.dispatch('closeLoading');
	}catch(error){
		console.log("UserView watch error : " + error);
	}
});
watch(()=> user_setting_info.value.email,async(cur,prev)=>{ 
	try{
		proxy.$store.dispatch('openLoading');
		await proxy.$store.dispatch('user/updateUserSettingInfo', { name: "email", value: cur });
		await init();
		proxy.$store.dispatch('closeLoading');
	}catch(error){
		console.log("UserView watch error : " + error);
	}
});

const changeSetting = (val) =>{
	user_setting_info.value.phone = val.phone;
	user_setting_info.value.email = val.email;
}

</script>
<style></style>