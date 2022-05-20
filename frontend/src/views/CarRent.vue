<template>
  <form class="container">
    <label for="renter">
      Renter
      <input type="text" v-model="renter" id="renter" />
    </label>
    <label for="car">
      Car
      <select v-model="car" id="car" name="car" required>
        <option disabled value="">Select a car</option>
        <option v-for="car in cars" :value="car.id" :key="car.id">
          {{ car.name }}
        </option>
      </select>
    </label>

    <button @click="createRent" type="submit">Create</button>
  </form>
</template>

<script>
import * as api from "@/views/api";
import axios from "axios";

export default {
  name: "CarRent",
  data() {
    return {
      cars: [],
      car: null,
      renter: "",
    };
  },
  methods: {
    getCarList() {
      this.cars = [];
      axios
        .get(api.ENDPOINTS.car.list, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          response.data.forEach((entry) => {
            this.cars.push({
              id: entry.id,
              name: entry.car.licensePlateNumber,
            });
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    createRent(e) {
      e.preventDefault();
      axios
        .post(
          api.ENDPOINTS.rent,
          {
            car: this.car,
            renter: this.renter,
          },
          {
            headers: {
              Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
            },
          }
        )
        .then(() => {
          this.$router.push("/rents");
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  beforeMount() {
    this.getCarList();
  },
};
</script>

<style scoped></style>
