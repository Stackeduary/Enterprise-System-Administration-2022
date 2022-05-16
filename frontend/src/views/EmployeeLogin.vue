<template>
  <main>
    <form class="container">
      <label for="username">
        Username
        <input
          v-model="Employee.username"
          type="text"
          id="username"
          name="username"
          placeholder="Username"
          required
        />
      </label>

      <label for="password">Password</label>
      <input
        v-model="Employee.password"
        type="password"
        id="password"
        name="password"
        placeholder="Password"
        required
      />

      <!-- Button -->
      <button @click="loginEmployee" type="submit">Login</button>
    </form>
    <router-link to="/employee/create"> Don't have an account yet</router-link>
  </main>
</template>

<script>
import * as api from "./api";
import axios from "axios";
import router from "@/router";
export default {
  name: "EmployeeLogin",
  data() {
    return {
      Employee: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    loginEmployee(e) {
      e.preventDefault();
      const data = {
        username: this.Employee.username,
        password: this.Employee.password,
      };
      axios
        .post(api.ENDPOINTS.employeeLogin, data)
        .then((response) => {
          sessionStorage.setItem("Token", response.headers["authorization"]);
          router.replace("/");
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Wrong credentials", "error");
        });
    },
  },
};
</script>

<style scoped>
form {
  margin-top: 50px;
}
</style>
