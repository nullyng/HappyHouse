<template>
  <div>
    <section class="section section-shaped my-0" style="padding-bottom: 2rem">
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
      <div class="container mb-0">
        <h1 style="font-weight: 700; color: white">로그인</h1>
      </div>
    </section>
    <div class="container pt-lg-md">
      <div class="row justify-content-center">
        <div class="col-lg-5">
          <card
            type="secondary"
            shadow
            header-classes="bg-white pb-5"
            body-classes="px-lg-5 py-lg-5"
            class="border-0"
          >
            <template>
              <div class="text-center text-muted mb-4">
                <small>서비스를 이용하려면 로그인 하세요.</small>
              </div>
              <form role="form">
                <base-input
                  v-model="id"
                  alternative
                  class="mb-3"
                  placeholder="아이디"
                  addon-left-icon="ni ni-email-83"
                >
                </base-input>
                <base-input
                  v-model="pwd"
                  alternative
                  type="password"
                  placeholder="비밀번호"
                  addon-left-icon="ni ni-lock-circle-open"
                >
                </base-input>
                <div class="text-center mt-4">
                  <!-- <base-button
                    v-on:click="fetchData"
                    type="primary"
                    class="my-4"
                    >Sign In</base-button
                  > -->
                  <b-button
                    variant="primary"
                    style="font-size: large"
                    @click="confirm"
                  >
                    로그인
                  </b-button>
                </div>
              </form>
            </template>
          </card>
          <div class="row mt-3">
            <div class="col-6">
              <a href="#" class="text-light" @click="modals.modal0 = true">
                <small>비밀번호를 잊으셨나요?</small>
              </a>
              <div>
                <modal :show.sync="modals.modal0">
                  <template slot="header">
                    <h5 class="modal-title" id="exampleModalLabel">
                      Modal title
                    </h5>
                  </template>
                  <div>
                    <base-input
                      v-model="findpwd_id"
                      alternative
                      class="mb-3"
                      placeholder="ID"
                      addon-left-icon="ni ni-email-83"
                    >
                    </base-input>
                    <base-input
                      v-model="findpwd_name"
                      alternative
                      class="mb-3"
                      placeholder="name"
                      addon-left-icon="ni ni-email-83"
                    >
                    </base-input>
                    <base-input
                      v-model="findpwd_phone"
                      alternative
                      class="mb-3"
                      placeholder="phone"
                      addon-left-icon="ni ni-email-83"
                    >
                    </base-input>
                  </div>
                  <template slot="footer">
                    <base-button type="secondary" @click="modals.modal0 = false"
                      >Close</base-button
                    >
                    <base-button v-on:click="findPwd()" type="primary"
                      >FIND PWD</base-button
                    >
                  </template>
                </modal>
              </div>
            </div>
            <div class="col-6 text-right">
              <a href="/register" class="text-light">
                <small>새 계정 만들기</small>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import Modal from "@/components/Modal.vue";
import { fetchData } from "@/api/user.js";
import { mapState, mapActions } from "vuex";

const userStore = "userStore";

export default {
  name: "LoginView",
  components: {
    Modal,
  },
  data() {
    return {
      id: null,
      pwd: null,
      modals: {
        modal0: false,
      },
      findpwd_id: null,
      findpwd_name: null,
      findpwd_phone: null,
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    ...mapActions(userStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      const user = {
        id: this.id,
        pwd: this.pwd,
      };
      await this.userConfirm(user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "home" });
      }
    },

    findPwd() {
      axios
        .get(
          `http://localhost:9999/user/findpassword?id=${this.findpwd_id}&name=${this.findpwd_name}&phone=${this.findpwd_phone}`
        )
        .then((res) => {
          // console.log(res)
          alert(`비밀번호는 ${res.data} 입니다.`);
        })
        .catch((err) => {
          console.log(err);
          alert(err.response.data);
        });
    },
  },
  created() {},
};
</script>
<style></style>
