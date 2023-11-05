<template>
	<div id="userPage">
		<UserInfoChangeDialog v-if="dialog_alert" 
								:dialog="dialog_alert" 
								:onCloseDialog="closeDialog"
								:onSaveDialog="saveDialog">
		</UserInfoChangeDialog>
		<div id="userPage_wrap">
			<UserInfoView :info="user_data" />
			<UserSettingView />
		</div>
	</div>
</template>
<script setup>
import UserInfoView from '@/components/user/UserInfoView'
import UserSettingView from '@/components/user/UserSettingView'
import { ref, getCurrentInstance, computed } from 'vue'

const { proxy } = getCurrentInstance();

const v = ref(49);

const user_data = ref({ id: '', password: '', name: '', email: '', phone: '' });

init();

async function init() {
	await asyncGetUserInfo();

}

async function asyncGetUserInfo() {
	await proxy.$store.dispatch('user').then(res => {
		if (res.data.error === '') {
			user_data.value = res.data.data;
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


</script>
<style></style>