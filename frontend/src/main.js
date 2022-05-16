import { createApp } from "vue";
import App from "./App.vue";
import "@picocss/pico/css/pico.min.css";
import router from "@/router";
import axios from "axios";
import VueAxios from "vue-axios";
const app = createApp(App);
app.use(router).mount("#app");
app.use(VueAxios, axios);
