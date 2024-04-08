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
import { ref } from "vue";
export default {
  name: "InputTodo",
  setup(props, context) {
    const todo = ref(""); //반응성 데이터 ref이용
    const addTodo = () => {
      if (todo.value.length >= 1) {
        context.emit("addTodo", todo.value); //composition api에서는 this를 사용하지 않고 setup() 두번째 인자 context 이용
        todo.value = "";
      } else {
        alert("할 일을 입력해주세요");
      }
    };
    return { todo, addTodo };
  },
  //setup()
  // data() {
  //   return { todo: "" };
  // },
  // emits: ["addTodo"],
  // methods: {
  //   addTodo() {
  //     if (this.todo.length >= 1) {
  //       this.$emit("addTodo", this.todo);
  //       this.todo = "";
  //     } else {
  //       alert("할 일을 입력해주세요");
  //     }
  //   },
  // },
};
</script>
<style lang=""></style>
