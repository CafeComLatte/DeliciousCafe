<template>
	<template v-if="store.getters.getUser === '200' && path !=='/site/login'" >
		<HeaderView/>
		<NaviView/>
		<MainView>
			<router-view/>
		</MainView>
		<FooterView />
	</template>
	<template v-else>
		<router-view/>
	</template>
</template>
<script setup>
import HeaderView from './components/HeaderView'
import NaviView from './components/NaviView'
import MainView from './components/MainView'
import FooterView from './components/FooterView'
import {useStore} from 'vuex'

const store = useStore();

const path = window.location.pathname;



</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;  
}
</style>
