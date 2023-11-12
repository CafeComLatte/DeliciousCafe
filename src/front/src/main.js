import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router'
import store from './store/store'
import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components"
import * as directives from "vuetify/directives"

import LoadingView from '@/components/utils/LoadingView'
import NoDataView from '@/components/utils/NoDataView'
import AlertDialog from "@/components/dialog/AlertDialog"
import UserInfoChangeDialog from "@/components/dialog/UserInfoChangeDialog"

import {ref} from 'vue'

const v = ref(7);

const vuetify = createVuetify({
  components,
  directives,
});

const app = createApp(App)
.component('LoadingView',LoadingView)
.component('NoDataView',NoDataView)
.component('AlertDialog',AlertDialog)
.component('UserInfoChangeDialog',UserInfoChangeDialog)

.use(vuetify)
.use(store)
.use(router)

app.config.globalProperties.$store = store;
app.config.globalProperties.$router = router;
app.config.globalProperties.$getPriceFormat = (price) => {
	price = String(price);
	return price.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,')+"원";
};
app.config.globalProperties.$getImgFormat = (img) => {	
	img = img.split('/').pop();
	return require(`@/assets/img/${img}`);
};
app.config.globalProperties.$getDateFormat = (date) => {
	date = String(date);
	return date.replace(/(\d{4})(\d{2})(\d{2})/g,'$1/$2/$3');
};
app.config.globalProperties.$getTimeFormat = (time) => {
	time = String(time);
	return time.replace(/(\d{2})(\d{2})/g,'$1:$2');
};

app.mount('#app')