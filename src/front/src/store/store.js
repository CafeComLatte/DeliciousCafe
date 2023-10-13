import {createStore} from "vuex"
import axios from '@/axios/index.js'

export default createStore({
	state : {
		result : false,
		data : null,
		event_data : {}
	},
	getters: {
		getEvent: state => state.event_data,
		getResult: state => state.result
	},
	mutations : {
		setResult(state, response){
			console.log(response);
			state.result = response;
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
		
		async signUp({commit}, data){			
			await axios.post('/api/signUp',data).then((response) =>{
				console.log('data1 : ' + response.data);
				if(response.data.result === true){
					localStorage.setItem('id',data.id);
					localStorage.setItem('name',data.name);
					console.log("login success id :" + localStorage.getItem('id') + ', name : ' + localStorage.getItem('name'));
					
					commit('setResult',true);
				}
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