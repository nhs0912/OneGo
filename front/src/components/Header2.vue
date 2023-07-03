<script setup lang="ts">
import { useDark, useToggle } from "@vueuse/core";

const [value, toggle] = useToggle();

const isDark = useDark({
  storageKey: "vitepress-theme-appearance"
});
const toggleDark = useToggle(isDark);
</script>
<template>
  <el-header
    class="relative border-b border-solid border-b-gray-200 p-0 w-full h-full bg-white dark:bg-[#242424] dark:border-b-gray-900">
    <el-menu mode="horizontal" router>
      <el-menu-item index="/">Home</el-menu-item>
      <el-menu-item index="/write">글 작성</el-menu-item>

      <el-menu-item index="/signup" class="hidden items-center space-x-6 lg:flex">
        회원가입
      </el-menu-item>
      <el-menu-item @click="toggleDark()" style="align : right">
        <i inline-block align-middle i="dark:carbon-moon carbon-sun" />
        <span class="ml-2">{{ isDark ? "Dark" : "Light" }}</span>
      </el-menu-item>
    </el-menu>
  </el-header>
</template>

<style scoped>
.header {
  padding: 0;
  height: 60px;
}
</style>
