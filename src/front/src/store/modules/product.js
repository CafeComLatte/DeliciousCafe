import axios from '@/axios/index.js'
import {ref} from 'vue'

const v = ref(1);

const product = {
	state : {
		
	},
	getters : {
		
	},
	mutations : {
		
	},
	actions : {
		getProducts({commit},params){
			return axios.get('/api/products',params);
		},
		getProduct({commit},id){
			return axios.get('/api/products/' + id);
		},
	}
};

export default product;