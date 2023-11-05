import axios from 'axios'
import {ref} from 'vue'

const v = ref(4);

axios.defaults.timeout = 5000
axios.defaults.baseURL = 'http://localhost:8080'

axios.interceptors.request.use(config => {
	config.withCredentials = false

    return config
}, error => {
    console.error('axios error : ', error)
    return Promise.reject(error)
})

axios.interceptors.response.use(
    response => {
		if(!localStorage.getItem('id') && window.location.href.startsWith('/site')){
			window.location.href = '/login'
		}
		return response
    },
    error => {
		console.error('axios error : ', error)
		if(error.response.status === 403){			
			window.location.href = '/login'
			return		
		}
		console.error('axios error : ', error.response.data)
        return Promise.reject(error.response.data)
    },
    async function(error){
		console.error('axios error : ', error)
		return Promise.reject(error)
    }

)


export default axios
