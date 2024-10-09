import { createApp } from 'vue'
import { createPinia } from 'pinia'

// @ts-ignore
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify.js' // vuetify.ts 파일 위치에 맞게 수정
import store from './stores/vuex/store'  //1. store 추가

const app = createApp(App)
    .use(vuetify)
    .use(router)
    .use(store)

app.config.globalProperties.$serverUrl = "//localhost:8888"
app.config.globalProperties.$store = store


// app.use(
//   cors({
//     exposedHeaders : ['Authorization']
//   }),
// );
app.mount('#app')
