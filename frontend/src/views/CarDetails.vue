<template>
  <button class="container contrast" @click="deleteCar">Delete this car</button>
  <CarCreate />
</template>

<script>
import CarCreate from "@/components/CarCreate";
import * as api from "../views/api";
import axios from "axios";
import router from "@/router";
export default {
  name: "CarDetails",
  components: { CarCreate },
  params: {
    id: null,
  },
  beforeMount() {
    this.id = this.$route.params.id;
  },
  methods: {
    deleteCar() {
      axios
        .delete(api.ENDPOINTS.car.delete(this.id), {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          console.log(response.data);
          this.$swal("Yay!", "Car deleted!", "success");
          router.replace({ path: "/car/manage" });
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    },
  },
};
</script>

<style scoped>
button {
  background-color: #6a2323;
  width: 150px;
  border-radius: 12px;
}
</style>
