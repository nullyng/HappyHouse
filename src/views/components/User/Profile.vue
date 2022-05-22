<template>
  <div class="profile-page">
    <section class="section-profile-cover section-shaped my-0">
      <div class="shape shape-style-1 shape-primary shape-skew alpha-4">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
      </div>
    </section>
    <section class="section section-skew">
      <div class="container">
        <card shadow class="card-profile mt--300" no-body>
          <div class="px-4">
            <div class="text-center mt-5">
              name
              <base-input
                v-model="name"
                v-bind="name"
                alternative
                class="mb-3"
                v-bind:placeholder="originName"
                addon-left-icon="ni ni-email-83"
              >
              </base-input>
              phone
              <base-input
                v-model="phone"
                v-bind="phone"
                alternative
                class="mb-3"
                v-bind:placeholder="originPhone"
                addon-left-icon="ni ni-email-83"
              >
              </base-input>
              address
              <base-input
                v-model="address"
                v-bind="address"
                alternative
                class="mb-3"
                v-bind:placeholder="originAddress"
                addon-left-icon="ni ni-email-83"
              >
              </base-input>
              pw
              <base-input
                v-model="pwd"
                v-bind="pwd"
                alternative
                class="mb-3"
                v-bind:placeholder="originPwd"
                addon-left-icon="ni ni-email-83"
              >
              </base-input>
              <div class="text-center">
                <base-button
                  v-on:click="updateUser()"
                  type="primary"
                  class="my-4"
                  >수정</base-button
                >
                <base-button
                  v-on:click="deleteUser()"
                  type="primary"
                  class="my-4"
                  >탈퇴</base-button
                >
              </div>
            </div>
          </div>
        </card>
      </div>
    </section>
  </div>
</template>
<script>
import { getData, updateUser, deleteUser } from "@/api/user.js";

export default {
  data() {
    return {
      id: null,
      name: null,
      phone: null,
      address: null,
      pwd: null,
      originName: null,
      originPhone: null,
      originAddress: null,
      originPwd: null,
    };
  },
  methods: {
    fetchData() {
      getData(
        (res) => {
          this.id = res.data.userId;
          this.name = res.data.userName;
          this.phone = res.data.userPhone;
          this.address = res.data.userAddress;
          this.pwd = res.data.userPwd;
          this.originName = res.data.userName;
          this.originPhone = res.data.userPhone;
          this.originAddress = res.data.userAddress;
          this.originPwd = res.data.userPwd;
        },
        (error) => {}
      );
    },
    updateUser() {
      let data = {
        name: this.name == "" ? this.originName : this.name,
        phone: this.phone == "" ? this.originPhone : this.phone,
        pwd: this.pwd == "" ? this.originPwd : this.pwd,
        address: this.address == "" ? this.originAddress : this.address,
      };
      console.log(data);
      updateUser(
        (res) => {
          console.log(res);
        },
        (error) => {}
      );
    },
    deleteUser() {
      deleteUser(
        (res) => {
          console.log(res);
        },
        (error) => {}
      );
    },
  },
  created() {
    this.fetchData();
  },
};
</script>
<style></style>
