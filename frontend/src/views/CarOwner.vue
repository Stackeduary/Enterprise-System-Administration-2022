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

      <button @click="createCarOwner" type="submit">Create car owner</button>
    </form>
  </main>
</template>

<script>
export default {
  name: "CarOwner",
  data() {
    return {
      CarOwner: {
        name: "",
        address: "",
        phone: "",
        email: "",
      },
    };
  },
  params: {
    id: null,
  },
  beforeCreate() {
    this.id = this.$route.params.id;
  },
};
</script>
