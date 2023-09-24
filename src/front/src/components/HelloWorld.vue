<template>
  <div>
  </div>
</template>

<script>
import axios from 'axios'
import { useCookies } from "vue3-cookies";

export default {
	name: 'HelloWorld'
	,setup() {
		const { cookies } = useCookies();
		return { cookies };
	},
	mounted(){
		
		axios.get('/api/hello').then(response =>{
			let my_cookie_value = this.cookies.get("myCoookie");
			console.log(my_cookie_value);
			console.log("session : " + response.data);			
		});
		
	}
}
</script>
<style>
	
</style>