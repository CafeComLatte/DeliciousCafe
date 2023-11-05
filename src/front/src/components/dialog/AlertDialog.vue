<template>
	<v-dialog v-model="info.dialog" max-width="500px">
		<v-card>
			<v-card-text>{{ info.content }}</v-card-text>
			<v-card-actions v-if="info.dialog_type === 'YesOrNo'" class="dialog_btn-wrap">
				<v-btn color="primary" text @click.stop="yes">예</v-btn>
				<v-btn color="primary" text @click.stop="close">아니요</v-btn>
			</v-card-actions>
			<v-card-actions v-else-if="info.dialog_type === 'Yes'" class="dialog_btn-wrap">
				<v-btn color="primary" text @click.stop="yes">확인</v-btn>
			</v-card-actions>
			<v-card-actions v-else class="dialog_btn-wrap">
			</v-card-actions>
		</v-card>
	</v-dialog>
</template>
<script setup>
import { ref, defineProps, computed, onMounted } from 'vue'
const v = ref(27);

const props = defineProps({
	dialog: {
		type: Boolean,
		required: true
	},
	content: {
		type: String,
		requried: true
	},
	dialog_type: {
		type: String,
		required: true
	},
	onClose: {
		type: Function,
		required: true
	}
});

const info = computed(() => {
	return props;
});


onMounted(() => {
	setTimeout(() => {
		props.onClose();
	}, 2000);

})

const yes = () => {
	console.log("yes");
};

const close = () => {

};
</script>
<style>
.v-dialog {
	width: 500px;
	height: 500px;
}

.dialog_btn-wrap {
	justify-content: space-evenly;
}
</style>