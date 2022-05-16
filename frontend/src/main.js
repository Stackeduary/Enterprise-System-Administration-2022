import { createApp } from "vue";
import App from "./App.vue";
import "@picocss/pico/css/pico.min.css";
import router from "@/router";
import axios from "axios";
import VueAxios from "vue-axios";
import VueSweetalert2 from "vue-sweetalert2";
import "sweetalert2/dist/sweetalert2.min.css";

const app = createApp(App);
app.use(router);
app.use(VueSweetalert2);
app.use(VueAxios, axios);
app.mount("#app");
