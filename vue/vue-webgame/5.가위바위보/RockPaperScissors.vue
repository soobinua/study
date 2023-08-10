<template>
  <div>
    <div id="computer" :style="computedStyleObject"></div>
    <div>
      <button @click="onClickButton('가위')">가위</button>
      <button @click="onClickButton('바위')">바위</button>
      <button @click="onClickButton('보')">보</button>
    </div>
    <div>{{ result }}</div>
    <div>현재 {{ score }}점</div>
    <!-- 
      Lifecycle
      created : v-if="true"되어서 없다가 컴포넌트가 생기는 순간
      mounted : 화면에 그릴 때 실행
      updated : 화면의 데이터가 변경되어 다시 화면이 바뀔 때
      destroyed : v-if="false"가 되면 화면에서 사라질 때
    -->
    <!-- <lifecycle-example v-if="false" /> -->
  </div>
</template>

<script>
const rpsCoords = {
  가위: "-142px",
  바위: "0",
  보: "-290px",
};

const scores = {
  가위: 1,
  바위: 0,
  보: -1,
};

const computerChoice = (imgCoord) => {
  return Object.entries(rpsCoords).find(function (v) {
    return v[1] === imgCoord;
  })[0];
};

let interval = null; //변수에 저장해야 나중에 clearInterval 할 수 있다.
export default {
  data() {
    return {
      imgCoord: rpsCoords.바위,
      result: "",
      score: 0,
    };
  },
  computed: {
    computedStyleObject() {
      return {
        //이미지 스트라이프
        background: `url(https://en.pimg.jp/023/182/267/1/23182267.jpg) ${this.imgCoord} 0`,
      };
    },
  },
  methods: {
    changeHand() {
      interval = setInterval(() => {
        if (this.imgCoord === rpsCoords.바위) {
          this.imgCoord = rpsCoords.가위;
        } else if (this.imgCoord === rpsCoords.가위) {
          this.imgCoord = rpsCoords.보;
        } else if (this.imgCoord === rpsCoords.보) {
          this.imgCoord = rpsCoords.바위;
        }
      }, 100);
    },
    onClickButton(choice) {
      clearInterval(interval);
      const myScore = scores[choice];
      const cpuScore = scores[computerChoice(this.imgCoord)];
      const diff = myScore - cpuScore;
      if (diff === 0) {
        this.result = "비겼습니다.";
      } else if ([-1, 2].includes(diff)) {
        this.result = "이겼습니다.";
        this.score += 1;
      } else {
        this.result = "졌습니다.";
        this.score -= 1;
      }
      setTimeout(() => {
        this.changeHand();
      }, 1000);
    },
  },
  beforeCreate() {
    console.log("beforeCreated");
  },
  created() {
    //컴포넌트가 보여지긴 하지만 화면에 나타나기 전
    console.log("created");
  },
  beforeMount() {
    console.log("beforeMount");
  },
  mounted() {
    //컴포넌트가 화면에 나타난 후
    //주로 mounted에서 화면 조작
    console.log("mounted");
    this.changeHand();
  },
  beforeUpdate() {
    console.log("beforeUpdate");
  },
  updated() {
    //화면의 데이터가 변경되어 화면이 다시 그려질 때
    console.log("updated");
  },
  beforeDestroy() {
    console.log("beforeDestroy");
    clearInterval(interval); //메모리 누수 방지
  },
  destroyed() {
    //화면에서 사라질 때
    console.log("destroyed");
  },
};
</script>

<style scoped>
#computer {
  width: 142px;
  height: 200px;
  background-position: 0 0;
}
</style>
