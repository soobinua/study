<!-- package.json > "build": "webpack --watch" --watch 작성으로 코드 수정할때마다 npm run build 매번 해줄 필요 없다. webpack이 저절로 빌드한다. -->
<template>
  <!--감싸주는 역할이지만 <template> 여기는 사용 불가. 상위 template 바로 밑 template은 사용 불가-->
  <div>
    <!-- v-bind:class="state" == :class="state" -->
    <div id="screen" :class="state" @click="onClickScreen">{{ message }}</div>
    <!-- v-show="result.length" 가 false면 display: none; 처리 true면 보인다. -->
    <!-- v-if 는 아예 태그가 존재하지 않는다. -->
    <template v-if="result.length"><!--감싸주는 역할인 경우 div, template 사용 가능-->
      <div>
        <!--배열 전체 값 합계 result.reduce() 이용 -->
        <!-- 계산을 이곳에서 하지 않는게 좋음 computed 속성 이용 -->
        <!-- 평균 시간 : {{ result.reduce((acc, cur) => acc + cur, 0) / result.length || 0 }} ms -->
        평균 시간 : {{ average }} ms
      </div>
      <!--v-on:click == @click-->
      <button @click="onReset">리셋</button>
    </template>
  </div>
</template>

<script>
let startTime = 0;
let endTime = 0;
let timeout = null;
export default {
  data() { //기본 데이터
    return {
      result: [],
      state: "waiting",
      message: "클릭해서 시작하세요.",
    };
  },
  computed: { //일반 데이터를 가공해서 쓸 때 사용. 캐싱이 된다.
    average() {
      return (
        this.result.reduce((acc, cur) => acc + cur, 0) / this.result.length || 0
      );
    },
  },
  methods: {
    onReset() {
      this.result = [];
    },
    onClickScreen() {
      if (this.state == "waiting") {
        this.state = "ready";
        this.message = "초록색이 되면 클릭하세요.";
        timeout = setTimeout(() => {
          this.state = "now";
          this.message = "지금 클릭!";
          startTime = new Date();
        }, Math.floor(Math.random() * 1000) + 2000); //2 ~ 3초
      } else if (this.state === "ready") {
        clearTimeout(timeout);
        this.state = "waiting";
        this.message = "너무 성급하시네요! 초록색이 된 후에 클릭하세요.";
      } else if (this.state === "now") {
        endTime = new Date();
        this.state = "waiting";
        this.message = "클릭해서 시작하세요.";
        this.result.push(endTime - startTime);
      }
    },
  },
};
</script>

<!--scoped 붙이면 이 컴포넌트 안에서만 css 유효-->
<style scoped>
#screen {
  width: 300px;
  height: 200px;
  text-align: center;
  user-select: none;
}
#screen.waiting {
  background-color: aqua;
}
#screen.ready {
  background-color: red;
  color: white;
}
#screen.now {
  background-color: greenyellow;
}
</style>
