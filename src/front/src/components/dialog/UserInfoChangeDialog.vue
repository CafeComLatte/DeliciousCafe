<template>
	<v-dialog class="v-dialog" v-model="info.dialog" max-width="500px">
		<v-card>
			<v-card-text>
				<v-text-field v-model="info_value" class="text-field" :label="info_name" type="text"/>	
			</v-card-text>
			<v-card-actions class="space-evenly">
				<v-btn color="primary" text @click.stop="saveDialog(info_name,info_value)">저장</v-btn>
				<v-btn color="primary" text @click.stop="closeDialog">취소</v-btn>
			</v-card-actions>
		</v-card>
	</v-dialog>
</template>
<script setup>
import {defineProps,ref,computed,getCurrentInstance} from 'vue'
const v = ref(21);

const {proxy} = getCurrentInstance();

const props = defineProps({
	dialog : {
		type: Boolean
	},
	onCloseDialog : {
		type: Function
	},
	onSaveDialog : {
		type: Function
	}
});

const info = computed(() => {
	return props;
});

const info_name = computed(() => {
	return proxy.$store.state.user.user_dialog_alert_info.item_name;
});

const info_value = ref('');

const saveDialog = (info_name,info_value) => {
	info.value.onSaveDialog(info_name,info_value);
};

const closeDialog = () => {
	info.value.onCloseDialog();
};

</script>
<style scoped></style>