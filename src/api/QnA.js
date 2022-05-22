import { apiInstance } from "./index.js";

const api = apiInstance();

function listQnA(success, fail) {
    api.get(`/board/list`)
        .then(success)
        .catch(fail);
}

function getQnA(id, success, fail) {
    api.get(`/board/${id}`)
        .then(success)
        .catch(fail);
}

function createQnA(item, success, fail) {
    api.post(`/board/`, item)
        .then(success)
        .catch(fail);
}

function deleteQnA(id, success, fail) {
    api.delete(`/board/${id}`)
        .then(success)
        .catch(fail);
}

function updateQnA(item, success, fail) {
    api.put(`/board/${item.id}`, item)
        .then(success)
        .catch(fail);
}

export { listQnA, getQnA, deleteQnA, updateQnA, createQnA };