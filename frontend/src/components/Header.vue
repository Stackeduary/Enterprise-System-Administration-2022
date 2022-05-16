<template>
  <nav class="container">
    <ul>
      <li><strong>Adil'sDeals</strong></li>
    </ul>
    <ul>
      <li>
        <router-link to="/" class="secondary">Home</router-link>
      </li>
      <li><a href="#" class="secondary">Repair</a></li>
      <li><a href="#" class="secondary">Rent</a></li>
      <li><a href="#" class="secondary">Data</a></li>
      <!-- TODO: add logout feature -->
      <li>
        <a
          href="#"
          role="button"
          id="logout"
          v-if="sessionStorage.getItem('Token') !== null"
          >Logout</a
        >
        <a href="#" role="button" id="login" v-else>Login</a>
      </li>
    </ul>
  </nav>
  <router-view></router-view>
</template>

<script>
export default {};
</script>
<style scoped>
.secondary:hover {
  color: white;
  background-color: grey;
}
#logout {
  background-color: #b23b3b;
  border: none;
}
#logout:hover {
  background-color: #6a2323;
}
</style>
