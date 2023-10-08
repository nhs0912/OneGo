<script setup lang="ts" >
import { ref } from "vue";
import axios from "axios";


const title = ref("");
const content = ref("");

axios.interceptors.request.use(function(config){
  console.log("localStorage.getItem('Authorization')==== "+ localStorage.getItem('Authorization'))
  config.headers['Authorization'] = localStorage.getItem('Authorization');
  return config;
}, function(error){
  return Promise.reject(error);
});

const write = function(){
  console.log(title.value , content.value)
  // axios.get("http://localhost:8080/write");
  axios.post("http://localhost:8888/test",{
    title : title.value,
    content: content.value
  } ).then(function(response){
    console.log("write success " + response);
  }).catch(function(error){
    console.log("write error " + error)
  });

}

 const editor =  new Editor({
    el: document.querySelector('#editor'),
    height: '500px',
    initialEditType: 'markdown',
    previewStyle: 'vertical'
  });



</script>
<template>
  <h1>글작성</h1>
<!--    <el-input-->
<!--      v-model="title"-->
<!--      autosize-->
<!--      type="textarea"-->
<!--      placeholder="제목을 입력해주세요."-->
<!--    />-->
<!--    <div style="margin: 20px 0" />-->
<!--    <el-input-->
<!--      v-model="content"-->
<!--      :autosize="{ minRows: 5, maxRows: 15 }"-->
<!--      type="textarea"-->
<!--      placeholder="Please input"-->
<!--    />-->
  <div id="editor"></div>
  <div class="mt-2">
    <div class="d-flex justify-content-end">
      <el-button type="primary" @click="write()">저장</el-button>
    </div>
  </div>



  </template>
