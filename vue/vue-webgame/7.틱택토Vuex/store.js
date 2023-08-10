import Vue from "vue";
import Vuex from "vuex";

//vue와 vuex 연결. Vuex.Store 하기 전에 반드시 연결 필요
Vue.use(Vuex); //this.$store 생긴 것

//Object Dynamic Property 동적 속성
//mutations 이름 변수로 뺄 수 있다.
export const SET_WINNER = "SET_WINNER"; //import { CLICK_CELL , SET_WINNER, RESET_GAME, CHANGE_TURN} from './store';
export const CLICK_CELL = "CLICK_CELL";
export const CHANGE_TURN = "CHANGE_TURN";
export const RESET_GAME = "RESET_GAME";
export const NO_WINNER = "NO_WINNER";
//export 붙여 모듈로 만들어 다른 파일에서 쓸 수 있다.

export default new Vuex.Store({
  //import store from './store';
  state: { //vue의 data와 비슷
    tableData: [
      ["", "", ""],
      ["", "", ""],
      ["", "", ""],
    ],
    turn: "O",
    winner: "",
  },
  getters: { //vue의 computed와 비슷
    //기존의 state에 추가적 작업할 때 사용. 캐싱이 된다.
    turnMessage(state) {
      return state.turn + "님이 승리하셨습니다.";
    },
  },
  mutations: { //state 수정할 때 사용. 동기적으로
    //mutations는 대문자로 작성
    //Object Dynamic Property 동적 속성
    //SET_WINNER(state, winner) {
    [SET_WINNER](state, winner) {
      //mutations 이름 변수로 뺄 수 있다.
      state.winner = winner;
    },
    [CLICK_CELL](state, { row, cell }) {
      //객체나 배열을 인덱스를 사용해 데이터를 바꾸면 화면에 반영되지 않는다.
      //인덱스 사용하는 경우 Vue.set 사용해야 반영된다.
      //vuex는 this.$set 없으므로 Vue.set 사용
      Vue.set(state.tableData[row], cell, state.turn);
    },
    [CHANGE_TURN](state) {
      state.turn = state.turn === "O" ? "X" : "O";
      state.winner = "";
    },
    [RESET_GAME](state) {
      state.turn = "O";
      state.tableData = [
        ["", "", ""],
        ["", "", ""],
        ["", "", ""],
      ];
    },
    NO_WINNER(state) {
      state.winner = "";
    },
  },
  actions: { //비동기를 사용할 때, 또는 여러 mutations을 연달아 실행할 때
  },
});
