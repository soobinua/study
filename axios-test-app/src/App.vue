<!-- @format -->

<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from "axios";

const listUrl = "/api/todolist_long/gdhong";
const todoUrlPrefix = "/api/todolist_long/gdhong/";

//4건의 목록을 조회한 후 첫번째, 두번째 할일을 순차적으로 조회
const requestAPI = () => {
  // const url = "http://localhost:8000/todolist/gdhong";
  // const url = "/api/todolist/gdhong";
  // axios.get(url).then((response) => {
  //   console.log("response >", response);
  // });

  // 실행하면 1초 간격으로 순차적으로 결과가 출력
  // TodoList를 모두 받아온 뒤 하나씩 순차적으로 접근하려면 재귀 함수로 순회하도록 작성해야해서 복잡
  // TODO. async/await 문법으로 해결 가능. 비동기로 처리하려면 함수 앞부분에 async 작성하고 함수 내부에서는 Promist 리턴하는 함수 호출 구문 앞에 await 작성 (App2.vue 참고)
  let todoList = [];
  axios
    .get(listUrl) // TodoList 요청
    .then((response) => {
      //받아온 TodoList 출력 후 첫번째 Todo의 id 리턴
      todoList = response.data;
      console.log("TodoList >", todoList);
      return todoList[0].id;
    })
    .then((id) => {
      //직전 리턴된 id를 인자로 받아 axios.get() 요청 후 Promise 리턴
      return axios.get(todoUrlPrefix + id);
    })
    .then((response) => {
      //응답된 첫번째 Todo 출력하고 두번째 Todo의 id 리턴
      console.log("첫번째 Todo : ", response.data);
      return todoList[1].id;
    })
    .then((id) => {
      //직전 리턴된 id를 인자로 받아 axios.get() 요청 후 Promise 리턴
      axios.get(todoUrlPrefix + id).then((response) => {
        //응답된 두번째 Todo 출력하고 종료
        console.log("두번째 Todo : ", response.data);
      });
    });
};
requestAPI();
</script>

<!-- localhost/:1 Access to XMLHttpRequest at 'http://localhost:8000/todolist/gdhong' 
  from origin 'http://localhost:5173' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource. -->
<!-- 오리진이 다르기 때문에 CORS 크로스 오리진 발생 : vite.config.js에서 proxy를 이용해 해결 -->

<style></style>
