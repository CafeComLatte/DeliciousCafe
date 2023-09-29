import {createStore} from "vuex"
import axios from 'axios'

export default createStore({
	state : {
		test : null,
		data : null
	},
	mutations : {
		getData(state, datas){
			datas.map((value)=>{
				value.image = value.image.split('/').pop();
			});
			
			state.data = datas;
		}
	},
	actions :{
		async getEventProduct({commit}){
			
		await axios.get('/api/hello').then(response =>{
			console.log(response.data);
			commit('getData',response.data);
		});
	
		}
	}
});