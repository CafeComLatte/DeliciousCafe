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

onMounted(()=>{	
	store.dispatch('getEventProduct');	
})
</script>
<style>
#MainPageView {
	float : left;
	height : 400px;
	width : 963px;
	background-color: #f9f9f9f9;
}

</style>