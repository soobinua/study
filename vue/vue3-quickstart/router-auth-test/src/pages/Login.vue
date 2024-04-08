<!-- @format -->

<template>
  <div>
    <h2>로그인</h2>
    사용자 : <input type="text" v-model="info.userid" /><br />
    암호 : <input type="password" v-model="info.password" /><br />
    <br />
    <button @click="login">로그인</button>
  </div>
</template>

<script>
import { reactive } from "vue";
import { useRoute, useRouter } from "vue-router";
import { loginProcess } from "@/utils/AuthUtil";

export default {
  name: "Login",
  setup() {
    //setup()내에서 this에 접근할 수 없기 때문에 this.$router, this.$route 접근 불가하기 때문에
    //useRouter, useRoute 컴포저블을 사용. 컴포저블은 Vue 컴포지션 API를 활용해 상태 저장 로직을 캡슐화하고 재사용하는 함수
    const router = useRouter(); //this.$router // vue-router 인스턴스
    const currentRoute = useRoute(); //this.$route // 현재 라우터의 상태를 관리하는 객체

    const fromname = currentRoute.query.fromname; //currentRoute 객체에서 fromname 쿼리 문자열 정보 읽어낸다

    const info = reactive({ userid: "", password: "" });

    const successCallback = () => {
      //쿼리 문자열 정보는 로그인 화면으로 이동하기 전에 접근하려 했던 경로로 존재한다면 로그인 후 fromname 라우트 이름을 이용해 자동으로 이동시킨다
      if (fromname) router.push({ path: fromname });
      else router.push({ name: "home" });
    };

    const failCallback = () => {
      alert("로그인 실패");
    };

    const login = () => {
      loginProcess(info.userid, info.password, successCallback, failCallback);
    };

    return { info, login };
  },
};
</script>
<style></style>
