<template>
  <div class="container pt-lg-md">
    <div class="row justify-content-center">
      <b-table
        id="qnaList"
        class="shadow p-5 mb-5 bg-white"
        :items="items"
        :fields="fields"
        head-variant="light"
        selectable
        select-mode="single"
        @row-selected="onRowSelected"
      >
        <!-- <template #cell(title)="data">
          <router-link :to="{ name: 'detail', params: { no: data.index } }">{{
            data.value
          }}</router-link>
        </template> -->
      </b-table>
      <!-- <b-pagination
          v-model="currentPage"
          :total-rows="rows"
          :per-page="perPage"
          aria-controls="qnaList"
        ></b-pagination> -->
    </div>
    <div class="d-flex flex-row-reverse mb-5">
      <b-button variant="primary" to="/qna/write">글작성</b-button>
    </div>
    <!-- <b-container>
      {{ selected }}
    </b-container> -->
  </div>
</template>

<script>
import BasePagination from "@/components/BasePagination.vue";
import { listQnA } from "@/api/QnA";

export default {
  name: "QnAList",
  components: { BasePagination },
  data() {
    return {
      currentPage: 1,
      perPage: 3,
      fields: [
        {
          key: "regDate",
          label: "작성날짜",
        },
        {
          key: "title",
          label: "제목",
        },
        {
          key: "writer",
          label: "작성자",
        },
      ],
      items: [],
      selected: [],
    };
  },

  created() {
    listQnA(
      (response) => {
        this.items = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },

  methods: {
    onRowSelected(items) {
      // console.log(items[0]);
      this.$router.push("/qna/detail/" + items[0].id);
    },
  },
  computed: {
    rows() {
      return this.items.length;
    },
  },
};
</script>

<style></style>
