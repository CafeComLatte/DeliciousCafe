<template>
  <div id="MainPageView">
	<div class="content_wrap">
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

#MainPageView {
	float : left;
	height : 600px;
	width:1263px;
	background-color: #f9f9f9f9;
}

.content_wrap {
	height : 600px;
	margin : 0 auto;
	width: 1000px;
}

</style>