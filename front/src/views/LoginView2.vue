<script setup lang="ts">
import { ref, reactive } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
// import type { FormInstance } from "element-plus";
// import { reactive } from "vue/dist/vue";
import type { FormRules } from "element-plus";

const checked = ref(false);
const route = useRouter();

// const ruleFormRef = ref<FormInstance>();
const ruleForm = reactive({
  id: ""
  , password: ""
});


const submitForm = function() {
  axios.post("http://localhost:8888/signin", {
    employeeId: ruleForm.id,
    password: ruleForm.password
  }).then((response) => {
    console.log("login success {}" , response);
    let accessToken = response ? response.headers.authorization : undefined;
    let refreshToken = response ? response.headers.refreshtoken : undefined;
    localStorage.setItem("Authorization",accessToken);
    localStorage.setItem("refreshToken",refreshToken);
    console.log("login accessToken {}" , accessToken);
    console.log("login refreshToken {}" , refreshToken);
    goWriteView();
  }).catch(function(error) {
    console.log("login error {}", error);
  });
};
const signup = function() {
  route.push({
    path: "/signup"
  });
};

const goWriteView = function() {
  route.push(({
    path: "/write"
  }));
};
const checkId = (rule: any, value: any, callback: any) => {
  if (!value) {
    return callback(new Error("Please input the Id"));
  }
  setTimeout(() => {
    if (!Number.isInteger(value)) {
      callback(new Error("Please input digits"));
    } else {
      if (value.length < 6) {
        callback(new Error("The length of id must be greater than 6"));
      } else {
        callback();
      }
    }
  }, 1000);
};

const checkPw = (rule: any, value: any, callback: any) => {
  if (!value) {
    return callback(new Error("Please input the password2"));
  }
  setTimeout(() => {
    if (!Number.isInteger(value)) {
      callback(new Error("Please input digits"));
    } else {
      if (value.length < 6) {
        callback(new Error("The length of id must be greater than 6"));
      } else {
        callback();
      }
    }
  }, 1000);
};

// const validateId = (rule: any, value: any, callback: any) => {
//   if (value === "") {
//     callback(new Error("Please input the id"));
//   } else {
//     if (ruleForm.id !== "") {
//       if (!ruleFormRef.value) return;
//       ruleFormRef.value.validateField("checkId", () => null);
//     }
//     callback();
//   }
// };
// const validatePass = (rule: any, value: any, callback: any) => {
//   if (value === "") {
//     callback(new Error("Please input the password"));
//   } else {
//     if (ruleForm.password !== "") {
//       if (!ruleFormRef.value) return;
//       ruleFormRef.value.validateField("checkPw", () => null);
//     }
//     callback();
//   }
// };


// const rules = reactive<FormRules<typeof ruleForm>>({
//   password: [{ validator: validatePass, trigger: "blur" }],
//   id: [{ validator: validateId, trigger: "blur" }]
// });

</script>

<template>

  <el-card shadow="never" class="w-full max-w-md" :body-style="{ padding: 20 }">
    <div class="m-8 text-center">
      <el-link
        href="https://element-plus.org/en-US/"
        :underline="false"
        class="m-0"
      >
        <img
          src="https://element-plus.org/images/element-plus-logo.svg"
          class="block w-[120px] h-[28px]"
          alt="Element Plus"
        />
      </el-link>
      <h2 class="my-3">Log in</h2>
      <p class="text-[#868e96]">
        Don't have an account?
        <el-link type="primary" @click="signup()">Sign up</el-link>
      </p>
    </div>
    <el-form label-position="top">
      <el-form-item label="Id">
        <el-input size="large" type="text" v-model="ruleForm.id" autocomplete="off" />
      </el-form-item>
      <el-form-item label="Password">
        <el-input size="large" v-model="ruleForm.password" type="password" autocomplete="off" />
      </el-form-item>
      <div class="flex justify-between mb-2">
        <el-checkbox v-model="checked" label="Remember me" size="large" />
        <el-link type="primary">Forgot password?</el-link>
      </div>
      <el-button type="primary" size="large" class="w-full" @click="submitForm(ruleFormRef)">Sign in</el-button>
    </el-form>
  </el-card>

</template>