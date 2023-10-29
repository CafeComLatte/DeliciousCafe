<template>
	<div id="mainpage">
		<div id="mainpage_wrap">
			<EventView/>
			<EventProductsView/>		
		</div>
	</div>
</template>

<script setup>
import EventProductsView from '@/components/EventProductsView'
import EventView from '@/components/EventView'

import {onMounted} from 'vue'
import {useStore} from 'vuex'

const store = useStore();

onMounted(async()=>{
	await store.dispatch('getEventProduct');		
	await store.dispatch('getEvent');	
})

</script>
<style>

</style>