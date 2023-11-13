import axios from '@/axios/index.js'
import {ref} from 'vue'

const v = ref(1);

const event = {
	state : {
		
	},
	getters : {
		
	},
	mutations : {
		
	},
	actions : {
		getEventProduct({commit}){			
			return axios.get('/api/getEventProduct');
		},
		getEvent({commit}){
			return axios.get('/api/getEvent');
		},
		
	}
};

export default event;