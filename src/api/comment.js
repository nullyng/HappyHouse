import { apiInstance } from "./index.js";

const api = apiInstance();

function getCommentList(id, success, fail) {
  api.get(`/comment/${id}`).then(success).catch(fail);
}

function createComment(comment, success, fail) {
  api
    .post(`/comment/${comment.writer}/${comment.boardId}`, comment)
    .then(success)
    .catch(fail);
}

function deleteComment(id, success, fail) {
  api.delete(`/comment/${id}`).then(success).catch(fail);
}

export { getCommentList, createComment, deleteComment };
