<!-- @format -->

<script>
import Header from "@/components/Header.vue";
import Loading from "@/components/Loading.vue";
import { provide } from "vue";

export default {
  name: "App",
  //Loading 컴포넌트 임포트
  components: { Header, Loading },
  setup() {
    //provide 함수를 임포트하고 //첫번째 인자 : 주입키, 두번째 인자 : 제공되는 값
    provide("videos", [
      //videos라는 이름으로 영상 목록 정보 제공하면 자식 컴포넌트에서 inject로 읽기 전용으로 이용
      { id: "t0BHhqw_Ecc", title: "범 내려온다", category: "official" },
      { id: "FrCkLMxnlMI", title: "좌우나졸", category: "official" },
      {
        id: "7O0hIrgMcCg",
        title: "별주부가 울며 여짜오되",
        category: "official",
      },
      { id: "MJD_fAdqNQc", title: "어류도감", category: "official" },
      { id: "SmTRaSg2fTQ", title: "범 내려온다", category: "온스테이지2.0" },
      { id: "B_X7n0AaLqA", title: "범 내려온다(서울)", category: "관광공사" },
      { id: "sV1jq6RFSXc", title: "어류도감(부산)", category: "관광공사" },
      { id: "dInPs_VHqSM", title: "좌우나졸(전주)", category: "관광공사" },
    ]);
  },
};
</script>

<template>
  <div class="container">
    <Header></Header>
    <router-view v-slot="{ Component }">
      <Suspense timeout="0">
        <Component :is="Component"></Component>
        <!-- Suspense fallback 템플릿에서 Loading 컴포넌트 지정 -->
        <template #fallback>
          <!-- 컴포넌트를 비동기로 로딩하는 도중에는 스피커 UI 나타남 -->
          <Loading />
        </template>
      </Suspense>
    </router-view>
    <!-- router-view 객체 routes 배열 경로 비교해 컴포넌트 마운트 -->
    <!-- router-view에 마운트했기 때문에 화면이 완전히 전환 -->
  </div>
</template>

<style scoped>
.container {
  text-align: center;
  margin-top: 10px;
}
</style>
