<template>
  <div class="container">
    <router-link to="/car/create" class="secondary">Create a car</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "Car",
};
</script>

<style scoped></style>
