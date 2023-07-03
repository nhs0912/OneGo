<template>
<!--  <el-header class="header">-->
<!--    <el-menu mode="horizontal" router>-->
<!--      <RouterLink to="/">Home</RouterLink>-->
<!--      <RouterLink to="/write">글작성</RouterLink>-->
<!--      <el-button @click="toggleDark()"-->
<!--      style="align : right">-->
<!--        <i inline-block align-middle i="dark:carbon-moon carbon-sun" />-->
<!--        <span class="ml-2">{{ isDark ? 'Dark' : 'Light' }}</span>-->
<!--      </el-button>-->
<!--    </el-menu>-->



    <el-header
      class="relative border-b border-solid border-b-gray-200 p-0 w-full h-full bg-white dark:bg-[#242424] dark:border-b-gray-900"
    >
      <div class="flex justify-between items-center p-4">
        <div class="flex items-center justify-center">
        <span
          class="mr-3 w-5 h-5 bg-white cursor-pointer lg:hidden dark:bg-[#242424]"
          @click="toggle()"
        >
          <a v-if="value">
            <el-icon size="20">
              <Close />
            </el-icon>
          </a>
          <a class="block relative h-full" v-else>
            <el-icon
              class="absolute -top-[6px] left-1/2 transform -translate-x-1/2"
              size="20"
            >
              <Minus />
            </el-icon>
            <el-icon
              class="absolute -top-[0] left-1/2 transform -translate-x-1/2"
              size="20"
            >
              <Minus />
            </el-icon>
            <el-icon
              class="absolute top-[6px] left-1/2 transform -translate-x-1/2"
              size="20"
            >
              <Minus />
            </el-icon>
          </a>
        </span>

          <a href="https://element-plus.org/en-US/">
            <span class="sr-only">Element Plus</span>
            <img
              src="https://element-plus.org/images/element-plus-logo.svg"
              alt="Element Plus"
              class="block max-w-none w-[120px] h-[28px]"
            />
          </a>
        </div>
        <div>
          <nav class="flex space-x-6">
            <ul class="hidden items-center space-x-6 lg:flex">
              <li>
                <el-link
                  href="https://element-plus.org/en-US/guide/design.html"
                  target="_blank"
                >
                  Guide
                </el-link>
              </li>
              <li>
                <el-link
                  href="https://element-plus.org/en-US/component/button.html"
                  target="_blank"
                >
                  Component
                </el-link>
              </li>
              <li>
                <el-link
                  href="https://element-plus.org/en-US/resource/index.html"
                  target="_blank"
                >
                  Resource
                </el-link>
              </li>
            </ul>
            <el-input v-model="input" placeholder="Search" />
          </nav>
        </div>
      </div>

      <nav
        class="absolute border-b border-solid border-b-gray-200 py-4 w-full bg-white text-center lg:hidden dark:bg-[#242424] dark:border-b-gray-900"
        v-if="value"
      >
        <ul class="flex flex-col space-y-5">
          <li>
            <el-link
              href="https://element-plus.org/en-US/guide/design.html"
              target="_blank"
            >
              Guide
            </el-link>
          </li>
          <li>
            <el-link
              href="https://element-plus.org/en-US/component/button.html"
              target="_blank"
            >
              Component
            </el-link>
          </li>
          <li>
            <el-link
              href="https://element-plus.org/en-US/resource/index.html"
              target="_blank"
            >
              Resource
            </el-link>
          </li>
        </ul>
      </nav>
    </el-header>
  </template>

<script setup lang="ts">
// import { useToggle } from '@vueuse/shared'
import { useDark } from '@vueuse/core'
import { ref } from "vue";
import { useToggle } from '@vueuse/core'


const input = ref('')
const [value, toggle] = useToggle()
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
