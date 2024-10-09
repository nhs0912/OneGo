import { createRouter, createWebHistory } from 'vue-router'
import HomeView from "../views/HomeView.vue"
import LoginView from "@/views/LoginView.vue";
import ToastEditor from "@/views/ToastEditor.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: "/signin"
    },
    {
      path: '/home',
      name: 'Home',
      component: HomeView
    },
    {
      path: '/signin',
      name: 'signin',
      component: LoginView
    },
    // {
    //   path: '/signup',
    //   name: 'signup',
    //   component: SignUpView
    // },
    {
      path: '/write',
      name: 'write',
      component: ToastEditor
    }
  ]
})

export default router
