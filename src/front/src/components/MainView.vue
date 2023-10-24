<template>
	<div id="main">
		<HeaderView/>
		<NaviView/>
		<router-view class="main_side"/>
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

#main > .main_side{
	height : 600px;
	width:1263px;
}
</style>