import { createWebHistory, createRouter } from "vue-router";
import Mainpage from "../views/Mainpage.vue";

const routes = [
  {
    path: "/",
    name: "Mainpage",
    component: Mainpage,
  },
];

const router = createRouter({
  mode: "history",
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
