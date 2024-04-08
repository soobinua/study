<!-- @format -->

<template>
  <div class="mt-5">
    <img :src="member.photo" clas="img" />
    <h4 class="mt-2">{{ member.name }} ({{ member.role }})</h4>
    <p>{{ member.desc }}</p>
    <a v-if="member.insta && member.insta !== ''" :href="member.insta">insta</a>
    <a v-if="member.facebook && member.facebook !== ''" :href="member.facebook"
      >facebook
    </a>
    <a v-if="member.youtube && member.youtube !== ''" :href="member.youtube"
      >youtube
    </a>
    <br /><br />
    <RouterLink :to="{ name: 'members' }">멤버 목록으로</RouterLink>

    <!-- <div>
      경로 패턴 : /members/:id <br />
      요청 경로 : {{ currentRoute.path }} <br />
      id 값 : {{ currentRoute.params.id }} <br />
    </div> -->
  </div>
</template>

<script>
import { useRoute } from "vue-router";
// import Members from "./Members.vue";
import members from "@/members.json";

export default {
  name: "memberInfo",
  props: ["id"],
  setup(props) {
    // const currentRoute = useRoute();
    // const id = parseInt(currentRoute.params.id, 10);
    // const member = members.find((m) => m.id === id);

    //라우트 정보를 속성으로 연결 props 이용하면서 의존적인 코드 필요없어짐
    const member = members.find((m) => m.id === parseInt(props.id, 10));
    return { member };

    // const currentRoute = useRoute();
    // return { currentRoute };
  },
};
</script>
