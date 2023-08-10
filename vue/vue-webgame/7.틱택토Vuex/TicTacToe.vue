<template>
  <div>
    <div>{{ turn }}님의 턴입니다.</div>
    <!--자식 컴포넌트에 데이터 전달 시 아래와 같이 작성했으나 -->
    <!-- <table-component props="abc"/> -->
    <!--<table-component> 사이에 태그를 넘겨줄 수도 있다. </table-component>-->
    <table-component>
      <!--slot 자식컴포넌트에서 화면에 표시되어야할 내용을 부모에 적어줌으로써 부모 컴포넌트의 data, methods, computed 등등에 접속할 수 있는 장점이 있다.-->
      <!-- 이렇게 작성하면 자식 컴포넌트 TableComponent의 slot 태그 부분에 렌더링된다. -->
      <tr v-for="(rowData, rowIndex) in tableData" :key="rowIndex">
        <td @click="onClickTd(rowIndex, cellIndex)" v-for="(cellData, cellIndex) in rowData" :key="cellIndex">{{ cellData }}</td>
      </tr>
    </table-component>
    <div v-if="winner">{{ winner }}님의 승리!!</div>
  </div>
</template>

<script>
// :key = 렌더링할때 화면을 다시 그릴지 말지 판단하는 기준
// 배열에서 키를 인덱스로 하는 경우 추가, 수정일 때는 괜찮으나 삭제일 때는 불필요한 렌더링이 발생할 수 있다.
// :key = "index"
// [0, 1, 2, 3, 4 ,12, 7, 8, 9, 10, 13, 156]
//  0  1  2  3  4  5    6  7  8  9  10, 11,  12
// 배열의 값이 삭제되는 경우에는 인덱스가 바뀌기 때문에 다시 그려진다.
// 배열의 값이 바껴도 인덱스는 같다.

import { mapState } from "vuex";
//store와 최상위 컴포넌트도 연결 필요
import store, { CLICK_CELL, SET_WINNER, CHANGE_TURN, RESET_GAME, NO_WINNER } from "./store";
import TableComponent from "./TableComponent";

export default {
  store,
  components: {
    TableComponent,
  },
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
