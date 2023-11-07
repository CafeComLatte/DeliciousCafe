<template>
	<div id="userSetting">
		<div id="userSetting_wrap">
			<ul>
				<UserSettingInfoItemView name="이메일" 
										image="mail.png" 
										:value="model.email"
										@update:value="newValue => model.email = newValue" />
				<UserSettingInfoItemView name="휴대전화" 
										image="phone.png"
										:value="model.phone"
										@update:value="newValue => model.phone = newValue" />
			</ul>
		</div>
	</div>
</template>
<script setup>
import UserSettingInfoItemView from '@/components/user/UserSettingInfoItemView'
import {ref, defineProps,defineEmits,computed} from 'vue'
const v = ref(24);


const props = defineProps({
	info : {
		email : {
			type:Boolean
		},
		phone : {
			type:Boolean
		},
	}
});

const emit = defineEmits(["update:info"]);
const model = computed({
  get() {
    return props.info;
  }, 
  set(value) {
    emit("update:info", value);
  }, 
});
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