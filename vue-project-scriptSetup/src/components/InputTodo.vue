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
<script setup>
import { ref } from "vue";

const emit = defineEmits(["addTodo"]); //defineEmits 함수를 이용해 이벤트를 정의하고 emit() 함수 리턴받음
const todo = ref("");
const addTodo = () => {
  if (todo.value.length >= 1) {
    emit("addTodo", todo.value); //emit()함수 이용해 이벤트 발신
    // context.emit("addTodo", todo.value);
    todo.value = "";
  } else {
    alert("할 일을 입력해주세요");
  }
};

//script setup
// export default {
//   name: "InputTodo",
//   setup(props, context) {
//     const todo = ref(""); //반응성 데이터 ref이용
//     const addTodo = () => {
//       if (todo.value.length >= 1) {
//         context.emit("addTodo", todo.value); //composition api에서는 this를 사용하지 않고 setup() 두번째 인자 context 이용
//         todo.value = "";
//       } else {
//         alert("할 일을 입력해주세요");
//       }
//     };
//     return { todo, addTodo };
//   },
// };
</script>
<style lang=""></style>
