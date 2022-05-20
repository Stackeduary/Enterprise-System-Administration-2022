<template>
  <div class="container">
    <CustomTable :columns="columns" :items="this.cars" link="car" />
    <router-link to="/car/create" class="secondary">Create a car</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
import axios from "axios";
import CustomTable from "@/components/CustomTable";
import * as api from "@/views/api";

export default {
  name: "Car",
  components: { CustomTable },
  data() {
    return {
      cars: [],
      columns: [
        "id",
        "licensePlateNumber",
        "make",
        "model",
        "year",
        "currentMarketValue",
        "mileage",
        "carOwner",
        "pickupLocation",
        "available",
      ],
    };
  },
  methods: {
    getCars: function () {
      axios
        .get(api.ENDPOINTS.car.list, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          this.cars = [];
          response.data.forEach((entry) => {
            let car = entry.car;
            car.available = entry.available;
            car.carOwner = entry.car.carOwner.name;
            car.id = entry.id;
            this.cars.push(car);
          });
        });
    },
  },
  async beforeMount() {
    await this.getCars();
  },
};
</script>

<style scoped></style>
