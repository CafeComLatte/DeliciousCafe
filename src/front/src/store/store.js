import {createStore} from "vuex"
import axios from '@/axios/index.js'

export default createStore({
	state : {
		user : null,
		data : null,
		event_data : {}
	},
	getters: {
		getEvent: state => state.event_data,
		getUser: state => state.user
	},
	mutations : {
		setUser(state, response){
			state.user = response;
		},
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
		async login({commit}){			
			await axios.post('/api/login',{id:'test',password:'test'}).then((response) =>{
				
				commit('setUser',response.data.status)
			});
	
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
	
		}
		
	}
});