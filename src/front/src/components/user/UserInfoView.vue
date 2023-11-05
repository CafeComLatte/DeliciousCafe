<template>
	<div id="userInfo">
		<div id="userInfo_wrap">
			<ul>
				<UserInfoItemView info_name="name" :info_value="info.name" type="account"/>
				<UserInfoItemView info_name="email" :info_value="info.email" type=""/>
				<UserInfoItemView info_name="phone" :info_value="info.phone" type=""/>				
			</ul>
		</div>
	</div>
</template>
<script setup>
import UserInfoItemView from '@/components/user/UserInfoItemView'
import {ref,defineProps,computed} from 'vue'
const v = ref(31);

const props = defineProps({
	info : {
		type: Object
	}
});

const info = computed(()=>{
	return props.info;
});

</script>
<style>
#userPage>#userPage_wrap>#userInfo {
	margin-bottom: 70px;
	padding: 0 20px;
	height: 300px;
	width: 1000px;
	background-color: white;
	border-radius: 20px;
}

#userPage>#userPage_wrap>#userInfo>#userInfo_wrap {
	height: 300px;
	width: 960px;
}

</style>