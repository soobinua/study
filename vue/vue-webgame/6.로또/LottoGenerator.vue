<template>
  <div>
    <div>당첨 숫자</div>
    <div id="결과창">
      <!-- number 가 LottoGenerator에서 LottoBall로 전달된다.-->
      <lotto-ball
        v-for="ball in winBalls"
        :key="ball"
        :number="ball"
      ></lotto-ball>
    </div>
    <div>보너스</div>
    <lotto-ball v-if="bonus" :number="bonus"></lotto-ball>
    <button v-if="redo" @click="onClickRedo">한 번 더!</button>
  </div>
</template>

<script>
import LottoBall from "./LottoBall";

function getWinNumbers() {
  const candidate = Array(45).fill().map((v, i) => i + 1);
  const shuffle = [];
  //shuffle 정렬 한 다음에 랜덤으로 숫자 7개 뽑기
  while (candidate.length > 0) {
    shuffle.push(candidate.splice(Math.floor(Math.random() * candidate.length), 1)[0]);
  }
  const bonusNumber = shuffle[shuffle.length - 1];
  const winNumbers = shuffle.slice(0, 6).sort((p, c) => p - c);
  return [...winNumbers, bonusNumber];
}

const timeouts = [];
export default {
  components: {
    //lotto-ball 컴퐄넌트 사용하기 위해 미리 등록해야 한다.
    LottoBall, //파스칼케이스 알아서 카멜케이스로 만들어준다.
    //== "lotto-ball": LottoBall,
  },
  data() {
    return {
      //시각적 효과를 위해 winNumbers와 winBalls
      winNumbers: getWinNumbers(), //처음에 숫자 7개 한 번에 뽑고
      winBalls: [], //winNumbers 공을 하나씩 넣을 것
      bonus: null,
      redo: false,
    };
  },
  methods: {
    onClickRedo() {
      this.winNumbers = getWinNumbers();
      this.winBalls = [];
      this.bonus = null;
      this.redo = false;
      this.showBalls();
    },
    showBalls() {
      for (let i = 0; i < this.winNumbers.length - 1; i++) {
        timeouts[i] = setTimeout(() => {
          //1초마다 winNumbers의 공 winBalls로 넣기
          this.winBalls.push(this.winNumbers[i]);
        }, (i + 1) * 1000);
      }
      timeouts[6] = setTimeout(() => {
        this.bonus = this.winNumbers[6];
        this.redo = true;
      }, 7000);
    },
  },

  mounted() {
    //mounted에서 setTimeout, setInterval하면
    this.showBalls();
  },

  beforeDestroy() {
    //mounted에서 setTimeout, setInterval한 것 clearTimeout, clearInterval 해주기
    timeouts.forEach((t) => {
      clearTimeout(t);
    });
  },
};
</script>

<style scoped></style>
