<template>


</template>

<!--<template>-->
<!--  <form-->
<!--    ref="ruleFormRef"-->
<!--    :model="ruleForm"-->
<!--    status-icon-->
<!--    :rules="rules"-->
<!--    label-width="120px"-->
<!--    class="demo-ruleForm"-->
<!--  >-->
<!--    <el-form-item label="id" prop="id">-->
<!--      <el-input v-model="ruleForm.id" type="text" autocomplete="off" />-->
<!--    </el-form-item>-->
<!--    <el-form-item label="Password" prop="pass">-->
<!--      <el-input v-model="ruleForm.pass" type="password" autocomplete="off" />-->
<!--    </el-form-item>-->
<!--    <el-form-item label="Confirm" prop="checkPass">-->
<!--      <el-input-->
<!--        v-model="ruleForm.checkPass"-->
<!--        type="password"-->
<!--        autocomplete="off"-->
<!--      />-->
<!--    </el-form-item>-->
<!--    <el-form-item label="name" prop="name">-->
<!--      <el-input v-model="ruleForm.name" type="text" autocomplete="off" />-->
<!--    </el-form-item>-->
<!--    <el-form-item label="team id" prop="teamId">-->
<!--    <el-select v-model="ruleForm.teamId" class="m-2" placeholder="Select" size="small">-->
<!--      <el-option-->
<!--        v-for="item in teams"-->
<!--        :key="item.value"-->
<!--        :label="item.label"-->
<!--        :value="item.value"-->
<!--      />-->
<!--    </el-select>-->
<!--      </el-form-item>-->

<!--    <el-form-item label="memberRole" prop="memberRole">-->
<!--      <el-select v-model="ruleForm.memberRole" class="m-2" placeholder="Select" size="small">-->
<!--        <el-option-->
<!--          v-for="item in memberRoles"-->
<!--          :key="item.value"-->
<!--          :label="item.label"-->
<!--          :value="item.value"-->
<!--        />-->
<!--      </el-select>-->
<!--      </el-form-item>-->
<!--    <el-form-item>-->
<!--      <el-button type="success" @click="submitForm(ruleFormRef)"-->
<!--      >SignUp-->
<!--      </el-button>-->
<!--      <el-button @click="resetForm(ruleFormRef)">Reset</el-button>-->
<!--      <el-button type="danger" @click="home">back</el-button>-->
<!--    </el-form-item>-->
<!--  </el-form>-->
<!--</template>-->

<!--<script lang="ts" setup>-->
<!--import { reactive, ref } from "vue";-->
<!--import type { FormInstance, FormRules } from "element-plus";-->
<!--import { useRouter } from "vue-router";-->
<!--import axios from "axios";-->

<!--const ruleFormRef = ref<FormInstance>();-->
<!--const router = useRouter();-->

<!--const signUp = function() {-->
<!--  console.log(ruleForm.id, ruleForm.pass);-->
<!--  axios.post("http://localhost:8888/member", {-->
<!--    employeeId: ruleForm.id,-->
<!--    password: ruleForm.pass,-->
<!--    name: ruleForm.name,-->
<!--    teamId: ruleForm.teamId,-->
<!--    memberRole: ruleForm.memberRole-->
<!--  }).then(function(response) {-->
<!--    home();-->
<!--  }).catch(function(error) {-->
<!--    console.log("error== {}", error);-->
<!--  });-->
<!--};-->

<!--// const memberRole = "";-->

<!--const memberRoles = [-->
<!--  {-->
<!--    value: "01",-->
<!--    label: "ADMIN"-->
<!--  },-->
<!--  {-->
<!--    value: "02",-->
<!--    label: "MEMBER",-->
<!--    selected:true-->
<!--  },-->

<!--]-->


<!--const teams = [-->
<!--  {-->
<!--    value: "01",-->
<!--    label: "FO"-->
<!--  },-->
<!--  {-->
<!--    value: "02",-->
<!--    label: "BO"-->
<!--  },-->
<!--  {-->
<!--    value: "03",-->
<!--    label: "CARD"-->
<!--  },-->
<!--]-->

<!--const home = function() {-->
<!--  router.push({ path: "/" });-->
<!--};-->
<!--const checkId = (rule: any, value: any, callback: any) => {-->
<!--  if (!value) {-->
<!--    return callback(new Error("Please input the Id"));-->
<!--  }-->
<!--  setTimeout(() => {-->
<!--    if (!Number.isInteger(value)) {-->
<!--      callback(new Error("Please input digits"));-->
<!--    } else {-->
<!--      if (value.length < 6) {-->
<!--        callback(new Error("The length of id must be greater than 6"));-->
<!--      } else {-->
<!--        callback();-->
<!--      }-->
<!--    }-->
<!--  }, 1000);-->
<!--};-->

<!--const checkName = (rule: any, value: any, callback: any) => {-->
<!--  if (!value) {-->
<!--    return callback(new Error("Please input the name"));-->
<!--  }-->
<!--  setTimeout(() => {-->
<!--    if (!Number.isInteger(value)) {-->
<!--      callback(new Error("Please input digits"));-->
<!--    } else {-->
<!--      if (value.length() < 6) {-->
<!--        callback(new Error("The length of name must be greater than 6"));-->
<!--      } else {-->
<!--        callback();-->
<!--      }-->
<!--    }-->
<!--  }, 1000);-->
<!--};-->

<!--const validateId = (rule: any, value: any, callback: any) => {-->
<!--  if (value === "") {-->
<!--    callback(new Error("Please input the id"));-->
<!--  } else {-->
<!--    if (ruleForm.id !== "") {-->
<!--      if (!ruleFormRef.value) return;-->
<!--      ruleFormRef.value.validateField("checkId", () => null);-->
<!--    }-->
<!--    callback();-->
<!--  }-->
<!--};-->
<!--const validatePass = (rule: any, value: any, callback: any) => {-->
<!--  if (value === "") {-->
<!--    callback(new Error("Please input the password"));-->
<!--  } else {-->
<!--    if (ruleForm.checkPass !== "") {-->
<!--      if (!ruleFormRef.value) return;-->
<!--      ruleFormRef.value.validateField("checkPass", () => null);-->
<!--    }-->
<!--    callback();-->
<!--  }-->
<!--};-->
<!--const validatePass2 = (rule: any, value: any, callback: any) => {-->
<!--  if (value === "") {-->
<!--    callback(new Error("Please input the password again"));-->
<!--  } else if (value !== ruleForm.pass) {-->
<!--    callback(new Error("Two inputs don't match!"));-->
<!--  } else {-->
<!--    callback();-->
<!--  }-->
<!--};-->

<!--const validateName = (rule: any, value: any, callback: any) => {-->
<!--  if (value === "") {-->
<!--    callback(new Error("Please input the name"));-->
<!--  } else {-->
<!--    if (ruleForm.name !== "") {-->
<!--      if (!ruleFormRef.value) return;-->
<!--      ruleFormRef.value.validateField("checkName", () => null);-->
<!--    }-->
<!--    callback();-->
<!--  }-->
<!--};-->

<!--const ruleForm = reactive({-->
<!--  pass: "",-->
<!--  checkPass: "",-->
<!--  id: "",-->
<!--  name: "",-->
<!--  teamId: "",-->
<!--  memberRole:""-->
<!--});-->

<!--const rules = reactive<FormRules<typeof ruleForm>>({-->
<!--  pass: [{ validator: validatePass, trigger: "blur" }],-->
<!--  checkPass: [{ validator: validatePass2, trigger: "blur" }],-->
<!--  id: [{ validator: validateId, trigger: "blur" }],-->
<!--  name: [{ validator: validateName, trigger: "blur" }]-->
<!--});-->

<!--const submitForm = (formEl: FormInstance | undefined) => {-->
<!--  if (!formEl) return;-->
<!--  formEl.validate((valid) => {-->
<!--    if (valid) {-->
<!--      signUp();-->
<!--      console.log("submit!");-->

<!--    } else {-->
<!--      console.log("error submit!");-->
<!--      return false;-->
<!--    }-->
<!--  });-->
<!--};-->

<!--const resetForm = (formEl: FormInstance | undefined) => {-->
<!--  if (!formEl) return;-->
<!--  formEl.resetFields();-->
<!--};-->
<!--</script>-->
