<template>
  <h1>Hello</h1>
</template>

<script>
export default {
  name: "CarOwner",
  params: {
    id: null,
  },
  beforeCreate() {
    this.id = this.$route.params.id;
  },
};
</script>
