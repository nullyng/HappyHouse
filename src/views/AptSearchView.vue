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
                <base-dropdown class="ml-2 mr-2">
                  <base-button
                    slot="title"
                    type="secondary"
                    class="dropdown-toggle"
                    style="width: 130%; font-size: large"
                  >
                    시/도
                  </base-button>
                  <a class="dropdown-item" href="#">대구특별시</a>
                  <a class="dropdown-item" href="#">서울광역시</a>
                  <a class="dropdown-item" href="#">제주도르도르</a>
                </base-dropdown>
                <base-dropdown class="ml-2 mr-2">
                  <base-button
                    slot="title"
                    type="secondary"
                    class="dropdown-toggle"
                    style="width: 130%; font-size: large"
                  >
                    구/군
                  </base-button>
                  <a class="dropdown-item" href="#">남구</a>
                  <a class="dropdown-item" href="#">동구</a>
                  <a class="dropdown-item" href="#">서구</a>
                </base-dropdown>
                <base-dropdown class="ml-2 mr-2">
                  <base-button
                    slot="title"
                    type="secondary"
                    class="dropdown-toggle"
                    style="width: 130%; font-size: large"
                  >
                    동
                  </base-button>
                  <a class="dropdown-item" href="#">대명동</a>
                  <a class="dropdown-item" href="#">봉덕동</a>
                  <a class="dropdown-item" href="#">이천농</a>
                </base-dropdown>
                <div class="btn-wrapper ml-2 mr-2">
                  <base-button
                    tag="a"
                    href=""
                    class="mb-3 mb-sm-0"
                    type="primary"
                    icon="ni ni-check-bold"
                    style="font-size: large"
                  >
                    검색하기
                  </base-button>
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
            <h3 style="font-weight: bold">서울특별시 종로구 숭인동</h3>
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
      // dropdown에 표시할 배열
      sidos: [],
      guguns: [],
      dongs: [],
      aptlist: [],
    };
  },
  created() {
    // 시/도, 구/군, 동 정보 가져오기
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
