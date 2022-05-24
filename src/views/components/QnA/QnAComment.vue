<template>
  <div class="container mb-5">
    <b-input-group v-if="currentUserId === 'admin'">
      <b-form-input v-model="contents"></b-form-input>
      <b-input-group-append>
        <b-button variant="primary" @click="registerComment"
          >답변 등록</b-button
        >
      </b-input-group-append>
    </b-input-group>
    <b-container id="commentList">
      <div class="mt-3" v-for="(item, index) in commentList" :key="index">
        <b-row class="flex-column border border-light rounded p-4">
          <b-row>
            <b-col> {{ item.writer }} | {{ item.regDate }} </b-col>
            <b-col class="d-flex justify-content-end text-light">
              <div v-if="currentUserId === 'admin'">
                <span @click="convertModify">수정&nbsp;</span> |
                <span @click="removeComment(item.id)">&nbsp;삭제</span>
              </div>
            </b-col>
          </b-row>
          <b-row class="mt-3" v-if="!isModify">
            <b-col>{{ item.contents }}</b-col>
          </b-row>
          <b-row class="p-3">
            <b-input-group v-if="isModify">
              <b-form-input v-model="item.contents"></b-form-input>
              <b-input-group-append>
                <b-button variant="primary" @click="editComment(item)"
                  >등록</b-button
                >
                <b-button variant="primary" @click="convertModify"
                  >취소</b-button
                >
              </b-input-group-append>
            </b-input-group>
          </b-row>
        </b-row>
      </div>
    </b-container>
  </div>
</template>

<script>
import { mapState, mapGetters, mapActions } from "vuex";
import jwt_decode from "jwt-decode";

const userStore = "userStore";
const commentStore = "commentStore";

export default {
  name: "QnaComment",
  data() {
    return {
      contents: "",
      isModify: false,
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
    currentUserId: function () {
      let userId = "";
      const token = sessionStorage.getItem("access-token");
      if (token != null) {
        userId = jwt_decode(token).userid;
      }
      return userId;
    },
  },
  methods: {
    ...mapGetters(userStore, ["checkUserInfo"]),
    ...mapActions(commentStore, [
      "createComment",
      "deleteComment",
      "modifyComment",
    ]),
    // 댓글 등록
    registerComment() {
      const userInfo = this.checkUserInfo();
      if (userInfo == null) {
        alert("로그인이 필요한 서비스입니다.");
        this.$router.push("/user");
      } else {
        const comment = {
          writer: userInfo.userId,
          boardId: this.boardId,
          contents: this.contents,
        };
        this.createComment(comment);
        this.contents = "";
      }
    },
    // 댓글 삭제
    removeComment(id) {
      const item = {
        commentId: id,
        boardId: this.boardId,
      };
      if (confirm("삭제하시겠습니까?")) {
        this.deleteComment(item);
      }
    },
    // 수정 화면 전환
    convertModify() {
      this.isModify = !this.isModify;
    },
    // 댓글 수정
    editComment(item) {
      const comment = {
        contents: item.contents,
        id: item.id,
        boardId: item.boardId,
      };
      // console.log(item);
      this.modifyComment(comment);
      this.convertModify();
    },
  },
};
</script>

<style scoped>
span:hover {
  cursor: pointer;
}
</style>
