const BASE_URL = "http://localhost:8031";
export const ENDPOINTS = {
  employeeCreate: BASE_URL + "/employee/create",
  employeeLogin: BASE_URL + "/login",
  car: {
    list: BASE_URL + "/car",
    create: BASE_URL + "/car/create",
    update: (id) => BASE_URL + "/car/" + id,
  },
  carOwners: BASE_URL + "/car-owner",
  carOwner: BASE_URL + "/car-owner/",
  carOwnerCreate: BASE_URL + "/car-owner/create",
};
