import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export const START_GAME = "START_GAME";
export const OPEN_CELL = "OPEN_CELL";
export const CLICK_MINE = "CLICK_MINE";
export const FLAG_CELL = "FLAG_CELL";
export const QUESTION_CELL = "QUESTION_CELL";
export const NORMALIZE_CELL = "NORMALIZE_CELL";
export const INCREMENT_TIMER = "INCREMENT_TIMER";

export const CODE = {
  MINE: -7,
  NORMAL: -1,
  QUESTION: -2,
  FLAG: -3,
  QUESTION_MINE: -4,
  FALG_MINE: -5,
  CLICKED_MINE: -6,
  OPENED: 0, // 0 이상이면 다 opened
};

const plantMine = (row, cell, mine) => {
  const candidate = Array(row * cell).fill().map((arr, i) => {
    return i;
  });
  const shuffle = [];
  while (candidate.length > row * cell - mine) {
    const chosen = candidate.splice(Math.floor(Math.random() * candidate.length), 1)[0];
    shuffle.push(chosen);
  }
  const data = [];
  for (let i = 0; i < row; i++) {
    const rowData = [];
    data.push(rowData);
    for (let j = 0; j < cell; j++) {
      rowData.push(CODE.NORMAL); //기본적으로 칸은 빈칸
    }
  }

  for (let k = 0; k < shuffle.length; k++) {
    const ver = Math.floor(shuffle[k] / cell);
    const hor = shuffle[k] % cell;
    data[ver][hor] = CODE.MINE; //지뢰 심기
  }

  console.log(data);
  return data;
};

export default new Vuex.Store({
  //import store from './store';
  state: {
    //vue의 data와 비슷
    tableData: [],
    data: {
      row: 0,
      cell: 0,
      mine: 0,
    },
    timer: 0,
    halted: true, //중단됨
    result: "",
    openedCount: 0,
  },
  getters: {
    //vue의 computed와 비슷
  },
  mutations: {
    //state 수정할 때 사용. 동기적으로
    [START_GAME](state, { row, cell, mine }) {
      state.data = {
        // state.data.row = row; //배열 인덱스 일때처럼 객체안의 속성을 바꿀 때에도 데이터는 바뀌지만 화면은 안바뀔 수 있다.
        // Vue.set(state.data, "row", row); //Vue.set 이용
        //지금은 데이터의 속성을 바꾸는게 아니라 데이터 자체를 바꾼다.
        row,
        cell,
        mine,
      };
      state.tableData = plantMine(row, cell, mine);
      state.timer = 0;
      state.halted = false;
      state.openedCount = 0;
      state.result = "";
    },
    [OPEN_CELL](state, { row, cell }) {
      let openedCount = 0;
      const checked = []; //캐싱. memoization 메모이제이션
      function checkArround(row, cell) {
        //주변 8칸 지뢰인지 검색
        const checkRowOrCellIsUndefined = row < 0 || row >= state.tableData.length || cell < 0 || cell >= state.tableData[0].length;
        if (checkRowOrCellIsUndefined) {
          return;
        }
        if ([ CODE.OPENED, CODE.FLAG, CODE.FALG_MINE, CODE.QUESTION_MINE, CODE.QUESTION ].includes(state.tableData[row][cell])) {
          return;
        }
        //stackOverFlow 방지
        if (checked.includes(row + "/" + cell)) {
          //한번 연칸이면 종료
          return;
        } else {
          //열지 않은 칸이면 checked에 넣고 다음번에 검사하지 않기
          checked.push(row + "/" + cell);
        }
        let arround = [];
        if (state.tableData[row - 1]) {
          arround = arround.concat([
            state.tableData[row - 1][cell - 1],
            state.tableData[row - 1][cell],
            state.tableData[row - 1][cell + 1],
          ]);
        }
        arround = arround.concat([
          state.tableData[row][cell - 1],
          state.tableData[row][cell + 1],
        ]);
        if (state.tableData[row + 1]) {
          arround = arround.concat([
            state.tableData[row + 1][cell - 1],
            state.tableData[row + 1][cell],
            state.tableData[row + 1][cell + 1],
          ]);
        }
        const counted = arround.filter(function (v) {
          return [CODE.MINE, CODE.FALG_MINE, CODE.QUESTION_MINE].includes(v);
        });
        if (counted.length === 0 && row > -1) {
          //주변칸에 지뢰가 하나도 없는 경우
          const near = [];
          if (row - 1 > -1) {
            near.push([row - 1, cell - 1]);
            near.push([row - 1, cell]);
            near.push([row - 1, cell + 1]);
          }
          near.push([row, cell - 1]);
          near.push([row, cell + 1]);
          if (row + 1 < state.tableData.length) {
            near.push([row + 1, cell - 1]);
            near.push([row + 1, cell]);
            near.push([row + 1, cell + 1]);
          }
          near.forEach((n) => {
            if (state.tableData[n[0]][n[1]] !== CODE.OPENED) {
              checkArround(n[0], n[1]); //재귀
            }
          });
        }
        if (state.tableData[row][cell] === CODE.NORMAL) {
          openedCount += 1;
        }
        Vue.set(state.tableData[row], cell, counted.length);
      }
      checkArround(row, cell); //자기 자신을 부르는 재귀지만 처음에 호출해줘야 한다.
      let halted = false;
      let result = "";
      if ( state.data.row * state.data.cell - state.data.mine === state.openedCount + openedCount ) {
        halted = true;
        result = `${state.timer}초만에 승리하셨습니다.`;
      }
      state.openedCount += openedCount;
      state.halted = halted;
      state.result = result;
    },
    [CLICK_MINE](state, { row, cell }) {
      state.halted = true;
      Vue.set(state.tableData[row], cell, CODE.CLICKED_MINE);
    },
    [FLAG_CELL](state, { row, cell }) {
      if (state.tableData[row][cell] === CODE.MINE) {
        Vue.set(state.tableData[row], cell, CODE.FALG_MINE);
      } else {
        Vue.set(state.tableData[row], cell, CODE.FLAG);
      }
    },
    [QUESTION_CELL](state, { row, cell }) {
      if (state.tableData[row][cell] === CODE.FALG_MINE) {
        Vue.set(state.tableData[row], cell, CODE.QUESTION_MINE);
      } else {
        Vue.set(state.tableData[row], cell, CODE.QUESTION);
      }
    },
    [NORMALIZE_CELL](state, { row, cell }) {
      if (state.tableData[row][cell] === CODE.QUESTION_MINE) {
        Vue.set(state.tableData[row], cell, CODE.MINE);
      } else {
        Vue.set(state.tableData[row], cell, CODE.NORMAL);
      }
    },
    [INCREMENT_TIMER](state) {
      state.timer += 1;
    },
  },
});
