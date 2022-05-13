import { createApp } from "vue";
import App from "./App.vue";
import "@picocss/pico/css/pico.min.css";
import router from "@/router";
const app = createApp(App);
app.use(router).mount("#app");
