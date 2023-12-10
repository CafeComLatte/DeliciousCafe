<template>
	<div id="product_details" class="clearfix">
		<div id="product_details_wrap">
			<div class="product_details-thumbnail left" v-if="item.image !== ''">
				<img :src="getFormat(item.image,'image')"/>
			</div>
			<div class="product_details-content-payment left">
				<p class="f-40">{{item.product_name}}</p>
				<p>{{getFormat(item.price,'price')}}</p>
				<div class="product_choice">
					<div class="product_choice_wrap">
						<p>수량</p>
						<div class="product_choice_option flex align-items-center space-between">
							<div class="product_choice_option_count">
								<input type='button' @click='plus' value='+' class="inline-flex center"/>
								<input type='number' v-model='payment_info.count'>
								<input type='button' @click='minus' value='-' class="inline-flex center"/>
							</div>
							<span class="right">{{getFormat(payment_info.total_price,'price')}}</span>
						</div>						
					</div>	
				</div>
				<span class="f-30">총 금액 : {{getFormat(payment_info.total_price,'price')}}</span>
				<button class="right" @click="payProduct">구매하기</button>
			</div>
		</div>
	</div>
</template>
<script setup>
import {ref,defineProps,getCurrentInstance} from 'vue'
import {useRouter} from 'vue-router'

const router = useRouter();
const {proxy} = getCurrentInstance();

const v = ref(83);

const item = ref({
	product_name:'',
	price:0,
	image:'',
	sys_date:''	
});

const payment_info = ref({
	count: 1,
	total_price: 0
});

const result = ref({});

const props = defineProps({
	id : {
		type: String,
		default: '',
		required:true
	}
});

init();

const payProduct = () => {
	if (confirm("구매를 진행하시겠습니까?")) {
		result.value = Object.assign(item.value,payment_info.value);
		proxy.$store.dispatch('payProduct',result.value).then(res=>{
			if(res.data.error === ''){
				alert("구매가 완료되었습니다.");
				router.push('/site/products');
			}else{
				alert("구매가 완료되지 못했습니다.");
			}
		});        
    }
	
	
};

const plus = () =>{	
	payment_info.value.count = payment_info.value.count + 1;
	payment_info.value.total_price = item.value.price * payment_info.value.count;
};

function init(){
	getProductDetails();
}

function getProductDetails(){
	proxy.$store.dispatch('getProduct',props.id).then(res=> {
		if(res.data.error === ''){
			item.value.product_name = res.data.data.name;
			item.value.price = res.data.data.price;
			item.value.sys_date = res.data.data.sys_date;
			item.value.image = res.data.data.image;
			
			payment_info.value.total_price = res.data.data.price;
			
		}else{
			alert("해당 상품은 현재 품절되었습니다.");
			router.push('/site/products');
		}		
	});
}

const getFormat = (data,type) => {
	if(type === 'image'){
		return proxy.$getImgFormat(data);
	}else if( type === 'price'){
		return proxy.$getPriceFormat(data);
	}else if( type === 'date'){
		return proxy.$getDateFormat(data);
	}else{
		return;
	}
	
};
</script>
<style>

#product_details>#product_details_wrap{
	width : 1000px;
	height : 330px;
} 

#product_details>#product_details_wrap>.product_details-thumbnail{
	width : 500px;
	height : 330px;
	padding : 20px;
	display: inline-block;
	border : 1px #e3e5e8 solid;
	border-right: 0px;
}

#product_details>#product_details_wrap>.product_details-thumbnail>img{
	width : 458px;
	height : 288px;
}

#product_details>#product_details_wrap>.product_details-content-payment{
	width : 500px;
	height : 330px;
	padding : 20px;
	border : 1px #e3e5e8 solid;
	border-left: 0px;
	display: inline-block;
}

#product_details>#product_details_wrap>.product_details-content-payment>.product_choice{
	margin-top: 10px;
	width: 458px;
	height: 100px;
	padding: 10px;
	border-bottom: 1px #e3e5e8 solid;
	border-top: 1px #e3e5e8 solid;
	
}

#product_details>#product_details_wrap>.product_details-content-payment>.product_choice>.product_choice_wrap{
	width: 438px;
	height: 78px;
	padding: 5px 10px;
	background-color: #f3f3f3;
}

#product_details>#product_details_wrap>.product_details-content-payment>.product_choice>.product_choice_wrap>.product_choice_option{
	margin-top: 20px;
	height:20px;
	
}

#product_details>#product_details_wrap>.product_details-content-payment>span{
	display:block;
	text-align: right;
	margin-right: 10px;
}

#product_details>#product_details_wrap>.product_details-content-payment>button{
	border-radius: 20px;
	margin-right: 10px;
	margin-top: 10px;
	width: 100px;
	height: 30px;
	background-color: silver;
}

input[type="number"]{
	width:20px;
	height:20px;
	background-color: #f9f9f9;
	text-align: center;
}


input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

input[type="button"] {
	width:20px;
	height:20px;
	background-color: silver;
}

</style>