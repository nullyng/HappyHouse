<template>
  <div class="container pt-lg-md">
    <form role="form">
      <b-row class="justify-content-md-center mb-5">
        <b-col cols="2">
          <!-- <base-radio inline name="radio0" class="mb-3" v-model="radio.radio1">
            제목
          </base-radio>
          <base-radio inline name="radio1" class="mb-3" v-model="radio.radio1">
            내용
          </base-radio>
          <base-radio inline name="radio2" class="mb-3" v-model="radio.radio1">
            작성자
          </base-radio> -->
          <b-form-select v-model="selected" :options="options"> </b-form-select>
        </b-col>
        <b-col cols="6">
          <b-form-input
            v-model="searchContents"
            placeholder="검색어를 입력하세요"
          ></b-form-input>
        </b-col>
        <b-col cols="1">
          <!-- <div class="text-center">
            <base-button v-on:click="fetchData()" type="primary" class="my-4"
              >Search</base-button
            >
          </div> -->
          <b-button variant="primary" @click="fetchData">검색</b-button>
        </b-col>
        <!-- <base-input
          v-model="searchContents"
          alternative
          class="mb-3"
          addon-left-icon="ni ni-compass-04"
        >
        </base-input> -->
      </b-row>
    </form>
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
import BaseRadio from "@/components/BaseRadio.vue";
import {
  listQnA,
  getQnAByWriter,
  getQnAByContents,
  getQnAByTitle,
} from "@/api/QnA";

export default {
  name: "QnAList",
  components: { BasePagination, BaseRadio },
  data() {
    return {
      searchContents: null,
      currentPage: 1,
      perPage: 3,
      radio: {
        radio1: null,
      },
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
      selected: null,
      options: [
        { value: null, text: "선택하세요" },
        { value: "title", text: "제목" },
        { value: "contents", text: "내용" },
        { value: "writer", text: "작성자" },
      ],
    };
  },

  created() {
    listQnA(
      (response) => {
        console.log(response);
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
    fetchData() {
      switch (this.selected) {
        case "title":
          getQnAByTitle(
            this.searchContents,
            (response) => {
              console.log(response);
              this.items = response.data;
            },
            (error) => {
              console.log(error);
            }
          );
          break;
        case "contents":
          getQnAByContents(
            this.searchContents,
            (response) => {
              console.log(response);
              this.items = response.data;
            },
            (error) => {
              console.log(error);
            }
          );
          break;
        case "writer":
          getQnAByWriter(
            this.searchContents,
            (response) => {
              console.log(response);
              this.items = response.data;
            },
            (error) => {
              console.log(error);
            }
          );
          break;
      }
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
