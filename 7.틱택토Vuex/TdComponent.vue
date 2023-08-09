<template>
  <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>
import { mapState } from "vuex";

export default {
  props: {
    rowIndex: Number,
    cellIndex: Number,
  },
  computed: {
    ...mapState({
      //mapState를 이용해 vuex의 state를 간단하게 가져올 수 있다.
      tableData: (state) => state.tableData,
      turn: (state) => state.turn,
      cellData(state) {
        return state.tableData[this.rowIndex][this.cellIndex];
      },
    }),
    // cellData() {
    //   //부모 컴포넌트에서 물려받지 말고 바로 접근
    //   return this.$store.state.tableData[this.rowIndex][this.cellIndex];
    // },
    // //vuex의 state 사용 가능
    // tableData() {
    //   return this.$store.state.tableData;
    // },
    // turn() {
    //   return this.$store.state.turn;
    // },
  },
  methods: {},
};
</script>
