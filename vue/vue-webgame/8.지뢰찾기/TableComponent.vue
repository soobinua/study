<template>
  <table>
    <tr v-for="(rowData, rowIndex) in tableData" :key="rowIndex">
      <td
        v-for="(cellData, cellIndex) in rowData"
        :key="cellIndex"
        :style="cellDataStyle(rowIndex, cellIndex)"
        @click="onClickTd(rowIndex, cellIndex)"
        @contextmenu.prevent="onRightClickTd(rowIndex, cellIndex)"
      >
        {{ cellDataText(rowIndex, cellIndex) }}
      </td>
    </tr>
  </table>
</template>

<script>
import { mapState } from "vuex";
import { CODE, OPEN_CELL, FLAG_CELL, QUESTION_CELL, NORMALIZE_CELL, CLICK_MINE } from "./store";

export default {
  computed: {
    ...mapState(["tableData", "halted"]),
    //고차함수 : 기존 함수를 확장, 기능 추가
    //고차함수 주의사항 : 화살표 함수(=>)는 this 사용 불가
    //this를 쓸 때 computed의 함수는 일반 함수로 쓰고 내부는 화살표 함수로 작성해야 this 정상 작동
    cellDataStyle(state) {
      //일반 함수
      return (row, cell) => {
        //화살표 함수
        switch (this.$store.state.tableData[row][cell]) {
          case CODE.NORMAL:
          case CODE.MINE:
            return {
              background: "#4444",
            };
          case CODE.CLICKED_MINE:
          case CODE.OPENED:
            return {
              background: "white",
            };
          case CODE.FLAG:
          case CODE.FALG_MINE:
            return {
              background: "red",
            };
          case CODE.QUESTION:
          case CODE.QUESTION_MINE:
            return {
              background: "yellow",
            };
          default:
            return {};
        }
      };
    },
    cellDataText() {
      return (row, cell) => {
        switch (this.$store.state.tableData[row][cell]) {
          case CODE.MINE:
            return "X";
          case CODE.NORMAL:
            return "";
          case CODE.FALG_MINE:
          case CODE.FLAG:
            return "!";
          case CODE.QUESTION_MINE:
          case CODE.QUESTION:
            return "?";
          case CODE.CLICKED_MINE:
            return "펑";
          default:
            return this.$store.state.tableData[row][cell] || "";
        }
      };
    },
  },
  methods: {
    onClickTd(row, cell) {
      if (this.halted) {
        //게임 중단된 경우
        return;
      }
      switch (this.tableData[row][cell]) {
        case CODE.NORMAL:
          return this.$store.commit(OPEN_CELL, { row, cell });
        case CODE.MINE:
          return this.$store.commit(CLICK_MINE, { row, cell });
        default:
          return;
      }
    },
    onRightClickTd(row, cell) {
      if (this.halted) {
        return;
      }
      switch (this.tableData[row][cell]) {
        case CODE.NORMAL:
        case CODE.MINE:
          this.$store.commit(FLAG_CELL, { row, cell });
          return;
        case CODE.FALG_MINE:
        case CODE.FLAG:
          this.$store.commit(QUESTION_CELL, { row, cell });
          return;
        case CODE.QUESTION_MINE:
        case CODE.QUESTION:
          this.$store.commit(NORMALIZE_CELL, { row, cell });
          return;
      }
    },
  },
};
</script>
