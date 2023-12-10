<template>
	<div id="mainpage">
		<div id="mainpage_wrap">
			<EventView :event_data="event_data" />
			<EventProductsView :data="event_product" />
		</div>
	</div>
</template>

<script setup>
import EventProductsView from '@/components/mainpage/EventProductsView'
import EventView from '@/components/mainpage/EventView'
import { ref, getCurrentInstance} from 'vue'
const v = ref(36);
const { proxy } = getCurrentInstance();

const event_product = ref([]);
const event_data = ref({ id: '', image: '' });

init();


function init(){		
	asyncGetEvent();
	asyncGetEventProduct();
}

async function asyncGetEvent() {
	try {
		await proxy.$store.dispatch('getEvent').then(response=>{
			if(response.data.error === ''){
				event_data.value = response.data.data;
			}	
		});		
	} catch (error) {
		console.log("MainPageView asyncGetEvent error : " + error);
	}
}

async function asyncGetEventProduct(){
	try{
		await proxy.$store.dispatch('getEventProduct').then(response=>{
			if(response.data.error === ''){
				event_product.value = response.data.data;
			}	
		});
					
	}catch(error){
		console.log("MainPageView asyncGetEventProduct error : " + error);		
	}
	
}

</script>
<style scoped></style>