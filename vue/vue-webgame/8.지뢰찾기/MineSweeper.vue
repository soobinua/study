<template>
  <div>
    <mine-form />
    <div>timer : {{ timer }}</div>
    <table-component />
    <div>{{ result }}</div>
  </div>
</template>

<script>
import { mapState } from "vuex";
//store와 최상위 컴포넌트도 연결 필요
import store, { INCREMENT_TIMER } from "./store";
import TableComponent from "./TableComponent";
import MineForm from "./MineForm";

let interval; //나중에 메모리 누수 방지로 clear하기 위해 변수 저장
export default {
  store,
  components: {
    TableComponent,
    MineForm,
  },
  computed: {
    ...mapState(["timer", "result", "halted"]),
  },
  methods: {},
  watch: {
    halted(value, oldValue) {
      if (value === false) {
        //false 일 때 게임 시작
        interval = setInterval(() => {
          this.$store.commit(INCREMENT_TIMER); //자바스크립트 timer 정확하지 않을 수 있다. 정확하게 필요한 경우 new Date() 이용
        }, 1000);
      } else {
        //게임 중단
        clearInterval(interval);
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
