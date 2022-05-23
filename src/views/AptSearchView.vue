<template>
  <div>
    <section class="section section-shaped section-lg my-0">
      <div class="shape shape-style-1 bg-gradient-default">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
      </div>
      <div class="container pt-lg-md">
        <div class="row justify-content-center">
          <div class="col-lg-10">
            <h1 class="mb-4" style="color: white; font-weight: bold">
              아파트 조회
            </h1>
            <card
              type="secondary"
              shadow
              header-classes="bg-white pb-5"
              body-classes="px-lg-5 py-lg-5"
              class="border-0"
              style="font-size: x-large"
            >
              <template>
                <div class="text-center text-muted mb-4">
                  <small>검색하고 싶은 지역을 선택하세요.</small>
                </div>
              </template>
              <div
                style="
                  display: flex;
                  justify-content: space-evenly;
                  flex-wrap: wrap;
                "
              >
                <select
                  id="sidoList"
                  class="form-select"
                  aria-label="시/도 선택"
                  v-model="sido"
                  @change="gugunList"
                >
                  <option v-for="item in sidos" :value="item" :key="item.code">
                    {{ item.name }}
                  </option>
                </select>
                <select
                  id="gugunList"
                  class="form-select"
                  aria-label="구/군 선택"
                  v-model="gugun"
                  @change="dongList"
                >
                  <option v-for="item in guguns" :value="item" :key="item.code">
                    {{ item.name }}
                  </option>
                </select>

                <select
                  id="dongList"
                  class="form-select"
                  aria-label="동 선택"
                  v-model="dong"
                >
                  <option v-for="item in dongs" :value="item" :key="item.code">
                    {{ item.name }}
                  </option>
                </select>

                <div class="btn-wrapper ml-2 mr-2">
                  <b-button variant="primary" @click="searchByDongName">
                    검색하기
                  </b-button>
                </div>
              </div>
            </card>
          </div>
        </div>
      </div>
    </section>
    <section class="m-5">
      <div class="container">
        <div class="row justify-content-center mt-md">
          <div class="col">
            <h3 style="font-weight: bold">{{ fullName }}</h3>
            <div class="row mt-4">
              <div class="col mt-lg-0">
                <google-map></google-map>
              </div>
              <div class="col aptlist"></div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import BaseDropdown from "@/components/BaseDropdown.vue";
import GoogleMap from "@/views/components/Apt/GoogleMap.vue";
import { sidoList, gugunList, dongList } from "@/api/house.js";

export default {
  components: {
    BaseDropdown: BaseDropdown,
    GoogleMap: GoogleMap,
  },
  data() {
    return {
      // 현재 선택한 위치
      sido: "",
      gugun: "",
      dong: "",
      sidos: [],
      guguns: [],
      dongs: [],
      aptlist: [],
    };
  },
  methods: {
    sidoList() {
      sidoList(
        (res) => {
          this.sidos = res.data;
        },
        (err) => {
          console.log(err);
        }
      );
    },
    gugunList() {
      gugunList(
        this.sido.code + "*",
        (res) => {
          this.guguns = res.data;
        },
        (err) => {
          console.log("에러" + err);
        }
      );
    },
    dongList() {
      dongList(
        this.gugun.code + "*",
        (res) => {
          this.dongs = res.data;
        },
        (err) => {
          console.log(err);
        }
      );
    },
    searchByDongName() {},
  },
  computed: {
    // 시/도 + 구/군 + 동
    fullName: function () {
      let sidoName = this.sido.name === undefined ? " " : this.sido.name;
      let gugunName = this.gugun.name === undefined ? " " : this.gugun.name;
      let dongName = this.dong.name === undefined ? " " : this.dong.name;
      return sidoName + " " + gugunName + " " + dongName;
    },
  },
  created() {
    // 시/도, 구/군, 동 정보 가져오기
    this.sidoList();
  },
};
</script>
<style scoped>
@media (min-width: 1300px) {
  .container {
    max-width: 1280px;
  }
}

div.aptlist {
  border: 1px solid #5e72e4;
  border-radius: 1rem;
}
</style>
