<template>
  <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>
import EventBus from "./EventBus";

export default {
  props: {
    cellData: String,
    rowIndex: Number,
    cellIndex: Number,
  },
  methods: {
    onClickTd() {
      //가장 최상위 컴포넌트 접근 가능
      //console.log(this.$root.$data);
      //부모 컴포넌트 접근 가능
      //console.log(this.$parent.$data);

      //규모가 커지면 this.$root, this.$parent 대신 중앙 데이터 통제실 Vuex 사용
      //const rootData = this.$parent.$parent.$data;
      //컴포넌트가 많아지면 parent 누군지 알아볼수 없음

      //부모 데이터는 바뀌는데 화면에 그려지지 않음
      //객체나 배열을 인덱스를 사용해 데이터를 바꾸면 화면에 반영되지 않는다.
      //인덱스 사용하는 경우 Vue.set 사용해야 반영된다.

      //남의 칸 누른 경우
      if (this.cellData) return;

      //rootComponent에서 데이터 조작 처리
      EventBus.$emit("clickTd", this.rowIndex, this.cellIndex); //하위 컴포넌트에서는 이것만 작성하면 끝
      //$emit은 $on 과 대응
      //$emit("clickTd") 하면 TicTacToe의 $on("clickTd") 실행
      //그러면 $on("clickTd", this.onClickTd); 핸들러 this.onClickTd 실행된다.
    },
  },
};
</script>
