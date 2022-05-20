<template class="container">
  <h2>Car repair details</h2>
  <ul>
    <li><b>Car</b>: {{ carRepair.car }}</li>
    <li><b>Bay</b>: {{ carRepair.car_repair_bay_id }}</li>
    <li><b>Started on</b>: {{ carRepair.repair_start_time }}</li>
    <li><b>Finished on</b>: {{ carRepair.repair_finish_time }}</li>
    <li><b>Status</b>: {{ carRepair.status }}</li>
    <li><button @click="finishRepair">Finish repair</button></li>
  </ul>
</template>

<script>
import axios from "axios";
import * as api from "@/views/api";
import router from "@/router";
export default {
  name: "CarRepairFinish",
  data() {
    return {
      carRepair: "",
    };
  },
  params: {
    id: null,
  },
  beforeMount() {
    this.id = this.$route.params.id;
    axios
      .get(api.ENDPOINTS.carRepair.get(this.id), {
        headers: {
          Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
        },
      })
      .then((response) => {
        let entry = response.data;
        let carRepair = {};
        carRepair.id = entry.id;
        console.log(carRepair);
        let tst = new Date(entry.repairTime.startTime);
        carRepair.repair_start_time = `${
          tst.getMonth() + 1
        }/${tst.getDate()}/${tst.getFullYear()} at ${tst.getHours()}:${tst.getMinutes()}`;
        carRepair.repair_finish_time = entry.repairTime.finishTime
          ? entry.repairTime.finishTime
          : "Not finished yet";
        carRepair.status = entry.status;
        carRepair.car = `${entry.car.make} (${entry.car.licensePlateNumber})`;
        carRepair.car_repair_bay_id = `Bay #${entry.carRepairBay.id}`;
        this.carRepair = carRepair;
      })
      .catch((error) => {
        console.log(error);
        this.$swal("Oops", "Something went wrong", "error");
      });
  },
  methods: {
    finishRepair() {
      axios
        .post(
          api.ENDPOINTS.carRepair.update(this.id),
          {},
          {
            headers: {
              Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
            },
          }
        )
        .then((response) => {
          console.log(response);
          this.$swal("Yay!", "Repair finished!", "success");
          router.replace({ path: "/carrepair/view" });
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
ul li {
  list-style: none;
}
button {
  background-color: #6a2323;
  width: 250px;
  float: right;
  margin-right: 42%;
}
</style>
