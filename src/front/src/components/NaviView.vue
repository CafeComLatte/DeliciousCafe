<template>
  <div id="nav">
	<div id="nav_wrap">
		<a id="logo" href="#"><img id="logo_img" src="../assets/img/cafe_logo.png"/></a>		
		<ul>
			<li><a href="#">메인</a></li>
			<li><a href="#">사용자 정보</a></li>
			<li><a href="#">상품 검색</a></li>
			<li><a href="#">결제 내역</a></li>
		</ul>
		<a id="login" href="#"><img id="login_img" src="../assets/img/login.png"/></a>				
	</div>
  </div>
</template>

<script>

export default {
	name: 'NaviView'
	
}
</script>
<style>
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

#nav > #nav_wrap li {	
	display:inline-block;
	padding:35px 15px;
}

#nav > #nav_wrap #login {
	float:right;
	padding:30px 0;
}

#nav > #nav_wrap #login_img {
	width : 35px;	
}



</style>