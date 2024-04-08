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

// 실행하면 1초 간격으로 순차적으로 결과가 출력
// async/await 문법으로 해결 가능. 비동기로 처리하려면 함수 앞부분에 async 작성하고 함수 내부에서는 Promist 리턴하는 함수 호출 구문 앞에 await 작성 (App2.vue 참고)
//데이터를 순회하면서 비동기 처리할 때 편리
//4건의 목록을 조회한 후 첫번째, 두번째 할일을 순차적으로 조회
const requestAPI = async () => {
  let todoList;

  //비동기 처리를 필요로 하는 호출 구문 앞에는 await 붙여 Promise가 처리될때까지 대기했다가 결과 받아낼 수 있다.
  let response = await axios.get(listUrl);
  todoList = response.data;
  console.log("TodoList > ", todoList);

  response = await axios.get(todoUrlPrefix + todoList[0].id);
  console.log("첫번째 Todo > ", response.data);

  response = await axios.get(todoUrlPrefix + todoList[1].id);
  console.log("두번째 Todo > ", response.data);
};

//전체 목록을 조회한 후 한 건씩 순차적으로 순회하며 조회
// const requestAPI = async () => {
//   let todoList: Array<TodoType>;
//   let response = await axios.get(listUrl);
//   todoList = response.data;
//   console.log("TodoList > ", todoList);
//   for (let i = 0; i < todoList.length; i++) {
//     response = await axios.get(todoUrlPrefix + todoList[i].id);
//     console.log(`${i + 1} 번째 Todo > `, response.data);
//   }
// };

requestAPI();
</script>
<style></style>
