<template>
  <div class="container pt-lg-md border shadow p-5 mt-5 mb-5 bg-white">
    <b-form>
      <b-form-group id="title-group" class="mb-5">
        <label for="title" class="mb-1 label-size">제목</label>
        <b-form-input id="title" type="text" v-model="title" />
      </b-form-group>
      <b-form-group id="content-group" class="mb-4">
        <label for="content" class="mb-1 label-size">내용</label>
        <b-form-textarea
          id="content"
          rows="5"
          no-resize
          v-model="contents"
        ></b-form-textarea>
      </b-form-group>
      <div class="row justify-content-end pt-2 mr-1">
        <b-button variant="primary" to="/qna">목록</b-button>
        <b-button variant="primary" @click="createQnA">등록</b-button>
      </div>
    </b-form>
  </div>
</template>

<script>
import { createQnA } from "@/api/QnA";

export default {
  name: "QnAWrite",
  data() {
    return {
      title: "",
      contents: "",
    };
  },
  methods: {
    createQnA() {
      const item = {
        title: this.title,
        contents: this.contents,
      };
      // console.log(item);
      createQnA(
        item,
        (response) => {
          // console.log(response);
          this.$router.push("/qna");
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style>
.label-size {
  font-size: 1.1rem;
}
</style>
