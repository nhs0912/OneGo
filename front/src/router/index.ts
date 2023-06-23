import { createRouter, createWebHistory } from 'vue-router'
import HomeView from "../views/HomeView.vue"
import Login from "@/views/Login.vue"
import SignUpView from "@/views/SignUpView.vue";
import WriteView from "@/views/WriteView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: HomeView
    },
    {
      path: '/signUp',
      name: 'SignUp',
      component: SignUpView
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/write',
      name: 'write',
      component: WriteView
    },

    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
