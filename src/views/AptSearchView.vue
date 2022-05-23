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
              <div class="select-boxes">
                <div class="select-box col">
                  <h5>시/도</h5>
                  <select
                    id="sidoList"
                    class="form-select"
                    aria-label="시/도 선택"
                    v-model="sido"
                    @change="gugunList"
                  >
                    <option
                      v-for="item in sidos"
                      :value="item"
                      :key="item.code"
                    >
                      {{ item.name }}
                    </option>
                  </select>
                </div>
                <div class="select-box col">
                  <h5>구/군</h5>
                  <select
                    id="gugunList"
                    class="form-select"
                    aria-label="구/군 선택"
                    v-model="gugun"
                    @change="dongList"
                  >
                    <option
                      v-for="item in guguns"
                      :value="item"
                      :key="item.code"
                    >
                      {{ item.name }}
                    </option>
                  </select>
                </div>
                <div class="select-box col">
                  <h5>동</h5>
                  <select
                    id="dongList"
                    class="form-select"
                    aria-label="동 선택"
                    v-model="dong"
                  >
                    <option
                      v-for="item in dongs"
                      :value="item"
                      :key="item.code"
                    >
                      {{ item.name }}
                    </option>
                  </select>
                </div>
                <div class="btn-wrapper ml-2 mr-2">
                  <b-button
                    variant="primary"
                    @click="searchByAptNameAndDongName"
                  >
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
                <google-map
                  :aptlist="aptlist"
                  :lat="dong.lat"
                  :lng="dong.lng"
                ></google-map>
              </div>
              <div class="col aptlist p-3" v-if="fullName">
                <apt-list-item
                  v-for="item in aptlist"
                  :key="item.aptCode"
                  :param="item"
                ></apt-list-item>
              </div>
              <div class="col" v-else>
                지역을 선택하시면 아파트 목록이 표시됩니다.
              </div>
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
import AptListItem from "@/views/components/Apt/AptListItem.vue";
import {
  sidoList,
  gugunList,
  dongList,
  searchByAptNameAndDongName,
} from "@/api/house.js";

export default {
  components: {
    BaseDropdown: BaseDropdown,
    GoogleMap: GoogleMap,
    AptListItem: AptListItem,
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
        (err) => {}
      );
    },
    gugunList() {
      gugunList(
        this.sido.code + "*",
        (res) => {
          this.guguns = res.data;
          this.dongs = [];
        },
        (err) => {}
      );
    },
    dongList() {
      dongList(
        this.gugun.code + "*",
        (res) => {
          this.dongs = res.data;
        },
        (err) => {}
      );
    },
    searchByAptNameAndDongName() {
      searchByAptNameAndDongName(
        "",
        this.dong.name,
        (res) => {
          this.aptlist = res.data;
        },
        (err) => {}
      );
    },
  },
  computed: {
    // 시/도 + 구/군 + 동
    fullName: function () {
      let sidoName = this.sido.name === undefined ? " " : this.sido.name;
      let gugunName = this.gugun.name === undefined ? " " : this.gugun.name;
      let dongName = this.dong.name === undefined ? " " : this.dong.name;

      console.log(this.dong.lat, this.dong.lng);

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

.select-boxes {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
}

.select-box {
  text-align: center;
}

div.aptlist {
  overflow: auto;
  height: 600px;
}

div.aptlist::-webkit-scrollbar {
  width: 10px;
}

div.aptlist::-webkit-scrollbar-thumb {
  background-color: #5e72e4;
  border-radius: 10px;
  background-clip: padding-box;
  border: 2px solid transparent;
}

div.aptlist::-webkit-scrollbar-track {
  border-radius: 10px;
  width: 15px;
  background-color: rgba(172, 172, 172, 0.2);
}
</style>
