<template>
  <section class="section-hero section-shaped my-0">
    <div class="shape shape-style-1 shape-primary" id="bg">
      <span class="span-150"></span>
      <span class="span-50"></span>
      <span class="span-50"></span>
      <span class="span-75"></span>
      <span class="span-100"></span>
      <span class="span-75"></span>
      <span class="span-50"></span>
      <span class="span-100"></span>
      <span class="span-50"></span>
      <span class="span-100"></span>
    </div>
    <div class="container shape-container d-flex align-items-center">
      <div class="col px-0">
        <div class="row justify-content-center align-items-center">
          <div class="col-lg-7 text-center pt-lg">
            <img
              src="img/logo/main_logo.png"
              style="width: 250px"
              class="img-fluid"
            />
            <p class="lead text-white mt-4 mb-5" style="font-size: x-large">
              환영합니다. :D <br />
              아파트 실거래 정보를 손쉽게 검색해보세요!
            </p>
            <div class="btn-wrapper">
              <base-button
                tag="a"
                href="/search"
                class="mb-3 mb-sm-0"
                type="info"
                icon="ni ni-favourite-28"
                style="font-size: x-large"
              >
                시작하기
              </base-button>
            </div>
            <div class="mt-3">
              <a href="/register" style="font-size: large"
                ><ins>회원가입 하고 시작하기</ins></a
              >
            </div>
          </div>
        </div>
        <div
          class="row align-items-center justify-content-around stars-and-coded"
        ></div>
      </div>
    </div>
  </section>
</template>
<script>
export default {
  name: "components",
  // created 실행 시점에는 컴포넌트, 템플릿, 렌더링된 DOM에 접근 불가능하므로 mounted에서 methods에 접근해야 함.
  mounted() {
    this.getRandom();
  },
  methods: {
    createImg(number) {
      // 랜덤으로 생성된 수를 바탕으로 wallpaper 랜덤으로 설정
      const bg = document.getElementById("bg");
      bg.style.backgroundImage =
        'url("img/wallpaper/wallpaper' + number + ".png";
      console.log(bg.style.backgroundImage);
      bg.style.backgroundSize = "cover";
    },
    getRandom() {
      // 이미지 개수
      const IMG_NUM = 16;
      // 1~이미지 개수 중 랜덤 숫자 만들기
      let num = Math.floor(Math.random() * IMG_NUM) + 1;
      // 이미지 생성함수 호출
      this.createImg(num);
    },
  },
};
</script>
<style scoped>
a {
  color: white;
}

a:hover {
  color: white;
}

a:visited {
  color: white;
}

a:link {
  color: white;
}

a:active {
  color: white;
}
</style>
