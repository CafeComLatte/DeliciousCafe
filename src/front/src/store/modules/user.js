import axios from '@/axios/index.js'
import {ref} from 'vue'

const v = ref(2);

const user = {
	namespaced: true,
	state : {
		user_dialog_alert : false,
		user_dialog_alert_info : {
			item_name : '',
			item_value : ''
		},
		dialog_alert : false,
		dialog_alert_info : {
			content : '',
			dialog_type : '',
			callback_type : ''
		},		
	},
	getters : {
		getDialogAlertInfo: state => state.dialog_alert_info
	},
	mutations : {
		openUserInfoChangeDialog(state,data){
			state.user_dialog_alert_info = data;
			state.user_dialog_alert = true;
		},
		closeUserInfoChangeDialog(state){
			state.user_dialog_alert_info = null;
			state.user_dialog_alert = false;
		},
		openDialogAlert(state,data){
			state.dialog_alert_info.content = data.content;
			state.dialog_alert_info.dialog_type = data.dialog_type;
			state.dialog_alert_info.callback_type = data.callback_type;
			state.dialog_alert = true;
		},
		
		closeDialogAlert(state){
			state.dialog_alert_info = null;
			state.dialog_alert = false;
		}		
	},
	actions : {
		openUserInfoChangeDialog({commit},data){
			commit('openUserInfoChangeDialog',data);
		},
		closeUserInfoChangeDialog({commit}){
			commit('closeUserInfoChangeDialog');
		},
		user({commit}){			
			return axios.get('/api/user');
		},
		userSetting({commit}){			
			return axios.get('/api/userSetting');
		},
		updateUserInfo({commit},data){
			return axios.patch('/api/user/updateUserInfo',data);		
		},
		updateUserSettingInfo({commit},data){
			return axios.patch('/api/user/updateUserSettingInfo',data);
		},
		
		openDialogAlert({commit},data){
			commit('openDialogAlert',data);
		},
		closeDialogAlert({commit}){
			commit('closeDialogAlert');
		},
		
		logout({commit}){			
			axios.get('/api/logout').then(response =>{
				console.log('logout api result : ' + response.data);
				
			});
		},
		login({commit}, data){			
			return axios.post('/api/login',data);
		},		
		signUp({commit}, data){			
			return axios.post('/api/signUp',data);
		},
		idCheck({commit},data){
			return axios.get('/api/signUp/idCheck',data);
		},
	
	}
};

export default user;