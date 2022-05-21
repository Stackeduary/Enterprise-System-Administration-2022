import { createWebHistory, createRouter } from "vue-router";
import Mainpage from "../views/Mainpage.vue";
import EmployeeCreate from "../views/EmployeeCreate.vue";
import EmployeeLogin from "../views/EmployeeLogin.vue";
import CarCreate from "@/components/CarCreate";
import Car from "@/views/Car";
import CarOwners from "@/views/CarOwners";
import CarOwner from "@/views/CarOwner";
import CarDetails from "@/views/CarDetails";
import RepairBays from "@/views/RepairBays";
import CarRepair from "@/views/CarRepair";
import CarRepairDetails from "@/views/CarRepairDetails";
import CarRepairFinish from "@/views/CarRepairFinish";
import CarRent from "@/views/CarRent";
import CarRents from "@/views/CarRents";
import CarRentDetails from "@/views/CarRentDetails";

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
    path: "/carowners",
    name: "CarOwners",
    component: CarOwners,
  },
  {
    path: "/carowner/:id?",
    name: "CarOwner",
    component: CarOwner,
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
  {
    path: "/car/:id",
    name: "CarDetails",
    component: CarDetails,
  },
  {
    path: "/repairbays",
    name: "RepairBays",
    component: RepairBays,
  },
  {
    path: "/carrepair/:id",
    name: "CarRepair",
    component: CarRepair,
  },
  {
    path: "/carrepair/view",
    name: "CarRepairDetails",
    component: CarRepairDetails,
  },
  {
    path: "/carrepair/details/:id",
    name: "CarRepairFinish",
    component: CarRepairFinish,
  },
  {
    path: "/car/rent",
    name: "CarRent",
    component: CarRent,
  },
  {
    path: "/car/rents",
    name: "CarRents",
    component: CarRents,
  },
  {
    path: "/car/rent/:id",
    name: "CarRentDetails",
    component: CarRentDetails,
  },
];

const router = createRouter({
  mode: "history",
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

// eslint-disable-next-line no-unused-vars
router.beforeEach(async (to, from) => {
  if (
    isAuthenticated() &&
    (to.name === "EmployeeLogin" || to.name === "EmployeeCreate")
  ) {
    return { name: "Mainpage" };
  }

  if (
    !isAuthenticated() &&
    !(to.name === "EmployeeLogin" || to.name === "EmployeeCreate")
  ) {
    return { name: "EmployeeLogin" };
  }
});
export default router;
