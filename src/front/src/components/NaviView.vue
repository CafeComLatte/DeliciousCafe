<template>
  <div id="nav">
	<div id="nav_wrap">
		<router-link id="logo" to="/site"><img id="logo_img" src="../assets/img/cafe_logo.png"/></router-link>		
		<ul>
			<li><router-link to="/site">메인</router-link></li>
			<li><a href="#">사용자 정보</a></li>
			<li><a href="#">상품 검색</a></li>
			<li><a href="#">결제 내역</a></li>
		</ul>
		<a id="login" href="#"><img id="login_img" v-bind:src="getImg(img)"/></a>				
	</div>
  </div>
</template>

<script setup>
	import {useStore} from 'vuex'
	const store = useStore();
	const img = store.getters.getUser === '200'?'person_uncheck.png':'login.png';
	
	const getImg = (img) =>{	
		return require(`../assets/img/${img}`);
	};
	

</script>
<style scoped>
#nav {	
	height : 100px;
	width:1263px;
	padding : 0 10px 0 10px;
	
}
#nav > #nav_wrap{
	height : 100px;
	text-align: center;
}


#nav > #nav_wrap #logo {
	float:left;
	padding:30px 0;
}

#nav > #nav_wrap #logo_img {
	width : 35px;	
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
	float:right;
	padding:30px 0;
}

#nav > #nav_wrap #login_img {
	width : 35px;	
}



</style>