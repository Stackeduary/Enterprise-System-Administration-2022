<template>
  <h2>Car Rent Details</h2>
  <ul>
    <li><b>Car</b>: {{ carRent.car }}</li>
    <li><b>Renter</b>: {{ carRent.renter }}</li>
    <li><b>Started on</b>: {{ carRent.rentStartTime }}</li>
    <li><b>Finished on</b>: {{ carRent.rentFinishTime }}</li>
    <li><button @click="finishRent">Finish rent</button></li>
  </ul>
</template>

<script>
import axios from "axios";
import * as api from "@/views/api";
import router from "@/router";

export default {
  name: "CarRentDetails",
  data() {
    return {
      carRent: {
        id: null,
        car: "",
        renter: "",
        rentStartTime: "",
        rentFinishTime: "",
      },
    };
  },
  params: {
    id: null,
  },
  methods: {
    getCarRent() {
      axios
        .get(api.ENDPOINTS.carRent.get(this.id), {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          let entry = response.data;
          this.carRent.id = entry.id;
          let tst = new Date(entry.rentTime.startTime);
          this.carRent.rentStartTime = `${
            tst.getMonth() + 1
          }/${tst.getDate()}/${tst.getFullYear()} at ${tst.getHours()}:${tst.getMinutes()}`;
          this.carRent.rentFinishTime = entry.rentTime.finishTime
            ? entry.rentTime.finishTime
            : "Not finished yet";
          this.carRent.status = entry.status;
          this.carRent.car = `${entry.car.make} (${entry.car.licensePlateNumber})`;
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    },
    finishRent() {
      axios
        .put(
          api.ENDPOINTS.carRent.update(this.id),
          {},
          {
            headers: {
              Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
            },
          }
        )
        .then((response) => {
          console.log(response);
          this.$swal("Yay!", "Rent finished!", "success");
          router.replace({ path: "/car/rents" });
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    },
  },
  beforeMount() {
    this.id = this.$route.params.id;
    if (this.id != null && this.id != undefined) {
      this.getCarRent();
    }
  },
};
</script>

<style scoped></style>
