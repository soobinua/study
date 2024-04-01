<!-- @format -->

<template lang="">
  <div></div>
  <TodoListItem
    v-for="todoItem in todoList"
    :key="todoItem.id"
    :todoItem="todoItem"
    @delete-todo="$emit('deleteTodo', $event)"
    @toggle-completed="$emit('toggleCompleted', $event)"
  />
  <!-- emit()함수를 이용해 이벤트 발신 -->
</template>
<script setup>
import TodoListItem from "./TodoListItem.vue";

const props = defineProps({
  //defineProps 함수를 이용해 속성 정의
  todoList: { type: Array },
});

const emit = defineEmits(["deleteTodo", "toggleCompleted"]); //이벤트 발신을 위해 defineEmits 함수 이용해 정의

//script setup
// export default {
//   name: "TodoList",
//   components: { TodoListItem },
//   props: {
//     todoList: { type: Array },
//   },
//   emits: ["deleteTodo", "toggleCompleted"],
// };
</script>
<style lang=""></style>
