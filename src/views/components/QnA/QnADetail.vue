<template>
  <div class="container pt-lg-md border shadow p-5 mt-5 mb-5 bg-white">
    <b-form>
      <b-form-group id="title-group" class="mb-4">
        <label for="title" class="mb-0">제목</label>
        <hr class="m-0" />
        <b-form-input id="title" plaintext type="text" :value="title" />
      </b-form-group>
      <b-row>
        <b-col>
          <b-form-group id="user-group" class="mb-4">
            <label for="user" class="mb-0">작성자</label>
            <hr class="m-0" />
            <b-form-input id="user" plaintext type="text" :value="writer" />
          </b-form-group>
        </b-col>
        <b-col
          ><b-form-group id="date-group">
            <label for="date" class="mb-0">작성날짜</label>
            <hr class="m-0" />
            <b-form-input
              id="date"
              plaintext
              type="text"
              :value="regDate"
            /> </b-form-group
        ></b-col>
      </b-row>
      <b-form-group id="content-group">
        <label for="content" class="mb-0">내용</label>
        <hr class="m-0" />
        <b-form-textarea
          id="content"
          :placeholder="contents"
          rows="5"
          no-resize
          plaintext
        ></b-form-textarea>
      </b-form-group>
      <div class="row justify-content-end pt-2 mr-1">
        <b-button variant="primary" to="/qna">목록</b-button>
        <b-button
          variant="primary"
          :to="{ name: 'modify', params: { no: this.$route.params.no } }"
          >수정</b-button
        >
        <b-button variant="primary" @click="deleteQnA">삭제</b-button>
      </div>
    </b-form>
  </div>
</template>

<script>
import { getQnA, deleteQnA } from "@/api/QnA";

export default {
  name: "QnADetail",

  data() {
    return {
      title: "",
      writer: "",
      regDate: "",
      contents: "",
    };
  },
  created() {
    getQnA(
      this.$route.params.no,
      (response) => {
        this.title = response.data.title;
        this.writer = response.data.writer;
        this.regDate = response.data.regDate;
        this.contents = response.data.contents;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  mounted() {},

  methods: {
    deleteQnA() {
      deleteQnA(this.$route.params.no, (response) => {
        console.log(response.data);
        this.$router.push("/qna");
      }),
        (error) => {
          console.log(error);
        };
    },
  },
};
</script>

<style>
.article {
  font-size: 1.2rem;
}
</style>
