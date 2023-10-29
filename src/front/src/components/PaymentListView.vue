<template>
	<div id="payment_list">
		<div id="payment_list_wrap">
			<div id="payment">
				<table>
					<tbody>
						<tr>
							<th>상품 명</th>
							<th>날짜</th>
							<th>개당 금액</th>
							<th>수량</th>
							<th>총 금액</th>
						</tr>
						<tr v-for="(item, index) in itemList" :key="index">
							<td>
								<div class="product_content">
									<img :src="getFormat(item.products[0].image,'image')"/>
									<div>
										<p class="f-40">{{item.products[0].name}}</p>
										<p>{{ item.products[0].contents }}</p>
										<p>{{ getFormat(item.products[0].sys_date,'date') }}</p>
									</div>
								</div>
							</td>
							<td>
								<span>{{getFormat(item.payment_date,'date')}} {{getFormat(item.payment_time,'time')}}</span>	
							</td>
							<td>
								<span>{{getFormat(item.price,'price')}}</span>
							</td>
							<td>
								<span>{{item.count}}</span>
							</td>
							<td>
								<span>{{getFormat(item.total_price,'price')}}</span>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<PageView :totalPages="totalPages" :currentPage="currentPage" :onChangePage="changePage"/>
		</div>
	</div>
</template>
<script setup>
import PageView from '@/components/PageView'
import { ref, onMounted, getCurrentInstance } from 'vue'

const v = ref(27);

const { proxy } = getCurrentInstance();
const itemList = ref([]);

const totalPages = ref(0);
const currentPage = ref(0);

const params = ref({ params: { page: 0, size: 3 } });


onMounted(async () => {
	await searchPage(params.value.params.page).then(res => {
		console.log(res.data);
			
		itemList.value.push(...res.data.elements);
		
		totalPages.value = res.data.totalPages;
		currentPage.value = res.data.currentPage;
	});
});

const searchPage = (page) => {
	params.value.params.page = page;
	return proxy.$store.dispatch('getPayments', params.value);
};

const changePage = async (page) => {
	if (page >= 0 && page < totalPages.value) {
		await searchPage(page).then(res => {
			itemList.value = [];
			itemList.value.push(...res.data.elements);
			totalPages.value = res.data.totalPages;
			currentPage.value = res.data.currentPage;
		});
	}
};

const getFormat = (data,type) => {
	if(type === 'image'){
		return proxy.$getImgFormat(data);
	}else if( type === 'price'){
		return proxy.$getPriceFormat(data);
	}else if( type === 'date'){
		return proxy.$getDateFormat(data);
	}else if( type === 'time'){
		return proxy.$getTimeFormat(data);
	}else{
		return;
	}
	
};
</script>
<style>

#payment_list>#payment_list_wrap>#payment {
	width: 1000px;
	height: 520px;
}

#payment_list>#payment_list_wrap>#payment>table>tbody>tr>th:nth-child(1) ,
#payment_list>#payment_list_wrap>#payment>table>tbody>tr>td:nth-child(1) {width:350px;}
#payment_list>#payment_list_wrap>#payment>table>tbody>tr>th:nth-child(2) ,
#payment_list>#payment_list_wrap>#payment>table>tbody>tr>td:nth-child(2) {width:200px;}
#payment_list>#payment_list_wrap>#payment>table>tbody>tr>th:nth-child(n+3),
#payment_list>#payment_list_wrap>#payment>table>tbody>tr>td:nth-child(n+3){width:150px;}

#payment_list>#payment_list_wrap>#payment>table>tbody>tr:nth-child(1) {
	width: 1000px;
	height: 60px;
	display:flex;
	justify-content: space-between;
	text-align: center;
}

#payment_list>#payment_list_wrap>#payment>table>tbody>tr>th{display:inline-flex; justify-content: center; align-items: center;}

#payment_list>#payment_list_wrap>#payment>table>tbody>tr:nth-child(n+2) {
	width: 1000px;
	height: 150px;
	display:flex;
	justify-content: space-between;
	padding : 10px 0;
}

#payment_list>#payment_list_wrap>#payment>table>tbody>tr>td:nth-child(1){
	width : 350px;
	height: 130px;
}
#payment_list>#payment_list_wrap>#payment>table>tbody>tr>td>.product_content{
	width: 350px;
	height: 130px;
	display:flex;
}

#payment_list>#payment_list_wrap>#payment>table>tbody>tr>td>.product_content>img {
	width: 200px;
	height: 130px;
	padding-right: 10px;
}

#payment_list>#payment_list_wrap>#payment>table>tbody>tr>td>.product_content>div {
	width: 200px;
	height: 130px;
}

#payment_list>#payment_list_wrap>#payment>table>tbody>tr>td:nth-child(n+2){
	display:inline-flex; 
	justify-content: center; 
	align-items: center;
}

#payment_list>#payment_list_wrap>#payment>table>tbody>tr{
	border-bottom: 1px #e3e5e8 solid;
}
</style>