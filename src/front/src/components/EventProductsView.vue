<template>
	<div id="eventproduct_wrap">
		<h1>이벤트 상품</h1>
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

const store = useStore();

const getImg = (img) =>{
	return require(`../assets/img/${img}`);
};


</script>

<style scoped>
#eventproduct_wrap{
	height : 460px;
}
#eventproduct_wrap>ul {
	display: flex;
	justify-content: center;
	flex-flow: row wrap;
	list-style: none;
}

#eventproduct_wrap > h1 {
	display:block;
	margin-left: 20px;
	margin-bottom: 5px;
}

#eventproduct_wrap>ul>li {
	width: 192.6px;
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