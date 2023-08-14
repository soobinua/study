<template>
  <div>
    <h1>{{ title }}</h1>
    <p>{{ name }}</p>
    <button @click="updateName">Change Name</button>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String, //타입 지정
      // required: true, //필수값인 경우 부모에서 자식으로 데이터 보내줘야 한다.
      default: "default title", //기본값
    },
    name: {
      type: String,
      default: "default name",
    },
  },
  data() {
    return {
      // name: "SooBin",
    };
  },
  methods: {
    updateName() {
      //부모에서 받은 props 자식에서 바꾸는 것 좋지 않다.
      //바꿔야한다면 부모에게 event를 보내서 바꿔달라 요청 후 부모가 바꿔주는 형식이 좋다.
      // this.name = "SooBin Updated";
    },
  },
};
</script>

<style scoped></style>
