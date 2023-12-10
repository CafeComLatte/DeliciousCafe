import axios from '@/axios/index.js'
import {ref} from 'vue'

const v = ref(5);

const event = {
	state : {
		
	},
	getters : {
		
	},
	mutations : {
		
	},
	actions : {
		async getEventProduct({commit}){			
			return await axios.get('/api/getEventProduct');
		},
		async getEvent({commit}){
			return await axios.get('/api/getEvent');
		},
		
	}
};

export default event;