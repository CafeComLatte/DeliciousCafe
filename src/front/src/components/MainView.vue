<template>
	<div id="main">
		<HeaderView/>
		<NaviView/>
		<router-view/>
		<FooterView/>
	</div>
</template>

<script setup>
import HeaderView from './HeaderView.vue'
import NaviView from './NaviView'
import FooterView from './FooterView'
import {ref} from 'vue'
const v = ref(1);

</script>
<style>
#main {
	height : 1200px;
	width : 1263px;
}
</style>