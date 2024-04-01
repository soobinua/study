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
</template>
<script>
import TodoListItem from "./TodoListItem.vue";

export default {
  name: "TodoList",
  components: { TodoListItem },
  props: {
    todoList: { type: Array },
  },
  emits: ["deleteTodo", "toggleCompleted"],
};
</script>
<style lang=""></style>
