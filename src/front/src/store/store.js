import {createStore} from "vuex"
import axios from '@/axios/index.js'

export default createStore({
	state : {
		data : null,
		event_data : {image:''}
	},
	getters: {
		getEvent: state => state.event_data,
		getResult: state => state.result
	},
	mutations : {
		
		getData(state, datas){
			datas.map((value)=>{
				value.image = value.image.split('/').pop();
			});
			
			state.data = datas;
		},
		getEventData(state, data){
			data.image = data.image.split('/').pop();
			state.event_data = data;
		}
	},
	actions :{
		async user({commit}){			
			return await axios.get('/api/user');
		},
		async userSetting({commit}){			
			return await axios.get('/api/userSetting');
		},
		async logout({commit}){			
			await axios.get('/api/logout').then(response =>{
				console.log('logout api result : ' + response.data);
				
			});
		},
		async login({commit}, data){			
			return await axios.post('/api/login',data);
		},		
		async signUp({commit}, data){			
			return await axios.post('/api/signUp',data);
		},
		async getEventProduct({commit}){			
			await axios.get('/api/hello').then(response =>{
				commit('getData',response.data.data);
			});
		},
		async getEvent({commit}){
			await axios.get('/api/getEvent').then(response =>{
				commit('getEventData',response.data.data);
			});
		},
		async getProducts({commit},params){			
			return await axios.get('/api/products',params);
		},
		
	}
});