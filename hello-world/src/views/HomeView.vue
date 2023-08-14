<!--싱글 파일 컴포넌트 (Single File Component) 하나의 파일에 하나의 컴포넌트-->
<template>
  <div>
    <h1>This is Home page</h1>
    <form action="">
      <!--부모에서 자식이 보낸 데이터 받는 방법-->
      <!-- <InputField :name="name" @update-name="updateName"/> -->
      <!--아래와 같이 작성하면 methods 필요 없다.-->
      <!-- <InputField :name="name" @update-name="name = $event.target.value" /> -->
      <InputField v-model="name"/>
      <br /><button>Submit</button>
    </form>
    {{ name }}
  </div>
</template>

<script>
import InputField from "@/components/InputField.vue";
export default {
  components: {
    InputField,
  },
  data() {
    return {
      name: "",
    };
  },
  // methods: {
  //   updateName(name) {
  //     this.name = name;
  //   }
  // }
};
</script>

<!--scoped 작성 시 이 템플릿에만 적용된다. 작성하지 않으면 전체에 적용된다. -->
<style scoped>
h1 {
  color: green;
}
</style>
