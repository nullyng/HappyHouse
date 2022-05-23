<template>
  <div class="container pt-lg-md border shadow p-5 mt-5 mb-5 bg-white">
    <b-input-group>
      <b-form-input v-model="contents"></b-form-input>
      <b-input-group-append>
        <b-button variant="primary" @click="createComment">답변 등록</b-button>
      </b-input-group-append>
    </b-input-group>
    <b-container id="commentList">
      <div class="mt-3">
        <b-row class="flex-column border border-light rounded p-4">
          <b-row>
            <b-col> admin | 2022-05-19 </b-col>
          </b-row>
          <b-row class="mt-3">
            <b-col>답변이 어쩌고</b-col>
          </b-row>
        </b-row>
      </div>
    </b-container>
  </div>
</template>

<script>
import { getCommentList, createComment } from "@/api/comment";
import { mapGetters } from "vuex";

const userStore = "userStore";

export default {
  name: "QnaComment",
  data() {
    return {
      contents: "",
    };
  },
  props: {
    boardId: String,
  },
  created() {
    getCommentList(
      this.boardId,
      (response) => {
        console.log(response);
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    ...mapGetters(userStore, ["checkUserInfo"]),
    createComment() {
      const userInfo = this.checkUserInfo();
      // console.log(userInfo);
      const comment = {
        id: userInfo.userId,
        boardId: this.boardId,
        contents: this.contents,
      };
      console.log(comment);
    //   createComment(
    //     comment,
    //     (response) => {
    //       console.log(response);
    //     },
    //     (error) => {
    //       console.log(response);
    //     }
    //   );
    },
  },
};
</script>

<style></style>
