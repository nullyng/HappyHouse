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
        <h1 style="font-weight: 700; color: white">QnA</h1>
      </div>
    </section>
    <router-view></router-view>
  </div>
</template>

<script>
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

export default {
  name: "QnAView",
};
</script>

<style lang="scss" scoped></style>
