import jwt_decode from "jwt-decode";
import axios from "axios";
import {
  getCommentList,
  createComment,
  deleteComment,
  modifyComment,
} from "@/api/comment";

const commentStore = {
  namespaced: true,
  state: {
    commentList: [],
  },
  getters: {},
  mutations: {
    SET_COMMENT_LIST(state, commentList) {
      state.commentList = commentList;
    },
  },
  actions: {
    getCommentList({ commit }, id) {
      getCommentList(
        id,
        (response) => {
          commit("SET_COMMENT_LIST", response.data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    createComment({ commit }, comment) {
      createComment(
        comment,
        (response) => {
          getCommentList(
            comment.boardId,
            (response) => {
              commit("SET_COMMENT_LIST", response.data);
            },
            (error) => {
              console.log(error);
            }
          );
        },
        (error) => {
          console.log(error);
        }
      );
    },
    deleteComment({ commit }, item) {
      deleteComment(
        item.commentId,
        (response) => {
          getCommentList(
            item.boardId,
            (response) => {
              commit("SET_COMMENT_LIST", response.data);
            },
            (error) => {
              console.log(error);
            }
          );
        },
        (error) => {
          console.log(error);
        }
      );
    },
    modifyComment({ commit }, comment) {
      console.log(comment);
      modifyComment(
        comment,
        (response) => {
          console.log(response);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default commentStore;
