import { createWebHistory, createRouter } from "vue-router";
import Mainpage from "../views/Mainpage.vue";
import EmployeeCreate from "../views/EmployeeCreate.vue";
import EmployeeLogin from "../views/EmployeeLogin.vue";

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
];

const router = createRouter({
  mode: "history",
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

// eslint-disable-next-line no-unused-vars
router.beforeEach(async (to, from) => {
  console.log("test");
  if (
    !isAuthenticated() &&
    (to.name !== "EmployeeLogin" || to.name !== "EmployeeCreate")
  ) {
    return { name: "EmployeeLogin" };
  }
});
export default router;
