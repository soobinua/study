<!-- @format -->

<template lang="">
  <div>
    <div>
      <input
        v-model.trim="todo"
        placeholder="할 일 입력"
        @keyup.enter="addTodo"
      />
      <button @click="addTodo">추가</button>
    </div>
  </div>
</template>
<script>
export default {
  name: "InputTodo",
  data() {
    return { todo: "" };
  },
  emits: ["addTodo"],
  methods: {
    addTodo() {
      if (this.todo.length >= 1) {
        this.$emit("addTodo", this.todo);
        this.todo = "";
      } else {
        alert("할 일을 입력해주세요");
      }
    },
  },
};
</script>
<style lang=""></style>
