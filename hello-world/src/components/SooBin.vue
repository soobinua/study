<template>
  <div>
    <p>{{ name }}</p>
    <button @click="updateName">Change Name</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: "SooBin",
    }
  },
  methods: {
    updateName() {
      this.name = "SooBin Updated";
    },
  },
};
</script>

<style scoped></style>
