<template>
  <div>
    <div>{{ turn }}님의 턴입니다.</div>
    <table-component :table-data="tableData" />
    <div v-if="winner">{{ winner }}님의 승리!!</div>
  </div>
</template>

<script>
// import Vue from "vue"; //해결방법 1
import TableComponent from "./TableComponent";

export default {
  components: {
    TableComponent,
  },
  data() {
    return {
      tableData: [
        ["", "", ""], 
        ["", "", ""], 
        ["", "", ""],
      ],
      turn: "O",
      winner: "",
    };
  },
  methods: {
    onChangeData() {
      // this.turn = 'X'; //반영된다.
      //객체나 배열을 인덱스를 사용해 데이터를 바꾸면 화면에 반영되지 않는다.
      //this.tableData.push('a') 배열의 메소드를 이용하는 것이 화면에 반영된다.
      // this.tableData[0][1] = "O"; //화면 바뀌지 않는다.
      // Vue.set(this.tableData[1], 0, "X"); //해결방법 1
      this.$set(this.tableData[1], 0, "X"); //Vue.set과 동일. import Vue 할 필요 없음. 해결방법 2
    },
  },
};
</script>

<style>
table {
  border-collapse: collapse;
}
td {
  border: 1px solid black;
  width: 40px;
  height: 40px;
  text-align: center;
}
</style>
