<!-- @format -->
<template>
  <div class="card card-body">
    <h2>About {{ user.name }}</h2>
    <p>Tel : {{ user.tel }}</p>
    <p>Address : {{ user.address }}</p>
    <!-- Option API -->
    <!-- fullPath : 전체 요청 경로, 쿼리 문자까지 포함 -->
    <!-- <p>요청 경로 : {{ $route.fullPath }}</p> -->
  </div>
</template>

<script>
import { reactive } from "vue";
export default {
  name: "About",
  //비동기 처리를 수행할 수 있도록
  async setup() {
    const user = reactive({ no: 0, name: "", tel: "", address: "" });
    const url = "https://contactsvc.bmaster.kro.kr/contacts_long?pageno=1";
    const response = await fetch(url);
    const contactList = await response.json();
    user.no = contactList.contacts[0].no;
    user.name = contactList.contacts[0].name;
    user.tel = contactList.contacts[0].tel;
    user.address = contactList.contacts[0].address;

    return { user };
  },
  // created() {
  //   console.log(this.$route); //옵션 API는 this이용해 즉시 사용
  // },
};
</script>
