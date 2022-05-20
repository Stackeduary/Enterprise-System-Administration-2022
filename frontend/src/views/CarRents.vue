<template>
  <main>
    <div>
      <h1>Car Rents</h1>
      <p>
        <router-link to="/car/rent">Create</router-link>
      </p>
      <CustomTable :columns="columns" :items="this.carRents" link="car/rent" />
    </div>
  </main>
</template>

<script>
import CustomTable from "@/components/CustomTable";
import * as api from "@/views/api";
import axios from "axios";
export default {
  name: "CarRents",
  components: { CustomTable },
  data() {
    return {
      carRents: [],
      columns: ["id", "renter", "start_time", "finish_time", "car"],
    };
  },
  methods: {
    fetchCarRents() {
      this.carRents = [];
      axios
        .get(api.ENDPOINTS.rent, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          response.data.forEach((carRent) => {
            this.carRents.push({
              id: carRent.id,
              renter: carRent.renter,
              start_time: carRent.rentTime.startTime,
              finish_time: carRent.rentTime.finishTime,
              car: carRent.car.licensePlateNumber,
            });
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  async beforeMount() {
    await this.fetchCarRents();
  },
};
</script>

<style scoped></style>
