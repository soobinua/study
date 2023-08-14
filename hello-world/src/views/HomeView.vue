<!--싱글 파일 컴포넌트 (Single File Component) 하나의 파일에 하나의 컴포넌트-->
<template>
  <div>
    <h1>This is Home page</h1>
    <!-- <form action=""> -->
    <!--부모에서 자식이 보낸 데이터 받는 방법-->
    <!-- <InputField :name="name" @update-name="updateName"/> -->
    <!--아래와 같이 작성하면 methods 필요 없다.-->
    <!-- <InputField :name="name" @update-name="name = $event.target.value" /> -->
    <InputField v-model="name" />
    <br /><button @click="updateName">Submit</button>
    <!-- </form> -->
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
      name: "SooBin",
    };
  },
  beforeCreate() {
    //데이터 접근 불가
    console.log("beforeCreate", this.name);
  },
  created() {
    //데이터 접근 가능
    console.log("created", this.name);
  },
  beforeMount() {
    //DOM 접근 불가
    alert("beforeMount");
  },
  mounted() {
    //DOM 접근 가능
    alert("mounted");
  },
  beforeUpdate() {
    //데이터 바뀌기 전
    alert("beforeUpdate");
  },
  updated() {
    //데이터 바뀐 후
    alert("updated");
  },
  beforeDestroy() {
    //메모리 누수 방지
    //ex. 이벤트 리스너가 있다면 이벤트 리스너 삭제, 데이터 초기화
    alert("beforeDestroy");
  },
  destroyed() {
    alert("destroyed");
  },
  methods: {
    updateName() {
      this.name = "Hello";
    },
  },
};
</script>

<!--scoped 작성 시 이 템플릿에만 적용된다. 작성하지 않으면 전체에 적용된다. -->
<style scoped>
h1 {
  color: green;
}
</style>
