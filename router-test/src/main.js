/** @format */

import "./assets/main.css";
import "bootstrap/dist/css/bootstrap.css"; //bootstrap CSS 파일도 전역 스타일로 사용할 수 있게 임포트

import { createApp } from "vue";
import App from "./App.vue";

import router from "./router"; //생성한 router 객체 인스턴스 등록 //src/router/index.js와 같이 기본 파일명 index.js사용하는 경우 디렉터리명만 임포트 가능

// createApp(App).mount("#app");

//Case1. Book
// const app = createApp(App);
// app.use(router);
// app.mount("#app");

//Case2. Soo
createApp(App).use(router).mount("#app"); //Vue 애플리케이션에 router 주입하면 모든 컴포넌트 트리에서 vue-router 객체와 매칭된 라우터 정보 이용 가능
