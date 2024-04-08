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
<script>
import { reactive } from "vue";
import InputTodo from "./components/InputTodo.vue";
import TodoList from "./components/TodoList.vue";

export default {
  name: "App",
  components: { InputTodo, TodoList },
  setup() {
    const state = reactive({ todoList: [] }); //반응성 데이터
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

    return { state, addTodo, deleteTodo, toggleCompleted };
  },
  // setup()
  // data() {
  //   return {
  //     todoList: [],
  //   };
  // },
  // methods: {
  //   addTodo(todo) {
  //     this.todoList.push({
  //       id: new Date().getTime(),
  //       todo: todo,
  //       completed: false,
  //     });
  //     console.log("todoList> ", this.todoList);
  //   },
  //   deleteTodo(id) {
  //     this.todoList = this.todoList.filter((item) => item.id !== id);
  //   },
  //   toggleCompleted(id) {
  //     let index = this.todoList.findIndex((item) => item.id === id);
  //     this.todoList[index].completed = true;
  //     console.log("todo > ", this.todoList);
  //   },
  // },
};
</script>
<style lang=""></style>
