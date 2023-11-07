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

const v = ref(65);

const user_data = ref({ id: '', password: '', name: '', email: '', phone: '' });
const user_setting_info = ref({email : false,phone : false});


init();

async function init() {
	await asyncGetUserInfo();
	await asyncGetUserSettingInfo();
}

async function asyncGetUserInfo() {
	await proxy.$store.dispatch('user').then(res => {
		if (res.data.error === '') {
			user_data.value = res.data.data;
		}
	});
}

async function asyncGetUserSettingInfo(){
	await proxy.$store.dispatch('userSetting').then(res=>{
		if(res.data.error === ''){
			user_setting_info.value.email = res.data.data.email;
			user_setting_info.value.phone = res.data.data.phone;
		}
	});
}


//////////////////////user info dialog

const dialog_alert = computed(() => {
	return proxy.$store.state.user_dialog_alert;
});

const saveDialog = async (name, val) => {
	proxy.$store.dispatch('closeUserInfoChangeDialog');
	proxy.$store.dispatch('openLoading');
	await proxy.$store.dispatch('updateUserInfo', { name: name, value: val }).then(res => {
		console.log(res.data);
	});
	await init();
	proxy.$store.dispatch('closeLoading');
}

const closeDialog = () => {
	proxy.$store.dispatch('closeUserInfoChangeDialog');
};

//////////////////////////user setting info

watch(()=> user_setting_info.value.phone,async(cur,prev)=>{ 
	proxy.$store.dispatch('openLoading');
	await proxy.$store.dispatch('updateUserSettingInfo', { name: "phone", value: cur }).then(res => {
		console.log(res.data);
	});
	await init();
	proxy.$store.dispatch('closeLoading');
});
watch(()=> user_setting_info.value.email,async(cur,prev)=>{ 
	proxy.$store.dispatch('openLoading');
	await proxy.$store.dispatch('updateUserSettingInfo', { name: "email", value: cur }).then(res => {
		console.log(res.data);
	});
	await init();
	proxy.$store.dispatch('closeLoading');
});

const changeSetting = (val) =>{
	user_setting_info.value.phone = val.phone;
	user_setting_info.value.email = val.email;
}

</script>
<style></style>