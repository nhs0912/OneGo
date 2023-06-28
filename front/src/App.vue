<script setup lang="ts">
// import { useDark, useToggle } from '@vueuse/core'
import Header from "@/components/Header.vue";
import Content from "@/components/Content.vue";
import SignUp from "@/views/SignUpView.vue";
import Login from "@/views/Login.vue";


</script>

<template>
  <Header/>

  <RouterView/>

</template>

<style>
body {
  font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto,
  "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR",
  "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol",
  sans-serif;
}
</style>
