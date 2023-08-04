<template>
  <!--최상단 부모 태그 하나로 묶어줘야한다.-->
  <div>
    <h1>{{ result }}</h1>
    <!-- <form v-on:submit="onSubmitForm"> -->
    <!--v-on == @으로 가능-->
    <!--@submit.prevent : e.preventDefault() 자동 적용-->
    <form @submit.prevent="onSubmitForm">
      <input ref="answer" minlength="4" maxlength="4" v-model="value" />
      <button type="submit">입력</button>
    </form>
    <div>시도 : {{ tries.length }}</div>
    <ul>
      <!--v-for:"try in tries" try 사용불가로 t-->
      <!--값-->
      <!-- <li v-for="t in tries">{{ t }}</li> -->
      <li v-for="t in tries" :key="t.try">
        <!--객체-->
        <div>{{ t.try }}</div>
        <div>{{ t.result }}</div>
      </li>
    </ul>
  </div>
</template>

<script>
//랜덤하게 4개의 숫자 뽑기
const getNumbers = () => {
  const candidates = [1, 2, 3, 4, 5, 6, 7, 8, 9];
  const array = [];
  for (let i = 0; i < 4; i += 1) {
    const chosen = candidates.splice(Math.floor(Math.random() * (9 - i)), 1)[0];
    array.push(chosen);
  }
  return array;
};
export default { //작성했기 때문에 main.js에서 import 가능
  data() {
    return {
      answer: getNumbers(), //ex) [1, 5, 3, 4]
      tries: [], //시도 수
      value: "", //입력
      result: "", //결과
    };
  },
  methods: {
    onSubmitForm(e) {
      //e.preventDefault();
      if (this.value === this.answer.join("")) {
        //정답 맞춘 경우
        //this.tries.push(this.value); //입력할때마다 tries에 값 저장
        this.tries.push({
          //객체 저장
          try: this.value,
          result: "홈런",
        });
        this.result = "홈런";
        alert("홈런! 게임을 다시 시작합니다.");
        this.value = "";
        this.answer = getNumbers();
        this.tries = [];
        this.$refs.answer.focus();
      } else {
        //정답 틀렸을 때
        if (this.tries.length >= 9) {
          //10번째 시도
          this.result = `10번 넘게 틀려서 실패! 답은 ${this.answer.join(
            ","
          )} 입니다.`;
          alert("게임을 다시 시작합니다.");
          this.value = "";
          this.answer = getNumbers();
          this.tries = [];
          this.$refs.answer.focus();
        }
        let strike = 0;
        let ball = 0;
        //문자열을 숫자 배열로 바꿔주기
        const answerArray = this.value.split("").map((v) => parseInt(v));
        for (let i = 0; i < 4; i += 1) {
          //숫자 자릿수 모두 정답
          if (answerArray[i] === this.answer[i]) {
            strike++;
          } else if (this.answer.includes(answerArray[i])) {
            //숫자만 정답
            ball++;
          }
        }
        this.tries.push({
          try: this.value,
          result: `${strike} 스트라이크, ${ball} 볼`,
        });
        this.value = "";
        this.$refs.answer.focus();
      }
    },
  },
};
</script>

<style></style>
