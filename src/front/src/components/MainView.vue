<template>
	<div id="main">
		<HeaderView/>
		<NaviView/>
		<MainPageView/>
		<FooterView/>
	</div>
</template>

<script setup>
import HeaderView from './HeaderView.vue'
import NaviView from './NaviView'
import MainPageView from './MainPageView'
import FooterView from './FooterView'

</script>
<style scoped>
#main {
	height : 1300px;
	width : 1263px;
}
</style>