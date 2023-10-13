import axios from 'axios'

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
		return response
    },
    error => {
		console.log(window.location.pathname)
		if(error.response.status === 403){			
			window.location.href = '/login'
			return		
		}

        return Promise.reject(error.response.data)
    },
    async function(error){
		return Promise.reject(error)
    }

)


export default axios
