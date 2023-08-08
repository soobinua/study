<template>
  <td @click="onClickTd">{{ cellData }}</td>
</template>

<script>
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
      if(this.cellData) return;

      //칸에 현재 턴 값 넣기
      const rootData = this.$root.$data;
      //rootData.tableData[this.rowIndex][this.cellIndex] = this.$root.$data.turn; //반영 X
      this.$set(rootData.tableData[this.rowIndex], this.cellIndex, rootData.turn); //this.$set 사용해야 반영 O

      //3칸, 즉 한 줄 완성 체크 로직
      let win = false;
      if (rootData.tableData[this.rowIndex][0] === rootData.turn && rootData.tableData[this.rowIndex][1] === rootData.turn && rootData.tableData[this.rowIndex][2] === rootData.turn) {
        win = true;
      }
      if (rootData.tableData[0][this.cellIndex] === rootData.turn && rootData.tableData[1][this.cellIndex] === rootData.turn && rootData.tableData[2][this.cellIndex] === rootData.turn) {
        win = true;
      }
      if (rootData.tableData[0][0] === rootData.turn && rootData.tableData[1][1] === rootData.turn && rootData.tableData[2][2] === rootData.turn) {
        win = true;
      }
      if (rootData.tableData[0][2] === rootData.turn && rootData.tableData[1][1] === rootData.turn && rootData.tableData[2][0] === rootData.turn) {
        win = true;
      }

      if (win) {//이긴 경우 : 3줄 달성
        rootData.winner = rootData.turn;
        rootData.turn = "O";
        rootData.tableData = [["", "", ""], ["", "", ""], ["", "", ""]];
      } else {//무승부
        let all = true; //all이 true면 무승부라는 뜻
        rootData.tableData.forEach((row) => { //무승부 검사
          row.forEach((cell) => {
            if (!cell) {
              all = false;
            }
          });
        });
        if (all) { //무승부
          rootData.winner = rootData.turn;
          rootData.turn = "O";
          rootData.tableData = [["", "", ""], ["", "", ""], ["", "", ""]];
        } else {
          //자식 컴포넌트에서 부모 컴포넌트 조작 가능
          rootData.turn = rootData.turn === "O" ? "X" : "O";
        }
      }
    },
  },
};
</script>
