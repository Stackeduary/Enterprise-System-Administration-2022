<template>
  <main>
    <div>
      <h1>Repair bays</h1>
      <CustomTable :columns="columns" :items="this.bays" />

      <p>
        <router-link to="/carrepair">New car repair</router-link>
      </p>
    </div>
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
        });
    },
  },
  async beforeMount() {
    await this.getBays();
  },
};
</script>

<style scoped></style>
