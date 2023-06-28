<template>
  <el-header class="header">
    <el-menu mode="horizontal" router>
      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/write">글작성</RouterLink>
      <el-button @click="toggleDark()"
      style="align : right">
        <i inline-block align-middle i="dark:carbon-moon carbon-sun" />
        <span class="ml-2">{{ isDark ? 'Dark' : 'Light' }}</span>
      </el-button>
    </el-menu>
  </el-header>

</template>

<script setup lang="ts">
import { useToggle } from '@vueuse/shared'
import { useDark } from '@vueuse/core'

function toggleMode() {
  console.log("확인");
  window.matchMedia('(prefers-color-scheme: light)');
}

const isDark = useDark({
  storageKey: 'vitepress-theme-appearance',
})

// const isDark = useDark()
const toggleDark = useToggle(isDark)

</script>

<style scoped>
.header {
  padding: 0;
  height: 60px;
}
</style>
