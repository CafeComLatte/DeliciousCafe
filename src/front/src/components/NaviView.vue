<template>
	<div id="nav" class="clearfix">
		<div id="nav_wrap" :class="{navColor:navColor}">
			<router-link id="logo" to="/site/main" alt="메인페이지" title="메인페이지"><img id="logo_img" :src="getImg('cafe_logo.png')" /></router-link>
			<ul>
				<li><router-link to="/site/main" alt="메인페이지" title="메인페이지">메인</router-link></li>
				<li><router-link to="/site/user" alt="사용자 정보" title="사용자 정보">사용자 정보</router-link></li>
				<li><router-link to="/site/products" alt="상품 검색" title="상품 검색">상품 검색</router-link></li>
				<li><router-link to="/site/payments" alt="결제 내역" title="결제 내역">결제 내역</router-link></li>
			</ul>
			<div v-if="id === null" id="login" class="flex center">
				<router-link to="/login" class="align-content-center">
					<img id="login_img" v-bind:src="getImg('login.png')" alt="로그인 페이지" title="로그인 페이지" />
				</router-link>
			</div>
			<div v-else id="login" class="flex center" alt="사용자 정보" title="사용자 정보">
				<router-link to="/site/user" class="align-content-center flex center">
					<img id="user_img" :src="getImg('person_uncheck.png')" />
					<span>{{ id }}</span>
				</router-link>
				<router-link to="/login" @click="logout" class="align-content-center" alt="로그아웃" title="로그아웃">
					<img id="login_img" :src="getImg('logout.png')" />
				</router-link>
			</div>
		</div>
	</div>
</template>

<script setup>
import { ref, getCurrentInstance,onMounted } from 'vue'

const v = ref(43);

const navColor = ref(false);

const { proxy } = getCurrentInstance();

const id = localStorage.getItem('id');

onMounted(()=>{
	if(window.scrollY>0) navColor.value = true;
	window.addEventListener('scroll',sEvent);
});

const sEvent = () => {
	if(window.scrollY>0){
		navColor.value = true;	
	}else{
		navColor.value = false;
	}
	
}

const logout = async () => {
	if (confirm("로그아웃을 하시겠습니까?")) {
		await proxy.$store.dispatch('user/logout');
		localStorage.clear();
	}

};

const getImg = (img) => {
	return require(`../assets/img/${img}`);
};

</script>
<style scoped>
#nav {
	height: 85px;
	width: 1263px;
}

#nav>#nav_wrap {
	position:fixed;
	height: 85px;
	width: 1263px;
	padding: 0 10px 0 10px;
	text-align: center;
}


#nav>#nav_wrap #logo {
	float: left;
	padding: 30px 0;
}

#nav>#nav_wrap ul {
	display: inline;
}


#nav>#nav_wrap li {
	display: inline-block;
	padding: 35px 15px;
}

a {
	color: black;
	text-decoration-line: none;
}

#nav>#nav_wrap #login {
	float: right;
	padding: 30px 0;
}

#nav>#nav_wrap #login>a {
	padding: 0 10px;
	
}

#login_img,
#user_img,
#logo_img {
	width: 25px;
	height: 25px;
}

.navColor {
	background: hsla(0,0%,100%,.9);
	border-bottom: 1px solid silver;
	z-index: 999;
}

</style>