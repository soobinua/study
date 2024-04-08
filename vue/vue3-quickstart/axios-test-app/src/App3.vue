<!-- @format -->

<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from "axios";

const requestAPI = async () => {
  const url = "/api/todolist_long/gdhong";
  const response = await axios.get(url);
  console.log("응답객체 > ", response);

  //data : 수신된 응답 데이터
  //config : 요청시에 사용된 config 옵션
  //headers : 백엔드 API서버가 응답할때 사용된 응답 HTTP 헤더
  //request : 서버와의 통신에 사용된 XMLHttpRequest 객체의 정보
  //status : 서버가 응답한 HTTP 상태 코드
  //statusText : 서버의 HTTP 상태를 나타내는 문자열 정보
};

requestAPI();
</script>
