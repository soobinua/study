<!-- @format -->

<template lang="">
  <div id="app">
    <div>TodoList APP</div>
    <InputTodo @addTodo="addTodo" />
    <TodoList
      :todoList="state.todoList"
      @delete-todo="deleteTodo"
      @toggle-completed="toggleCompleted"
    />
  </div>
  <div>
    <div></div>
  </div>
</template>
<script setup>
//script setup의 최상위 범위에 작성한 변수,함수는 모두 템플릿에서 이용가능
import { onMounted, reactive } from "vue";
import InputTodo from "./components/InputTodo.vue";
import TodoList from "./components/TodoList.vue";

const state = reactive({ todoList: [] });

onMounted(() => {
  //생명주기 훅은 const나 let키워드 사용안함
  //state.todoList.push({})
});

const addTodo = (todo) => {
  state.todoList.push({
    id: new Date().getTime(),
    todo: todo,
    completed: false,
  });
};

const deleteTodo = (id) => {
  state.todoList = state.todoList.filter((item) => item.id !== id);
};
const toggleCompleted = (id) => {
  let index = state.todoList.findIndex((item) => item.id === id);
  state.todoList[index].completed = true;
};

//script setup
// export default {
//   name: "App",
//   components: { InputTodo, TodoList },
//   setup() { //setup()사용안함
//     const state = reactive({ todoList: [] }); //반응성 데이터
//     const addTodo = (todo) => {
//       state.todoList.push({
//         id: new Date().getTime(),
//         todo: todo,
//         completed: false,
//       });
//     };
//     const deleteTodo = (id) => {
//       state.todoList = state.todoList.filter((item) => item.id !== id);
//     };
//     const toggleCompleted = (id) => {
//       let index = state.todoList.findIndex((item) => item.id === id);
//       state.todoList[index].completed = true;
//     };

//     return { state, addTodo, deleteTodo, toggleCompleted }; //객체 return 삭제
//   },
// };
</script>
<style lang=""></style>
