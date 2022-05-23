import jwt_decode from "jwt-decode";
import axios from "axios";
import { getCommentList, createComment } from "@/api/comment";
import { create } from "nouislider";

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
          console.log(response);
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
              console.log(response);
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
  },
};

export default commentStore;
