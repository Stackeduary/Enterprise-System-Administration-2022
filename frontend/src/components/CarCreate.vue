<template>
  <main>
    <form class="container">
      <label for="plate">
        Plate
        <input
          v-model="Car.licensePlateNumber"
          type="text"
          id="plate"
          name="plate"
          placeholder="Plate number"
          required
        />
      </label>
      <label for="make">
        Make
        <input
          v-model="Car.make"
          type="text"
          id="make"
          name="make"
          placeholder="Make"
          required
        />
      </label>
      <label for="model">
        Model
        <input
          v-model="Car.model"
          type="text"
          id="model"
          name="model"
          placeholder="Model"
          required
        />
      </label>
      <label for="year">
        Year
        <input
          v-model="Car.year"
          type="number"
          id="year"
          name="year"
          placeholder="Year"
          required
        />
      </label>
      <label for="marketValue">
        Market value
        <input
          v-model="Car.currentMarketValue"
          type="number"
          id="marketValue"
          name="marketValue"
          placeholder="Market value"
          required
        />
      </label>
      <label for="mileage">
        Mileage
        <input
          v-model="Car.mileage"
          type="number"
          id="mileage"
          name="mileage"
          placeholder="Mileage"
          required
        />
      </label>
      <label for="Car.carOwner">
        Owner
        <select v-model="Car.carOwner" id="owner" name="owner" required>
          <option disabled value="">Select an owner</option>
          <option v-for="owner in owners" :value="owner.id" :key="owner.id">
            {{ owner.name }}
          </option>
        </select>
      </label>
      <label for="latitude">
        Latitude
        <input
          v-model="Car.latitude"
          type="text"
          id="latitude"
          name="latitude"
          placeholder="Latitude"
          required
        />
      </label>
      <label for="longitude">
        Longitude
        <input
          v-model="Car.longitude"
          type="text"
          id="longitude"
          name="longitude"
          placeholder="Longitude"
          required
        />
      </label>
      <label for="available">
        Available
        <input
          v-model="Car.available"
          type="checkbox"
          id="available"
          name="available"
          placeholder="Available"
          required
        />
      </label>

      <button @click="createOrUpdateCar" type="submit">Create</button>
    </form>
  </main>
</template>

<script>
import * as api from "../views/api";
import axios from "axios";
import router from "@/router";
export default {
  name: "CarCreate",
  data() {
    return {
      owners: [],
      Car: {
        licensePlateNumber: "",
        make: "",
        model: "",
        year: "",
        currentMarketValue: "",
        mileage: "",
        carOwner: "",
        latitude: "",
        longitude: "",
        available: false,
      },
    };
  },
  methods: {
    fetchOwners() {
      this.owners = [];
      axios
        .get(api.ENDPOINTS.carOwners, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          response.data.forEach((entry) => {
            this.owners.push({
              id: entry.id,
              name: entry.name,
            });
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    createOrUpdateCar(e) {
      e.preventDefault();
      const data = {
        licensePlateNumber: this.Car.licensePlateNumber,
        make: this.Car.make,
        model: this.Car.model,
        year: this.Car.year,
        currentMarketValue: this.Car.currentMarketValue,
        mileage: this.Car.mileage,
        carOwner: this.Car.carOwner,
        pickupLocation: {
          latitude: this.Car.latitude,
          longitude: this.Car.longitude,
        },
        available: this.Car.available,
      };
      switch (this.id != null && this.id !== "") {
        case false:
          axios
            .post(api.ENDPOINTS.car.create, data, {
              headers: {
                Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
              },
            })
            .then((response) => {
              console.log(response);
              this.$swal("Yay!", "Car created!", "success");
              router.replace({ path: "/car/manage" });
            })
            .catch((error) => {
              console.log(error);
              this.$swal("Oops", "Something went wrong", "error");
            });
          break;
        case true:
          axios
            .put(api.ENDPOINTS.car.update(this.id), data, {
              headers: {
                Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
              },
            })
            .then((response) => {
              this.$swal("Yay!", "Car updated!", "success");
              router.replace({ path: "/car/manage" });
              console.log(response);
            })
            .catch((error) => {
              console.log(error);
              this.$swal("Oops", "Something went wrong", "error");
            });
      }
    },
  },
  params: {
    id: null,
  },
  async beforeMount() {
    this.id = this.$route.params.id;
    await this.fetchOwners();
    if (this.id != null && this.id !== "") {
      axios
        .get(api.ENDPOINTS.car.update(this.id), {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          console.log(response.data);
          this.Car = response.data.car;
          this.Car.id = response.data.id;
          this.Car.carOwner = response.data.car.carOwner.id;
          this.Car.available = response.data.available;
          if (response.data.car.pickupLocation) {
            this.Car.latitude = response.data.car.pickupLocation.latitude;
            this.Car.longitude = response.data.car.pickupLocation.longitude;
          }
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    }
  },
};
</script>

<style scoped></style>
