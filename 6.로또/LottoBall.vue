<template>
  <div class="ball" :style="styleObject">{{ number }}</div>
</template>

<script>
export default {
  name: "LottoBall",
  //부모 LottoGenerator에서 전달받은 number
  //props의 값을 바꾸고 싶다면 데이터를 바꾸는 부모의 메소드를 자식에게 props로 전달
  //props로 받은 값은 바꿀 수 없다. 읽기 전용 (readonly)
  // == props: ["number"] 아래와 동일
  props: {
    number: Number,
  },
  //기존값으로 새로운 값 도출할 때 주로 computed 사용
  computed: {
    styleObject() {
      let background;
      if (this.number <= 10) {
        background = "red";
      } else if (this.number <= 20) {
        background = "orange";
      } else if (this.number <= 30) {
        background = "yellow";
      } else if (this.number <= 40) {
        background = "green";
      } else {
        background = "blue";
      }
      return {
        background,
      };
    },
  },
};
</script>

<style>
.ball {
  display: inline-block;
  border: 1px solid black;
  border-radius: 20px;
  width: 40px;
  height: 40px;
  line-height: 40px;
  font-size: 20px;
  text-align: center;
  margin-right: 20px;
}
</style>
