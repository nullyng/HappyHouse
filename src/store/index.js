import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

import userStore from "./modules/userStore";
import commentStore from "./modules/commentStore";

Vue.use(Vuex);

export default new Vuex.Store({
  name: "store",
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    userStore,
    commentStore,
  },
  plugins: [
    createPersistedState({
      // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
      storage: sessionStorage,
    }),
  ],
});
