<template>
  <main>
    <form class="container">
      <label for="carId">
        Car
        <select v-model="CarRepair.carId" id="carId" name="carId" required>
          <option disabled value="">Select a car</option>
          <option v-for="car in cars" :value="car.id" :key="car.id">
            {{ car.name }}
          </option>
        </select>
      </label>
      <label for="repairbay">
        Repair bay
        <input
          v-model="CarRepair.carRepairBayId"
          type="number"
          id="carRepairBayId"
          name="carRepairBayId"
          placeholder="Bay number"
          required
          disabled
        />
      </label>

      <button @click="createCarRepair" type="submit">Create</button>
    </form>
  </main>
</template>

<script>
import * as api from "./api";
import axios from "axios";
import router from "@/router";
export default {
  name: "CarRepair",
  data() {
    return {
      cars: [],
      CarRepair: {
        carId: "",
        carRepairBayId: parseInt(this.$route.params.id),
      },
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
    createCarRepair(e) {
      e.preventDefault();
      const data = {
        carId: this.CarRepair.carId,
        carRepairBayId: this.CarRepair.carRepairBayId,
      };
      axios
        .post(api.ENDPOINTS.carRepair.create, data, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          console.log(response);
          this.$swal("Yay!", "Car repair submitted!", "success");
          router.replace({ path: "/car/manage" });
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    },
  },
  async beforeMount() {
    await this.getCarList();
  },
};
</script>

<style scoped></style>
