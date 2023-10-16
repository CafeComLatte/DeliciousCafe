<template>
	<div id="eventproduct_wrap">
		<hgroup>
			<h1 class="f-40">이벤트 상품</h1>
			<div>
				<span>더보기</span>
				<button><img :src="getImg('see_more.png')"/></button>
			</div>
		</hgroup>
		<ul>
			<li v-for="product in store.state.data" :key="product.id">
				<img v-bind:src="getImg(product.image)" />
				<p class="eventproduct_name">{{ product.name }}</p>

				<p class="eventproduct_price">{{ product.price }}</p>
			</li>
			
		</ul>
	</div>
</template>
<script setup>
import {useStore} from 'vuex'
import {ref} from 'vue'
const v = ref(8);

const store = useStore();

const getImg = (img) =>{
	return require(`../assets/img/${img}`);
};


</script>

<style scoped>
#eventproduct_wrap{
	height : 340px;
	width : 1000px;
}
#eventproduct_wrap>ul {
	display: flex;
	justify-content: center;
	flex-flow: row wrap;
	list-style: none;
}

#eventproduct_wrap > hgroup {
	display : flex;
	justify-content: space-between;
	margin: 0 20px;
}

#eventproduct_wrap > hgroup > div {
	display : inline-flex;
	align-items: center;	
}

#eventproduct_wrap > hgroup > div > span {
	margin-right: 10px;
	font-size: 20px;
}

#eventproduct_wrap>ul>li {
	width: 193.6px;
	font-size: 10px;
	padding-right: 5px;
	padding-left: 5px;
}

#eventproduct_wrap>ul>li>img {
	margin-top: 0;
	width: 182.6px;
	height: 170px;
}

#eventproduct_wrap .eventproduct_name {
	margin: 10px 5px;
	float: left;
	font-weight: bold;
}

#eventproduct_wrap .eventproduct_price {
	margin: 10px 5px;
	float: right;
	font-weight: bold;
}
</style>