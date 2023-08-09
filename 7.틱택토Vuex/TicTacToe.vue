<template>
  <div>
    <div>{{ turn }}님의 턴입니다.</div>
    <!-- vuex의 computed 매번 실행되므로 컴포넌트 나눈 의미가 없어져 하나로 합치기 -->
    <!-- vuex를 사용하지 않으면 나눈 의미가 있지만 vuex 나눈 의미가 없음 -->
    <!-- TableComponent, TrComponent, TdComponent 필요 없음 -->
    <table>
      <tr v-for="(rowData, rowIndex) in tableData" :key="rowIndex">
        <td @click="onClickTd(rowIndex, cellIndex)" v-for="(cellData, cellIndex) in rowData" :key="cellIndex">{{ cellData }}</td>
      </tr>
    </table>
    <div v-if="winner">{{ winner }}님의 승리!!</div>
  </div>
</template>

<script>
import { mapState } from "vuex";
//store와 최상위 컴포넌트도 연결 필요
import store, { CLICK_CELL, SET_WINNER, CHANGE_TURN, RESET_GAME, NO_WINNER } from "./store";

export default {
  store,
  computed: {
    //mapState를 이용해 vuex의 state를 간단하게 가져올 수 있다.
    ...mapState(["winner", "turn", "tableData"]), //아래와 동일
    // winner() {
    //   return this.$store.state.winner;
    // },
    // turn() {
    //   return this.$store.state.turn;
    // }
  },
  methods: {
    onClickTd(rowIndex, cellIndex) {
      //남의 칸 누른 경우
      if (this.cellData) return;

      //vuex 이용
      //mutations 부를때 commit 이용
      this.$store.commit(CLICK_CELL, {
        row: rowIndex,
        cell: cellIndex,
      });

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

      if (win) { //이긴 경우 : 3줄 달성
        this.$store.commit(SET_WINNER, this.turn);
        this.$store.commit(RESET_GAME);
      } else { //무승부
        let all = true; //all이 true면 무승부라는 뜻
        this.tableData.forEach((row) => { //무승부 검사
          row.forEach((cell) => {
            if (!cell) {
              all = false;
            }
          });
        });
        if (all) { //무승부
          this.$store.commit(NO_WINNER);
          this.$store.commit(RESET_GAME);
        } else {
          this.$store.commit(CHANGE_TURN);
        }
      }
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
