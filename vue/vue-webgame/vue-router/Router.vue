<template>
  <div>
    <div>
      <router-link to="/game">게임 매쳐</router-link>
      <!--쿼리스트링. 주소를 통해 데이터 전달. 서버에도 전달된다.-->
      <router-link to="/game/number-baseball?page=3&offset=10&limit=1&sort=createdAt">숫자야구</router-link>
      <router-link to="/game/response-check">반응속도</router-link>
      <router-link to="/game/rock-paper-scissors">가위바위보</router-link>
      <router-link to="/game/lotto-generator">로또</router-link>
    </div>
    <router-view><!--바뀌는 부분 렌더링--></router-view>
  </div>
</template>

<script>
import router from "./routes";

export default {
  router,
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
