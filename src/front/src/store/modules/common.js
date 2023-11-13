import axios from '@/axios/index.js'
import {ref} from 'vue'

const v = ref(1);

const common = {
	state : {
		loading : false,
		
	},
	getters: {
		
	},
	mutations : {
		openLoading(state){
			state.loading = true;
		},
		closeLoading(state){
			state.loading = false;
		},
		
	},
	actions :{
		openLoading({commit}){
			commit('openLoading');
		},
		closeLoading({commit}){
			commit('closeLoading');
		},
			
	}
};

export default common;