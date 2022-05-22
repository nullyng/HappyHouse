<template>
  <div id="app">
    <!-- <router-view name="header"></router-view> -->
    <app-header></app-header>
    <main id="wrapper">
      <fade-transition origin="center" mode="out-in" :duration="250">
        <router-view />
      </fade-transition>
    </main>
    <!-- <router-view name="footer"></router-view> -->
    <app-footer></app-footer>
  </div>
</template>
<script>
import { FadeTransition } from "vue2-transitions";
import AppHeader from "./layout/AppHeader.vue";
import AppFooter from "./layout/AppFooter.vue";

export default {
  components: {
    FadeTransition,
    AppHeader,
    AppFooter,
  },
};
</script>
<style>
#app {
  /* min-height: 100%;
  position: relative;
  padding-bottom: 60px; */
  min-height: 100vh;
  position: relative;
}

#wrapper {
  padding-bottom: 161px;
}
</style>
