<template>
  <main>
    <div>
      <h1>Car Owners</h1>
      <p>
        <router-link to="/carowner">Add a new car owner</router-link>
      </p>
      <CustomTable :columns="columns" :items="this.carOwners" link="carowner" />
    </div>
  </main>
</template>

<script>
import axios from "axios";
import CustomTable from "@/components/CustomTable";
import * as api from "@/views/api";

export default {
  name: "CarOwners",
  components: { CustomTable },
  data() {
    return {
      carOwners: [],
      columns: ["id", "name", "address", "email", "telephoneNumber"],
    };
  },
  methods: {
    getCarOwners: function () {
      axios
        .get(api.ENDPOINTS.carOwners, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          this.carOwners = response.data;
        });
    },
  },
  async beforeMount() {
    await this.getCarOwners();
  },
};
</script>
