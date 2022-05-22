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
                <small>Sign up with credentials</small>
              </div>
              <form role="form">
                <base-input
                  v-model="id"
                  alternative
                  class="mb-3"
                  placeholder="ID"
                  addon-left-icon="ni ni-hat-3"
                >
                </base-input>
                <base-input
                  v-model="name"
                  alternative
                  class="mb-3"
                  placeholder="Name"
                  addon-left-icon="ni ni-hat-3"
                >
                </base-input>
                <base-input
                  v-model="phone"
                  alternative
                  class="mb-3"
                  placeholder="Phone"
                  addon-left-icon="ni ni-email-83"
                >
                </base-input>
                <base-input
                  v-model="address"
                  alternative
                  class="mb-3"
                  placeholder="Address"
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
                  <base-button
                    v-on:click="fetchData()"
                    type="primary"
                    class="my-4"
                    >Create account</base-button
                  >
                </div>
              </form>
            </template>
          </card>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      id: null,
      name: null,
      phone: null,
      address: null,
      pwd: null,
    };
  },
  methods: {
    fetchData() {
      console.log(this.id);
      let temp = {
        userId: this.id,
        userName: this.name,
        userPhone: this.phone,
        userAddress: this.address,
        userPwd: this.pwd,
      };
      console.log(temp);
      axios
        .post("http://localhost:8080/user/regist", temp)
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created() {},
};
</script>
<style></style>
