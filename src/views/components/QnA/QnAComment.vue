<template>
  <div class="container mb-5">
    <b-input-group>
      <b-form-input v-model="contents"></b-form-input>
      <b-input-group-append>
        <b-button variant="primary" @click="registerComment">답변 등록</b-button>
      </b-input-group-append>
    </b-input-group>
    <b-container id="commentList">
      <div class="mt-3" v-for="(item, index) in commentList" :key="index">
        <b-row class="flex-column border border-light rounded p-4">
          <b-row>
            <b-col> {{ item.writer }} | {{ item.regDate }} </b-col>
            <b-col> <span>수정</span> | <span>삭제</span> </b-col>
          </b-row>
          <b-row class="mt-3">
            <b-col>{{ item.contents }}</b-col>
          </b-row>
        </b-row>
      </div>
    </b-container>
  </div>
</template>

<script>
import { mapState, mapGetters, mapActions } from "vuex";

const userStore = "userStore";
const commentStore = "commentStore";

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
    this.$store.dispatch(`commentStore/getCommentList`, this.boardId);
  },
  computed: {
    ...mapState(commentStore, ["commentList"]),
  },
  methods: {
    ...mapGetters(userStore, ["checkUserInfo"]),
    ...mapActions(commentStore, ["createComment"]),
    registerComment() {
      const userInfo = this.checkUserInfo();
      const comment = {
        writer: userInfo.userId,
        boardId: this.boardId,
        contents: this.contents,
      };
      console.log("register!");
      this.createComment(comment);
    },
  },
};
</script>

<style></style>
