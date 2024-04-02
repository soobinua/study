<!-- @format -->

<template>
  <div class="card card-body">
    <h2 class="m-4">이날치 멤버</h2>
    <div class="container">
      <div class="row">
        <!-- v-for 디렉티브 이용해 반복렌더링 -->
        <div
          v-for="m in members"
          :key="m.id"
          class="col-6 col-xs-6 col-sm-4 col-md-3 col-lg-2"
        >
          <!-- 반복 렌더링 될 때는 members/1/형태의 경로로 네비게이션 링크 동적으로 생성 -->
          <!-- :to="'/members/' + m.id" -->
          <RouterLink :to="{ name: 'members/id', params: { id: m.id } }">
            <img
              class="img-thumbnail"
              style="width: 90px; height: 110px"
              :src="m.photo"
              :title="m.name"
            /><br />
            <h6 class="display-7">{{ m.name }}</h6>
          </RouterLink>
        </div>
      </div>
    </div>
    <!-- Composition API -->
    <!-- fullPath : 전체 요청 경로, 쿼리 문자까지 포함 -->
    <!-- <p>요청 경로 : {{ currentRoute.fullPath }}</p> -->
  </div>
</template>

<script>
// import { useRoute } from "vue-router";
import members from "@/members.json"; //이렇게 임포트하면 json 문자열을 js 객체로 자동 변환

export default {
  name: "Members",
  setup() {
    return { members }; //임포트된 멤버 데이터 리턴
    // const currentRoute = useRoute(); //컴포지션 API는 vue-router가 제공하는 useRoute 함수를 호출해 리턴된 currentRoute 객체 이용
    // return { currentRoute };
  },
};
</script>
