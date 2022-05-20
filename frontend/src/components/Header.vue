<template>
  <nav class="container">
    <ul>
      <li><strong>Adil'sDeals</strong></li>
    </ul>
    <ul>
      <li>
        <router-link to="/" class="secondary">Home</router-link>
      </li>
      <li>
        <router-link to="/car/manage" class="secondary">Cars</router-link>
      </li>
      <li>
        <router-link to="/repairbays" class="secondary">Repair</router-link>
      </li>

      <li>
        <router-link to="/car/rents" class="secondary">Rent</router-link>
      </li>

      <li>
        <button @click="logout" id="logout" v-if="isAuthenticated()">
          Logout
        </button>
        <router-link to="/login" role="button" id="login" v-else
          >Login</router-link
        >
      </li>
    </ul>
  </nav>
  <router-view></router-view>
</template>

<script>
export default {
  methods: {
    isAuthenticated() {
      return sessionStorage.getItem("Token") !== null;
    },
    logout() {
      sessionStorage.removeItem("Token");
      this.$forceUpdate();
    },
  },
};
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
