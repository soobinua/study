<!--싱글 파일 컴포넌트 (Single File Component) 하나의 파일에 하나의 컴포넌트-->
<template>
  <div>
    <h1>This is Home page</h1>
    <SooBin title="home title" name="soobin"></SooBin>
  </div>
</template>

<script>
import SooBin from "@/components/SooBin.vue";

export default {
  components: {
    SooBin,
  },
  data() {
    return {
      name: "SooBin",
    };
  },
};
</script>

<!--scoped 작성 시 이 템플릿에만 적용된다. 작성하지 않으면 전체에 적용된다. -->
<style scoped>
h1 {
  color: green;
}
</style>
