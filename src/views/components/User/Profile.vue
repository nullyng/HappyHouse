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
      <div class="container col-lg-5">
        <card shadow class="card-profile mt--300" no-body>
          <div class="px-5">
            <h1 class="mt-5" style="font-weight: 700">내 정보</h1>
            <div class="mt-5">
              <strong>이름</strong>
              <base-input
                v-model="name"
                alternative
                class="mb-4"
                v-bind:placeholder="originName"
                addon-left-icon="ni ni-circle-08"
              >
              </base-input>
              <strong>전화번호</strong>
              <base-input
                v-model="phone"
                alternative
                class="mb-4"
                v-bind:placeholder="originPhone"
                addon-left-icon="ni ni-mobile-button"
              >
              </base-input>
              <strong>이메일</strong>
              <base-input
                v-model="address"
                alternative
                class="mb-4"
                v-bind:placeholder="originAddress"
                addon-left-icon="ni ni-email-83"
              >
              </base-input>
              <strong>비밀번호</strong>
              <base-input
                v-model="pwd"
                alternative
                class="mb-4"
                v-bind:placeholder="originPwd"
                addon-left-icon="ni ni-lock-circle-open"
              >
              </base-input>
              <div class="text-center">
                <base-button
                  v-on:click="updateUser(), (modals.modal0 = true)"
                  type="primary"
                  class="my-4"
                  >수정</base-button
                >

                <base-button
                  v-on:click="deleteUser(), (modals.modal1 = true)"
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
    <div>
      <modal :show.sync="modals.modal0">
        <div>수정이 완료되었습니다.</div>
        <template slot="footer">
          <b-button type="secondary" @click="modals.modal0 = false"
            >닫기</b-button
          >
        </template>
      </modal>
    </div>
    <div>
      <modal :show.sync="modals.modal1">
        <div>탈퇴가 완료되었습니다.</div>
        <template slot="footer">
          <b-button type="secondary" @click="closeModal1">닫기</b-button>
        </template>
      </modal>
    </div>
  </div>
</template>
<script>
import { getData, updateUser, deleteUser } from "@/api/user.js";
import Modal from "@/components/Modal.vue";

export default {
  components: {
    Modal,
  },
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
      modals: {
        modal0: false,
        modal1: false,
      },
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
        data,
        (res) => {
          // console.log(res);
        },
        (error) => {}
      );
    },
    deleteUser() {
      deleteUser(
        (res) => {
          // console.log(res);
        },
        (error) => {}
      );
    },
    closeModal1() {
      this.modals.modal1 = false;
      sessionStorage.removeItem("access-token");
      this.$router.push("/");
    },
  },
  created() {
    this.fetchData();
  },
};
</script>
<style></style>
