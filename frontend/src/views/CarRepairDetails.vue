<template>
  <main class="container">
    <h1>Car repairs</h1>
    <CustomTable
      :columns="columns"
      :items="this.carRepairs"
      link="carrepair/details"
    />
  </main>
</template>

<script>
import CustomTable from "@/components/CustomTable";
import axios from "axios";
import * as api from "@/views/api";

export default {
  name: "CarRepairDetails",
  components: { CustomTable },
  data() {
    return {
      carRepairs: [],
      columns: [
        "id",
        "status",
        "repair_start_time",
        "repair_finish_time",
        "car",
        "car_repair_bay_id",
      ],
    };
  },
  methods: {
    getCarRepairs: function () {
      axios
        .get(api.ENDPOINTS.carRepair.list, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          if (response.data.length > 0) {
            response.data.forEach((entry) => {
              let carRepair = {};
              carRepair.id = entry.id;
              let tst = new Date(entry.repairTime.startTime);
              carRepair.repair_start_time = `${
                tst.getMonth() + 1
              }/${tst.getDate()}/${tst.getFullYear()} at ${tst.getHours()}:${tst.getMinutes()}`;
              carRepair.repair_finish_time = entry.repairTime.finishTime
                ? entry.repairTime.finishTime
                : "Not finished yet";
              carRepair.status = entry.status;
              carRepair.car = `${entry.car.make} (${entry.car.licensePlateNumber})`;
              if (entry.carRepairBay) {
                carRepair.car_repair_bay_id = `Bay #${entry.carRepairBay.id}`;
              } else {
                carRepair.car_repair_bay_id = "-";
              }
              this.carRepairs.push(carRepair);
            });
          }
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    },
  },
  async beforeMount() {
    await this.getCarRepairs();
  },
};
</script>

<style scoped></style>
