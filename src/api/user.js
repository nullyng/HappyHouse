import { apiInstance } from "./index.js";

const api = apiInstance();

async function fetchData(id, pwd, success, fail) {
  await api.get(`user/login?id=${id}&pwd=${pwd}`).then(success).catch(fail);
}

async function getData(success, fail) {
  await api.get(`/user/`).then(success).catch(fail);
}

async function updateUser(success, fail) {
  await api.put(`/user`).then(success).catch(fail);
}

async function deleteUser(success, fail) {
  await api.delete(`/user`).then(success).catch(fail);
}

async function findById(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/info/${userid}`).then(success).catch(fail);
}

// function logout(success, fail)

export { fetchData, getData, updateUser, deleteUser, findById };
