<template>
  <div>
    <input type="number" placeholder="세로" :value="row" @change="onChangeRow"/>
    <input type="number" placeholder="가로" :value="cell" @change="onChangeCell"/>
    <input type="number" placeholder="지뢰" :value="mine" @change="onChangeMine"/>
    <button @click="onClickBtn">시작</button>
  </div>
</template>

<script>
import { START_GAME } from "./store";

export default {
  //데이터를 vuex에서 중앙 통제하고 있지만
  //컴포넌트 내부에서만 쓰는 지역 데이터는 vue 컴포넌트 데이터로 사용한다.
  data() {
    return {
      row: 10,
      cell: 10,
      mine: 20,
    };
  },
  methods: {
    onChangeRow(e) {
      this.row = e.target.value;
    },
    onChangeCell(e) {
      this.cell = e.target.value;
    },
    onChangeMine(e) {
      this.mine = e.target.value;
    },
    onClickBtn() {
      //지역적 데이터 각각 따로 두고 버튼을 눌렀을 때 데이터들을 한번에 몰아서 처리
      this.$store.commit(START_GAME, { row: this.row, cell: this.cell, mine: this.mine });
    },
  },
};
</script>
