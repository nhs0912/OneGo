<template>
  <el-form
    ref="ruleFormRef"
    :model="ruleForm"
    status-icon
    :rules="rules"
    label-width="120px"
    class="demo-ruleForm"
  >

    <el-form-item label="id" prop="id">
      <el-input v-model="ruleForm.id" type="text" autocomplete="off" />
    </el-form-item>
    <el-form-item label="Password" prop="pass">
      <el-input v-model="ruleForm.pass" type="password" autocomplete="off" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm(ruleFormRef)">SignIn</el-button>
      <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
      <el-button type="success" @click="signup()">SignUp</el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive, ref } from "vue";
import type { FormInstance, FormRules } from "element-plus";
import { useRouter } from "vue-router";

const ruleFormRef = ref<FormInstance>();

const route = useRouter();
const signup = function() {
  route.push({
    path: "/signup"
  });
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

const validateId = (rule: any, value: any, callback: any) => {
  if (value === "") {
    callback(new Error("Please input the id"));
  } else {
    if (ruleForm.id !== "") {
      if (!ruleFormRef.value) return;
      ruleFormRef.value.validateField("checkId", () => null);
    }
    callback();
  }
};
const validatePass = (rule: any, value: any, callback: any) => {
  if (value === "") {
    callback(new Error("Please input the password"));
  } else {
    if (ruleForm.checkPass !== "") {
      if (!ruleFormRef.value) return;
      ruleFormRef.value.validateField("checkPass", () => null);
    }
    callback();
  }
};

const ruleForm = reactive({
  pass: "",
  id: ""
});

const rules = reactive<FormRules<typeof ruleForm>>({
  pass: [{ validator: validatePass, trigger: "blur" }],
  id: [{ validator: validateId, trigger: "blur" }]
});

const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.validate((valid) => {
    if (valid) {
      console.log("submit!");
    } else {
      console.log("error submit!");
      return false;
    }
  });
};

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.resetFields();
};
</script>
