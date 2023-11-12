<template>
	<div id="main" class="clearfix">
		<div id="main_side">
			<LoadingView v-if="loading"/>
			<router-view class="main_side_wrap"/>	
		</div>
	</div>
</template>

<script setup>
import {ref,getCurrentInstance,computed} from 'vue'

const v = ref(11);

const {proxy} = getCurrentInstance();

const loading = computed(()=>{
	return proxy.$store.state.loading;	
});
</script>
<style scoped>
#main {
	height : 1200px;
	width : 1263px;
	margin: 0 auto;
}

#main > #main_side{
	position: relative;
	height:600px;
	width:1263px;
}

#main_side>.main_side_wrap {
	height: 600px;
	padding-top: 20px;
	margin: 0 auto;
	width: 1000px;
}

</style>