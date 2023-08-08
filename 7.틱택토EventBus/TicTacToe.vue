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
//기존코드에 EventBus 사용
import EventBus from "./EventBus";

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
    onClickTd(rowIndex, cellIndex) {
      //TdComponent 에 있던 이벤트 rootComponent로 이동
      //가장 최상위에서 하기 때문에 this.$root.$data 할 필요 없이 this.tableData로 가능
      //rowIndex, cellIndex 매개변수로 받기 때문에 this.rowIndex, this.cellIndex 필요없음

      //칸에 현재 턴 값 넣기
      //this.tableData[this.rowIndex][this.cellIndex] = this.$root.$data.turn; //반영 X
      this.$set(this.tableData[rowIndex], cellIndex, this.turn); //this.$set 사용해야 반영 O

      //3칸, 즉 한 줄 완성 체크 로직
      let win = false;
      if (this.tableData[rowIndex][0] === this.turn && this.tableData[rowIndex][1] === this.turn && this.tableData[rowIndex][2] === this.turn) {
        win = true;
      }
      if (this.tableData[0][cellIndex] === this.turn && this.tableData[1][cellIndex] === this.turn && this.tableData[2][cellIndex] === this.turn) {
        win = true;
      }
      if (this.tableData[0][0] === this.turn && this.tableData[1][1] === this.turn && this.tableData[2][2] === this.turn) {
        win = true;
      }
      if (this.tableData[0][2] === this.turn && this.tableData[1][1] === this.turn && this.tableData[2][0] === this.turn) {
        win = true;
      }

      if (win) {//이긴 경우 : 3줄 달성
        this.winner = this.turn;
        this.turn = "O";
        this.tableData = [["", "", ""], ["", "", ""], ["", "", ""]];
      } else {//무승부
        let all = true; //all이 true면 무승부라는 뜻
        this.tableData.forEach((row) => { //무승부 검사
          row.forEach((cell) => {
            if (!cell) {
              all = false;
            }
          });
        });
        if (all) { //무승부
          this.winner = this.turn;
          this.turn = "O";
          this.tableData = [["", "", ""], ["", "", ""], ["", "", ""]];
        } else {
          //자식 컴포넌트에서 부모 컴포넌트 조작 가능
          this.turn = this.turn === "O" ? "X" : "O";
        }
      }
    },
  },
  created() {
    //EventBus 등록
    //커스텀 이벤트, 사용자 정의 이벤트 등록
    //이곳에 이벤트 등록에 이벤트 한 곳에서 처리
    //중앙통제로 간단해졌다는 장점과 동시에 중앙코드가 너무 늘어날 수 있다는 단점 존재
    EventBus.$on("clickTd", this.onClickTd);
  }
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
