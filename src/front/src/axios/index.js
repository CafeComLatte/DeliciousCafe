import axios from 'axios'
import router from '@/router/router'

axios.defaults.timeout = 5000
axios.defaults.baseURL = 'http://localhost:8080'

axios.interceptors.request.use(config => {
	config.withCredentials = true

    return config
}, error => {
    console.log('axios request error : ', error)
    return Promise.reject(error)
})

axios.interceptors.response.use(
    response => {
		if(response.status === '403' && window.location.pathname !== '/site/login')
			router.push('/site/login')	
		return response
    },
    error => {
		
        console.error('[axios.interceptors.response] response : ', error.message)

        return Promise.reject(error.response.data)
    },
    async function(error){
        return Promise.reject(error)
    }

)


export default axios
