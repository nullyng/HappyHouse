<template>
  <div class="container pt-lg-md border shadow p-5 mt-5 mb-5 bg-white">
    <b-form>
      <b-form-group id="title-group" class="mb-5">
        <label for="title" class="mb-1 label-size">제목</label>
        <b-form-input id="title" type="text" v-model="item.title" />
      </b-form-group>
      <b-form-group id="content-group" class="mb-4">
        <label for="content" class="mb-1 label-size">내용</label>
        <b-form-textarea
          id="content"
          rows="5"
          v-model="item.contents"
          no-resize
        ></b-form-textarea>
      </b-form-group>
      <div class="row justify-content-end pt-2 mr-1">
        <b-button variant="primary" to="/qna">목록</b-button>
        <b-button variant="primary" @click="updateQnA">등록</b-button>
      </div>
    </b-form>
  </div>
</template>

<script>
import { getQnA, updateQnA } from "@/api/QnA";

export default {
  name: "QnAModify",
  data() {
    return {
      item: {},
    };
  },
  created() {
    getQnA(this.$route.params.no, (response) => {
      console.log(response);
      this.item = response.data;
    });
  },
  methods: {
    updateQnA() {
      updateQnA(
        this.item,
        (response) => {
          //console.log(response);
          this.$router.push("/qna");
        },
        (error) => {
          console.log(response);
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
