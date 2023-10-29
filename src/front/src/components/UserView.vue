<template>
	<div id="userPage">
		<div id="userPage_wrap">
			<UserInfoView/>
			<UserSettingView/>
		</div>
	</div>
</template>
<script setup>
	import UserInfoView from '@/components/UserInfoView'
	import UserSettingView from '@/components/UserSettingView'
	import {ref} from 'vue'
	
	const v = ref(44);
	
</script>
<style>

</style>