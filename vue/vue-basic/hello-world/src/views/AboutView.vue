<template>
  <div class="about">
    <h1>This is an about page</h1>
    <SooBin>
      <!-- <template v-slot:header> -->
      <!--위와 동일 -->
      <!-- <template #header="props"> -->
      <template #header="{ soo }">
        <!--slot의 속성 이용-->
        <!-- <p>slot-header {{ props.soo }}</p> -->
        <p>slot-header {{ soo}}</p>
      </template>
      <template v-slot:default>
        slot-default
      </template>
    </SooBin>
  </div>
</template>

<script>
import SooBin from "@/components/SooBin.vue";

export default {
  components: {
    SooBin,
  },
};
</script>
