<template>
  <main>
    <form class="container">
      <label for="car">
        Car
        <input
          v-model="CarRepair.carId"
          type="number"
          id="carId"
          name="carId"
          placeholder="Car"
          required
        />
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
//import router from "@/router";
export default {
  name: "CarRepair",
  data() {
    return {
      CarRepair: {
        carId: "",
        carRepairBayId: parseInt(this.$route.params.id),
      },
    };
  },
  methods: {
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
          //router.replace({ path: "/car/manage" });
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    },
  },
};
</script>

<style scoped></style>
