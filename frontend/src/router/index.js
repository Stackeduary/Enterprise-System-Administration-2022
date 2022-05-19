import { createWebHistory, createRouter } from "vue-router";
import Mainpage from "../views/Mainpage.vue";
import EmployeeCreate from "../views/EmployeeCreate.vue";
import EmployeeLogin from "../views/EmployeeLogin.vue";
import CarCreate from "@/components/CarCreate";
import Car from "@/views/Car";
const isAuthenticated = () => {
  return sessionStorage.getItem("Token") !== null;
};

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
  {
    path: "/login",
    name: "EmployeeLogin",
    component: EmployeeLogin,
  },
  {
    path: "/car/manage",
    name: "Car",
    component: Car,
  },
  {
    path: "/car/create",
    name: "CarCreate",
    component: CarCreate,
  },
];

const router = createRouter({
  mode: "history",
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

// eslint-disable-next-line no-unused-vars
router.beforeEach(async (to, from) => {
  console.log(isAuthenticated());
  // if (
  //   !isAuthenticated() &&
  //   !(to.name === "EmployeeLogin" || to.name === "EmployeeCreate")
  // ) {
  //   return { name: "EmployeeLogin" };
  // }
});
export default router;
