<template>
  <v-simple-table>
    <thead>
      <th v-for="column in columns" :key="column">
        {{ column }}
      </th>
    </thead>
    <tbody>
      <tr v-for="item in items" :key="item.id">
        <td v-for="column in columns" :key="column">
          <router-link v-if="column === 'id'" :to="getLink(item.id)">
            {{ item[column] }}
          </router-link>
          <span v-else>
            {{ item[column] }}
          </span>
        </td>
      </tr>
    </tbody>
  </v-simple-table>
</template>

<script>
export default {
  name: "CustomTable",
  props: {
    columns: {
      type: Array,
      required: true,
    },
    link: {
      type: String,
      required: true,
    },
    items: Array,
  },
  methods: {
    getLink(id) {
      return `/${this.link}/${id}`;
    },
  },
};
</script>
