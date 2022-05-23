<template>
  <header class="header-global">
    <base-nav class="navbar-main" transparent type="" effect="light" expand>
      <router-link slot="brand" to="/">
        <img src="@/assets/logo3.png" alt="logo" width="220" />
      </router-link>

      <div class="row" slot="content-header" slot-scope="{ closeMenu }">
        <div class="col-6 collapse-brand">
          <a
            href="https://demos.creative-tim.com/vue-argon-design-system/documentation/"
          >
            <img src="img/logo/logo_primary.png" />
          </a>
        </div>
        <div class="col-6 collapse-close">
          <close-button @click="closeMenu"></close-button>
        </div>
      </div>
      <ul class="navbar-nav ml-lg-auto">
        <li class="nav-item" v-if="!userInfo">
          <a class="nav-link nav-link-icon font-weight-bold" href="/user/login">
            로그인
          </a>
        </li>
        <li class="nav-item" v-if="!userInfo">
          <a
            class="nav-link nav-link-icon font-weight-bold"
            href="/user/register"
          >
            회원가입
          </a>
        </li>
        <li class="nav-item" v-if="userInfo" @click.prevent="onLogout">
          <a class="nav-link nav-link-icon font-weight-bold" href="/">
            로그아웃
          </a>
        </li>
        <li class="nav-item" v-if="userInfo">
          <a
            class="nav-link nav-link-icon font-weight-bold"
            href="/user/register"
          >
            내정보
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link nav-link-icon font-weight-bold" href="/search">
            아파트조회
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link nav-link-icon font-weight-bold" href="/qna">
            QnA
          </a>
        </li>
      </ul>
    </base-nav>
  </header>
</template>
<script>
import BaseNav from "@/components/BaseNav";
import BaseDropdown from "@/components/BaseDropdown";
import CloseButton from "@/components/CloseButton";
import { mapActions, mapState, mapMutations } from "vuex";

const userStore = "userStore";

export default {
  name: "AppHeader",
  components: {
    BaseNav,
    CloseButton,
    BaseDropdown,
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(userStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    ...mapActions(userStore, ["logout"]),
    onLogout() {
      this.logout();
      // this.SET_IS_LOGIN(false);
      this.SET_USER_INFO(null);
      sessionStorage.removeItem("access-token");
      if (this.$route.path != "/") this.$router.push({ name: "home" });
    },
  },
};
</script>
<style></style>
