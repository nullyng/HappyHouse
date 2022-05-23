<template>
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
                <small>Sign in with credentials</small>
              </div>
              <form role="form">
                <base-input
                  v-model="id"
                  alternative
                  class="mb-3"
                  placeholder="ID"
                  addon-left-icon="ni ni-email-83"
                >
                </base-input>
                <base-input
                  v-model="pwd"
                  alternative
                  type="password"
                  placeholder="Password"
                  addon-left-icon="ni ni-lock-circle-open"
                >
                </base-input>
                <div class="text-center">
                  <!-- <base-button
                    v-on:click="fetchData"
                    type="primary"
                    class="my-4"
                    >Sign In</base-button
                  > -->
                  <b-button variant="primary" @click="fetchData">
                    Sign In
                  </b-button>
                </div>
              </form>
            </template>
          </card>
          <div class="row mt-3">
            <div class="col-6">
              <a href="#" class="text-light" @click="modals.modal0 = true">
                <small>Forgot password?</small>
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
                <small>Create new account</small>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import axios from "axios";
import Modal from "@/components/Modal.vue";
import { fetchData } from "@/api/user.js";

export default {
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
  methods: {
    fetchData() {
      fetchData(
        this.id,
        this.pwd,
        (res) => {
          axios.defaults.withCredentials = true;
          if(res.data.message === "success") {
            console.log(res);
            let token = res.data["access-token"];
            sessionStorage.setItem("access-token", token);
            this.$router.push("/");
          }
        },
        (error) => {}
      );
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
