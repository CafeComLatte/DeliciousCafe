<template>
	<HeaderView/>
	<NaviView/>
	<SideView/>
	<MainView>
		<router-view/>
	</MainView>
</template>

<script>
import HeaderView from './components/HeaderView'
import NaviView from './components/NaviView'
import SideView from './components/SideView'
import MainView from './components/MainView'
export default {
  name: 'App',
  components:{
	HeaderView, NaviView, SideView, MainView
  }
}
</script>

<style>


#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: #2c3e50;
  
}

</style>
