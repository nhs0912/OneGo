<!--<template>-->
<!--  <div class="custom-container">-->
<!--    <div>-->
<!--      <h1 class="text-center">Sign In</h1>-->
<!--      <p class="text-[#868e96]">-->
<!--        Don't have an account?-->
<!--        <el-link type="primary" @click="signup()">Sign up</el-link>-->
<!--      </p>-->
<!--      <el-form ref="loginForm" :model="loginData" :rules="loginRules">-->
<!--        <el-form-item label="Username" prop="username">-->
<!--          <el-input v-model="loginData.username" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="Password" prop="password">-->
<!--          <el-input v-model="loginData.password" type="password" autocomplete="off"></el-input>-->
<!--        </el-form-item>-->
<!--        <el-form-item>-->
<!--          <el-button type="primary" @click="login">Login</el-button>-->
<!--        </el-form-item>-->
<!--      </el-form>-->
<!--      <el-alert v-if="loginError" title="Invalid login" type="error"-->
<!--                description="Please check your credentials and try again." />-->
<!--    </div>-->
<!--  </div>-->
<!--</template>-->

<!--<script lang="ts" setup>-->
<!--import { ref } from 'vue';-->
<!--import type { FormInstance, FormRules } from 'element-plus'-->
<!--import axios from "axios";-->
<!--import { useRouter } from "vue-router";-->
<!--const route = useRouter();-->
<!--interface LoginData {-->
<!--  username: string;-->
<!--  password: string;-->
<!--}-->

<!--const loginForm = ref<FormInstance>();-->
<!--const loginData = ref<LoginData>({-->
<!--  username: '',-->
<!--  password: '',-->
<!--});-->

<!--const loginRules = {-->
<!--  username: [{ required: true, message: 'Please enter your username', trigger: 'blur' }],-->
<!--  password: [{ required: true, message: 'Please enter your password', trigger: 'blur' }],-->
<!--};-->

<!--const loginError = ref(false);-->
<!--const login = () => {-->
<!--  loginError.value = false;-->
<!--  (loginForm.value as any).validate((valid: boolean) => {-->
<!--    if (valid) {-->
<!--      console.log("로그인 시도!");-->
<!--      // Perform login logic here-->
<!--      axios.post("http://localhost:8888/signin", {-->
<!--        employeeId: loginData.value.username,-->
<!--        password: loginData.value.password-->
<!--      }).then((response) => {-->
<!--        console.log("login success {}" , response);-->
<!--        let accessToken = response ? response.headers.authorization : undefined;-->
<!--        let refreshToken = response ? response.headers.refreshtoken : undefined;-->
<!--        localStorage.setItem("Authorization",accessToken);-->
<!--        localStorage.setItem("refreshToken",refreshToken);-->
<!--        console.log("login accessToken {}" , accessToken);-->
<!--        console.log("login refreshToken {}" , refreshToken);-->
<!--        goWriteView();-->
<!--      }).catch(function(error) {-->
<!--        console.log("login error {}", error);-->
<!--      });-->
<!--    } else {-->
<!--      loginError.value = true;-->
<!--      console.log("로그인 실패!")-->
<!--    }-->
<!--  });-->
<!--};-->
<!--const signup = function() {-->
<!--  route.push({-->
<!--    path: "/signup"-->
<!--  });-->
<!--};-->
<!--const goWriteView = function() {-->
<!--  route.push(({-->
<!--    path: "/write"-->
<!--  }));-->
<!--};-->
<!--</script>-->

<!--<style scoped>-->
<!--.custom-container {-->
<!--  display: flex;-->
<!--  justify-content: center;-->
<!--  align-items: center;-->
<!--  height: 100vh;-->
<!--}-->
<!--</style>-->