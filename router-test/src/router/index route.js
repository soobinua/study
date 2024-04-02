/** @format */

import {
  createRouter,
  createWebHistory,
  isNavigationFailure,
} from "vue-router";

import Home from "@/pages/Home.vue";
import About from "@/pages/About.vue";
import Members from "@/pages/Members.vue";
import Videos from "@/pages/Videos.vue";
import MemberInfo from "@/pages/MemberInfo.vue";
import VideoPlayer from "@/pages/VideoPlayer.vue";
import NotFound from "@/pages/NotFound.vue";

// 이전 요청 라우트를 확인해 라우트명이 members || member/id가 아니면 false 리턴해 내비게이션 강제로 중단
const membersIdGuard = (to, from) => {
  // members/:id 경로는 반드시 이전 경로가
  // /members, /members:id 인 경우만 내비게이션 허용
  if (from.name !== "members" && from.name !== "members/id") {
    return false;
  }
};

//vue-router 객체 createRouter함수 이용해 생성
const router = createRouter({
  history: createWebHistory(), //라우팅 모드 지정 Web의 History API이용
  routes: [
    //routes 속성으로 라우트 경로마다 보여줄 컴포넌트 배열로 지정
    { path: "/", name: "home", component: Home },
    //명명된 라우트 : 라우트 정보에 이름 부여
    { path: "/about", name: "about", component: About },
    { path: "/members", name: "members", component: Members },
    //동적 라우트 : 일정한 패턴의 URL경로를 하나의 라우트에 연결
    {
      path: "/members/:id",
      name: "members/id",
      component: MemberInfo,
      beforeEnter: membersIdGuard,
    },
    //중첩 라우트
    {
      path: "/videos",
      name: "videos",
      component: Videos,
      children: [{ path: ":id", name: "videos/id", component: VideoPlayer }],
    },
    // paths(.*)* 매칭패턴 :paths는 동적 파라미터 이름 () 속의 .*는 임의의 문자(.)가 0번 또는 여러번 반복되는 패턴 의미
    // paths(.*) 는 /abc || /123같은 경로 의미
    // 마지막 *은 다시 /:paths(.*) 패턴이 다시 0번 이상 여러번 반복하는 패턴 의미
    { path: "/:paths(.*)*", name: "NotFound", component: NotFound },
  ],
});

//이동하려는 쿼리 문자열 확인 후 존재하는 값 있다면 쿼리 문자열을 제거한 새로운 경로 리턴
router.beforeEach((to) => {
  //to.query에 속성이 존재할 경우 제거된 경로로 재이동
  if (to.query && Object.keys(to.query).length > 0) {
    return { path: to.path, query: {}, params: to.params };
  }
});

//내비게이션 실패 여부를 확인해 오류 메시지 콘솔에 출력
router.afterEach((to, from, failure) => {
  if (isNavigationFailure(failure)) {
    console.log("내비게이션 중단: ", failure);
  }
});
export default router; //생성한 vue-router 객체 export //해당 객체는 main.js에서 임포트해 애플리케이션에 등록
