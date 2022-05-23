<template>
  <div class="container pt-lg-md">
    <div class="row justify-content-center">
      <form role="form">
        
        <base-input v-model="searchContents"
                    alternative
                    class="mb-3"
                    addon-left-icon="ni ni-compass-04">
        </base-input>
        <base-radio inline name="radio0" class="mb-3" v-model="radio.radio1">
            제목
        </base-radio>
        <base-radio inline name="radio1" class="mb-3" v-model="radio.radio1">
            내용
        </base-radio>
        <base-radio inline name="radio2" class="mb-3" v-model="radio.radio1">
            작성자
        </base-radio>
        <div class="text-center">
          <base-button v-on:click="fetchData()" type="primary" class="my-4">Search</base-button>
        </div>
      </form>
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
import BaseRadio from "@/components/BaseRadio.vue"
import { listQnA, getQnAByWriter, getQnAByContents, getQnAByTitle } from "@/api/QnA";

export default {
  name: "QnAList",
  components: { BasePagination, BaseRadio },
  data() {
    return {
      searchContents: null,
      currentPage: 1,
      perPage: 3,
      radio:{
        radio1: null
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
      selected: [],
    };
  },

  created() {
    listQnA(
      (response) => {
        console.log(response)
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
    fetchData(){
      switch(this.radio.radio1){
        case "radio0" :
          getQnAByTitle(this.searchContents,
            (response) => {
              console.log(response)
              this.items = response.data
            },
            (error) => {
              console.log(error)
            })
          break
        case "radio1" :
          getQnAByContents(this.searchContents,
            (response) => {
              console.log(response)
              this.items = response.data
            },
            (error) => {
              console.log(error)
          })
          break
        case "radio2" :
          getQnAByWriter(this.searchContents,
          (response) => {
            console.log(response)
            this.items = response.data
          },
          (error) => {
            console.log(error)
          })
          break
      }
    }
  },
  computed: {
    rows() {
      return this.items.length;
    },
  },
};
</script>

<style></style>
