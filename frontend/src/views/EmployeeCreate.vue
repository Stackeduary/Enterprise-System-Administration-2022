<template>
  <main>
    <h3 v-if="result > 0">Employee created!</h3>
    <h3 v-if="result < 0">Oh no, something went wrong 😢</h3>

    <form class="container">
      <label for="name">
        Name
        <input
          v-model="Employee.name"
          type="text"
          id="name"
          name="name"
          placeholder="Name"
          required
        />
      </label>

      <!-- Markup example 1: input is inside label -->
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

      <label for="passwordCheck">Repeat you password</label>
      <input
        v-model="Employee.passwordCheck"
        type="password"
        id="passwordCheck"
        name="passwordCheck"
        placeholder="Repeat your password"
        required
      />

      <!-- Button -->
      <button @click="createEmployee" type="submit">Create</button>
    </form>
  </main>
</template>

<script>
import * as api from "./api";
import axios from "axios";
export default {
  name: "EmployeeCreate",
  data() {
    return {
      Employee: {
        name: "",
        username: "",
        password: "",
        passwordCheck: "",
      },
      result: 0,
    };
  },
  methods: {
    createEmployee(e) {
      e.preventDefault();
      const data = {
        name: this.Employee.name,
        username: this.Employee.username,
        password: this.Employee.password,
        passwordCheck: this.Employee.passwordCheck,
      };
      axios
        .post(api.ENDPOINTS.employeeCreate, data)
        .then((response) => {
          console.log(response);
          this.result = 1;
        })
        .catch((error) => {
          console.log(error);
          this.result = -1;
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
