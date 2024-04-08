/** @format */

import { createRouter, createWebHistory } from "vue-router";
import { isMatchToRoles } from "@/utils/AuthUtil";
import Home from "@/pages/Home.vue";
import Login from "@/pages/Login.vue";
import Users from "@/pages/Users.vue";
import Admins from "@/pages/Admins.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", name: "home", component: Home },
    { path: "/login", name: "login", component: Login },
    { path: "/users", name: "users", component: Users },
    { path: "/admins", name: "admins", component: Admins },
  ],
});

//라우터 객체의 전역 수준인 내비게이션 가드 beforeEach()에서 네비게이션 시작 시점에 isMatchToRoles 함수 호출해 요청 경로에 사용자 접근할 수 있는지 검증
router.beforeEach((to) => {
  //false면 로그인 화면으로 이동핟도록 객체 생성해 리턴
  if (!isMatchToRoles(to.path)) {
    //로그인 후 다시 이 경로로 돌아올 수 있도록 요청 경로 라우트 이름을 쿼리 문자열에 담아 전달
    return { name: "login", query: { fromname: to.name } };
  }
});

export default router;
