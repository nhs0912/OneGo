<template>
  <el-header class="header">
    <el-menu mode="horizontal" router>

      <RouterLink to="/">Home</RouterLink>
      <RouterLink to="/Login">Login</RouterLink>
      <RouterLink to="/write">글작성</RouterLink>
      <el-button type="info" @click="toggleMode">dark//light mode</el-button>

    </el-menu>
  </el-header>

</template>

<script setup lang="ts">
function toggleMode() {
  console.log("확인");
  window.matchMedia('(prefers-color-scheme: light)');
}

</script>

<style scoped>
.header {
  padding: 0;
  height: 60px;
}
</style>
