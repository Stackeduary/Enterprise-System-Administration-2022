import { createWebHistory, createRouter } from "vue-router";
import Mainpage from "../views/Mainpage.vue";
import EmployeeCreate from "../views/EmployeeCreate.vue";

const routes = [
  {
    path: "/",
    name: "Mainpage",
    component: Mainpage,
  },
  {
    path: "/employee/create",
    name: "EmployeeCreate",
    component: EmployeeCreate,
  },
];

const router = createRouter({
  mode: "history",
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
