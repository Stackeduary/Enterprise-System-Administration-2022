<template>
  <main>
    <form class="container">
      <label for="name">
        Name
        <input
          v-model="CarOwner.name"
          type="text"
          id="name"
          name="name"
          placeholder="Name"
          required
        />
      </label>
      <label for="address">
        Address
        <input
          v-model="CarOwner.address"
          type="text"
          id="address"
          name="address"
          placeholder="Address"
          required
        />
      </label>
      <label for="phone">
        Telephone number
        <input
          v-model="CarOwner.telephoneNumber"
          type="text"
          id="phone"
          name="phone"
          placeholder="Telephone number"
          required
        />
      </label>
      <label for="email">
        Email
        <input
          v-model="CarOwner.email"
          type="email"
          id="email"
          name="email"
          placeholder="Car owner"
          required
        />
      </label>

      <button @click="createCarOwner" type="submit">
        <span v-if="isIdNull">Create car owner</span>
        <span v-else>Update car owner</span>
      </button>
    </form>
  </main>
</template>

<script>
import axios from "axios";
import * as api from "@/views/api";
import router from "@/router";

export default {
  name: "CarOwner",
  data() {
    return {
      CarOwner: {
        name: "",
        address: "",
        telephoneNumber: "",
        email: "",
      },
    };
  },
  params: {
    id: null,
  },
  computed: {
    isIdNull() {
      console.log(this.id);
      return this.id == null || this.id == "";
    },
  },
  methods: {
    createCarOwner(e) {
      e.preventDefault();
      const data = {
        name: this.CarOwner.name,
        address: this.CarOwner.address,
        telephoneNumber: this.CarOwner.telephoneNumber,
        email: this.CarOwner.email,
      };
      (this.id == null || this.id === ""
        ? axios.post(api.ENDPOINTS.carOwner, data, {
            headers: {
              Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
            },
          })
        : axios.put(api.ENDPOINTS.carOwner + this.id, data, {
            headers: {
              Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
            },
          })
      )
        .then((response) => {
          console.log(response);
          this.$swal("Yay!", "Car Owner created!", "success");
          router.replace({ path: "/carowners" });
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    },
  },
  beforeMount() {
    this.id = this.$route.params.id;
    if (this.id != null && this.id != "") {
      axios
        .get(api.ENDPOINTS.carOwner + this.id, {
          headers: {
            Authorization: `Bearer ${sessionStorage.getItem("Token")}`,
          },
        })
        .then((response) => {
          this.CarOwner = response.data;
        })
        .catch((error) => {
          console.log(error);
          this.$swal("Oops", "Something went wrong", "error");
        });
    }
  },
};
</script>
