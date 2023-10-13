import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router'
import store from './store/store'
import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
import * as directives from "vuetify/directives";

const vuetify = createVuetify({
  components,
  directives,
});

const app = createApp(App)
.use(vuetify)
.use(store)
.use(router)

app.config.globalProperties.$store = store;
app.config.globalProperties.$router = router;

app.mount('#app')