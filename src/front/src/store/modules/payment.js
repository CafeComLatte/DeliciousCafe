import axios from '@/axios/index.js'
import {ref} from 'vue'

const v = ref(1);

const payment = {
	state : {
		
	},
	getters : {
		
	},
	mutations : {
		
	},
	actions : {
		getPayments({commit},params){			
			return axios.get('/api/payments',params);
		},
		payProduct({commit},params){			
			return axios.post('/api/payProduct',params);
		},
	}
};

export default payment;