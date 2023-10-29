<template>
	<div id="main">
		<HeaderView/>
		<NaviView/>
		<div id="main_side">
			<router-view class="main_side_wrap"/>	
		</div>
		<FooterView/>
	</div>
</template>

<script setup>
import HeaderView from './HeaderView.vue'
import NaviView from './NaviView'
import FooterView from './FooterView'
import {ref} from 'vue'
const v = ref(3);

</script>
<style>
#main {
	height : 1200px;
	width : 1263px;
	margin: 0 auto;
}

#main > #main_side{
	height : 600px;
	width:1263px;
}

#main_side>.main_side_wrap {
	height: 600px;
	padding-top: 20px;
	margin: 0 auto;
	width: 1000px;
}
</style>