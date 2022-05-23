import { apiInstance } from "./index.js";

const api = apiInstance();

async function sidoList(success, fail) {
  await api.get(`/code?regcode=*`).then(success).catch(fail);
}

function gugunList(regcode, success, fail) {
  api.get(`/code?regcode=${regcode}`).then(success).catch(fail);
}

function dongList(regcode, success, fail) {
  api.get(`/code?regcode=${regcode}`).then(success).catch(fail);
}

function searchByAptNameAndDongName(aptName, dongName, success, fail) {
  api
    .get(`/houseInfo?aptName=${aptName}&dongName=${dongName}`)
    .then(success)
    .catch(fail);
}

export { sidoList, gugunList, dongList, searchByAptNameAndDongName };
