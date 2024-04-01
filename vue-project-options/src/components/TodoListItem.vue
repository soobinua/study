<!-- @format -->

<template lang="">
  <li>
    <span @click="$emit('toggleCompleted', todoItem.id)"
      >할 일 : {{ todoItem.todo }}, 아이디 : {{ todoItem.id }}
      {{ todoItem.completed ? "완료" : "" }}</span
    >
    <button @click="$emit('deleteTodo', todoItem.id)">삭제</button>
  </li>
</template>
<script>
export default {
  name: "TodoListItem",
  props: {
    todoItem: { type: Object },
  },
  emits: ["deleteTodo", "toggleCompleted"],
};
</script>
<style lang=""></style>
