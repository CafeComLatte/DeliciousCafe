<template>
	<div id="userInfo">
		<div id="userInfo_wrap">
			<ul>
				<li>
					<div class="left">
						<p class="f-40">{{user_data.name}}</p>
						<p>{{user_data.password}}</p>
					</div>
					<div class="right">
						<button><img :src="getImg('edit.png')" /></button>
					</div>
				</li>
				<li>
					<div class="left">
						<p>{{user_data.email}}</p>
					</div>
					<div class="right">
						<button><img :src="getImg('edit.png')" /></button>
					</div>
				</li>
				<li>
					<div class="left">
						<p>{{user_data.phone}}</p>
					</div>
					<div class="right">
						<button><img :src="getImg('edit.png')" /></button>
					</div>
				</li>
			</ul>
		</div>
	</div>
</template>
<script setup>
import {ref,getCurrentInstance, onMounted} from 'vue'
const v = ref(3);
const user_data = ref({id:'',password:'',name:'',email:'',phone:''});

const {proxy} = getCurrentInstance();

onMounted(async()=>{
	await proxy.$store.dispatch('user').then(res=>{
		if(res.data.result === true){
			user_data.value = res.data.data;
		}
	});
});

const getImg = (img) =>{
	return require(`../assets/img/${img}`);
};
</script>
<style>
	#userPage > #userPage_wrap > #userInfo {
	margin-bottom: 70px;
	padding: 0 20px;
	height : 300px;
	width : 1000px;	
	background-color: white;
	border-radius: 20px;
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap {
	height : 300px;
	width : 960px;	
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap > ul > li:nth-child(1){
	height : 130px;
	width : 960px;
	border-bottom: 1px solid silver;
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap > ul > li:nth-child(1) > .left {
	display : inline-block;
	margin : 20px 0;
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap > ul > li:nth-child(1) > .right {
	display : inline-block;
	margin : 48px 0;
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap > ul > li:nth-child(2){
	height : 85px;
	width : 960px;
	border-bottom: 1px solid silver;
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap > ul > li:nth-child(2) > .left {
	display : inline-block;
	margin : 30px 0;
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap > ul > li:nth-child(2) > .right {
	display : inline-block;
	margin : 26px 0;
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap > ul > li:nth-child(3){
	height : 85px;
	width : 960px;
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap > ul > li:nth-child(3) > .left {
	display : inline-block;
	margin : 30px 0;
}

#userPage > #userPage_wrap > #userInfo > #userInfo_wrap > ul > li:nth-child(3) > .right {
	display : inline-block;
	margin : 26px 0;
}

</style>