// Utilities
import { defineStore } from 'pinia'

export const useAppStore = defineStore('app', {
  state: () => ({
    isLogin : false
  }),
  actions: {
    signin() {
      this.isLogin = true;
    },
    logout() {
      this.isLogin = false;
    }
  }
})
