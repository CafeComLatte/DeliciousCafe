import {createStore} from "vuex"
import axios from '@/axios/index.js'
import {ref} from 'vue'

const v = ref(18);

export default createStore({
	state : {
		loading : false,
		dialog_alert : false,
		dialog_alert_info : {
			content : '',
			dialog_type : '',
			callback_type : ''
		},
		user_dialog_alert : false,
		user_dialog_alert_info : {
			item_name : '',
			item_value : ''
		},
		data : null,
		event_data : {image:''}
	},
	getters: {
		getEvent: state => state.event_data,
		getResult: state => state.result,
		getDialogAlertInfo: state => state.dialog_alert_info
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
		},
		openLoading(state){
			state.loading = true;
		},
		closeLoading(state){
			state.loading = false;
		},
		openDialogAlert(state,data){
			state.dialog_alert_info.content = data.content;
			state.dialog_alert_info.dialog_type = data.dialog_type;
			state.dialog_alert_info.callback_type = data.callback_type;
			state.dialog_alert = true;
		},
		openUserInfoChangeDialog(state,data){
			state.user_dialog_alert_info = data;
			state.user_dialog_alert = true;
		},
		closeUserInfoChangeDialog(state){
			state.user_dialog_alert_info = null;
			state.user_dialog_alert = false;
		},
		closeDialogAlert(state){
			state.dialog_alert_info = null;
			state.dialog_alert = false;
		}
	},
	actions :{
		openLoading({commit}){
			commit('openLoading');
		},
		closeLoading({commit}){
			commit('closeLoading');
		},
		openDialogAlert({commit},data){
			commit('openDialogAlert',data);
		},
		closeDialogAlert({commit}){
			commit('closeDialogAlert');
		},
		openUserInfoChangeDialog({commit},data){
			commit('openUserInfoChangeDialog',data);
		},
		closeUserInfoChangeDialog({commit}){
			commit('closeUserInfoChangeDialog');
		},
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
		signUp({commit}, data){			
			return axios.post('/api/signUp',data);
		},
		async idCheck({commit},data){
			return await axios.get('/api/signUp/idCheck',data);
		},
		async updateUserInfo({commit},data){
			return await axios.patch('/api/user/updateUserInfo',data);		
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
		async getProduct({commit},id){
			return await axios.get('/api/products/' + id);
		},
		async getPayments({commit},params){			
			return await axios.get('/api/payments',params);
		},
		payProduct({commit},params){			
			return axios.post('/api/payProduct',params);
		},
		
	}
});