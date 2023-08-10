import Vue from "vue";
import VueRouter from "vue-router";
import NumberBaseball from "../3.숫자야구/NumberBaseball";
import ResponseCheck from "../4.반응속도체크/ResponseCheck";
import RockPaperScissors from "../5.가위바위보/RockPaperScissors";
import LottoGenerator from "../6.로또/LottoGenerator";
import GameMatcher from "./GameMatcher";

Vue.use(VueRouter);

export default new VueRouter({
  //vue-router 기본 모드 hash
  //# 붙고 새로고침해도 동작한다.
  //http://localhost:8080/Router.html#/number-baseball
  mode: "history",
  //history 모드로 바꾸면 # 없어진다.
  //새로고침하면 작동 X. 새로고침해도 작동하려면 서버 필요
  //http://localhost:8080/number-baseball
  routes: [
    //single page. 하나의 페이지에 컴포넌트들만 변경
    { path: "/number-baseball", component: NumberBaseball },
    { path: "/response-check", component: ResponseCheck },
    { path: "/rock-paper-scissors", component: RockPaperScissors },
    { path: "/lotto-generator", component: LottoGenerator },
    //동적 라우팅
    //동적 라우트 매칭
    //수많은 게임들을 하나의 주소로 묶을 수 있다.
    { path: "/game/:name", component: GameMatcher }, // ex) /game/number-baseball
  ],
});
