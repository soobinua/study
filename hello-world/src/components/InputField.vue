<template>
  <div>
    <label for="">Name</label>
    <input
      type="text"
      :value="value"
      style="padding: 30px; border: 2px solid green"
      @input="$emit('input', $event.target.value)"
    />
    <!--@input="$emit('update-name', $event)" 이렇게 작성하면 methods 필요 없다.-->
    <!-- @input="updateName" -->
  </div>
</template>

<script>
export default {
  props: {
    value: {
      type: String,
      required: true,
    },
  },
  methods: {
    // updateName(e) {
    //   console.log(e.target.value);
    //   //this.$emit 부모 컴포넌트로 데이터 보내기
    //   this.$emit('update-name', e.target.value);
    // },
  },
};
</script>
