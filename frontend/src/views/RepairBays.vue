<template>
  <main class="container">
    <div>
      <h1>Repair bays</h1>
      <button id="newbay" @click="newBay">New bay</button>
      <CustomTable :columns="columns" :items="this.bays" link="carrepair" />
    </div>
    <p>
      <router-link to="/carrepair/view">View all car repairs</router-link>
    </p>
    <router-view></router-view>
  </main>
</template>

<script>
import CustomTable from "@/components/CustomTable";
import axios from "axios";
import * as api from "@/views/api";

export default {
  name: "RepairBays",
  components: { CustomTable },
  data() {
    return {
      bays: [],
      columns: ["id", "available"],
    };
  },
  methods: {
    getBays: function () {
      axios
        .get(api.ENDPOINTS.bay.list, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          this.bays = response.data;
          this.bays.forEach((element) => (element.available = "Available"));
        });
    },
    newBay: function () {
      axios
        .post(
          api.ENDPOINTS.bay.list,
          {},
          {
            headers: {
              Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
            },
          }
        )
        .then((response) => {
          console.log(response.data);
          this.$swal("Yay!", "Bay created!", "success");
          window.location.reload();
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    },
  },
  async beforeMount() {
    await this.getBays();
  },
};
</script>

<style scoped>
#newbay {
  width: 250px;
}
</style>
