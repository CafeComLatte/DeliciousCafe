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
#userPage {
	height : 600px;
	width:1263px;
	background-color: #f9f9f9f9;
}

#userPage > #userPage_wrap {
	height : 600px;
	padding: 50px 0;
	margin : 0 auto;
	width: 1000px;
}

</style>