<template>
  <div id="nav">
	<div id="nav_wrap">
		<router-link id="logo" to="/site/main"><img id="logo_img" :src="getImg('cafe_logo.png')"/></router-link>		
		<ul>
			<li><router-link to="/site/main">메인</router-link></li>
			<li><a href="#">사용자 정보</a></li>
			<li><a href="#">상품 검색</a></li>
			<li><a href="#">결제 내역</a></li>
		</ul>
		<div v-if="id === null" id="login">
			<router-link to="/login">
				<img id="login_img" v-bind:src="getImg('login.png')"/>	
			</router-link>
		</div>	
		<div v-else id="login">
			<router-link class="flex" to="/site/user">
				<img id="user_img" v-bind:src="getImg('person_uncheck.png')"/>
				<span>{{id}}</span>  	
			</router-link>
			<router-link to="/login" @click="logout">
				<img id="login_img" v-bind:src="getImg('logout.png')"/>	
			</router-link>
		</div>
	</div>
  </div>
</template>

<script setup>
	import {ref, getCurrentInstance} from 'vue'

	const v = ref(7);

	const {proxy} = getCurrentInstance();

	const id = localStorage.getItem('id');
	
	const logout = async () => {
		await proxy.$store.dispatch('logout');
		localStorage.clear();
	};

	const getImg = (img) =>{
	return require(`../assets/img/${img}`);
};
	
</script>
<style scoped>
#nav {	
	height : 85px;
	width:1263px;
	padding : 0 10px 0 10px;
	
	border-bottom: 1px solid silver;
}
#nav > #nav_wrap{
	height : 85px;
	text-align: center;
}


#nav > #nav_wrap #logo {
	float:left;
	padding:30px 0;
}

#nav > #nav_wrap ul {
	display : inline;
}


#nav > #nav_wrap li {	
	display:inline-block;
	padding:35px 15px;
}

a {
	color : black;
	text-decoration-line: none;
}

#nav > #nav_wrap #login {
	display : flex;
	justify-content: center;
	float:right;
	padding:30px 0;
}

#nav > #nav_wrap #login > a {
	padding:0 10px;	
	align-content: center;
}

#nav > #nav_wrap #login > .flex {
	display:flex;
	
}


#login_img,#user_img,#logo_img {
	width : 25px;
	height : 25px;	
}



</style>