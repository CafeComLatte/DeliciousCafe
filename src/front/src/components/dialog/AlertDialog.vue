<template>
	<v-dialog v-model="info.dialog" max-width="500px">
		<v-card>
			<v-card-text>{{ info.content }}</v-card-text>
			<v-card-actions v-if="info.dialog_type === 'YesOrNo'" class="space-evenly">
				<v-btn color="primary" text @click.stop="yes">예</v-btn>
				<v-btn color="primary" text @click.stop="close">아니요</v-btn>
			</v-card-actions>
			<v-card-actions v-else-if="info.dialog_type === 'Yes'" class="space-evenly">
				<v-btn color="primary" text @click.stop="yes">확인</v-btn>
			</v-card-actions>
			<v-card-actions v-else class="dialog_btn-wrap">
			</v-card-actions>
		</v-card>
	</v-dialog>
</template>
<script setup>
import { ref, defineProps, computed, onMounted,getCurrentInstance } from 'vue'
const v = ref(37);

const {proxy} = getCurrentInstance();

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

onMounted(async() => {
	asyncGetEvent();
	setTimeout(() => {
		props.onClose();
	}, 300);
})

const yes = () => {
	console.log("yes");
};

async function asyncGetEvent() {
	try {
		await proxy.$store.dispatch('getEvent').then(response=>{
			if(response.data.error === ''){
				console.log('asyncGetEvent');
			}	
		});		
	} catch (error) {
		console.log("MainPageView asyncGetEvent error : " + error);
	}
}
</script>
<style scoped></style>