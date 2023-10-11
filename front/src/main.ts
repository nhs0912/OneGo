import { createApp } from 'vue'
import { createPinia } from 'pinia'

// @ts-ignore
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/theme-chalk/dark/css-vars.css'
import 'element-plus/dist/index.css'
import "bootstrap/dist/css/bootstrap-utilities.css"
import store from './stores/vuex/store'  //1. store 추가

const app = createApp(App)
app.config.globalProperties.$serverUrl = "//localhost:8888"
app.config.globalProperties.$store = store

app.use(createPinia())
app.use(ElementPlus)
app.use(router)
app.use(store)

// app.use(
//   cors({
//     exposedHeaders : ['Authorization']
//   }),
// );
app.mount('#app')
