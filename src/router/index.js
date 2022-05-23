// export default router;
import Vue from "vue";
import Router from "vue-router";
// import AppHeader from "@/layout/AppHeader";
// import AppFooter from "@/layout/AppFooter";
import HomeView from "@/views/HomeView.vue";
import QnAView from "@/views/QnAView.vue";
// import LoginView from "@/views/LoginView.vue";
// import RegisterView from "@/views/RegisterView.vue";
// import AptSearchView from "@/views/AptSearchView.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  linkExactActiveClass: "active",
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/user",
      name: "user",
      component: () => import("@/views/UserView.vue"),
      redirect: "user/login",
      children: [
        {
          path: "login",
          name: "login",
          component: () => import("@/views/components/User/LoginView.vue"),
        },
        {
          path: "register",
          name: "register",
          component: () => import("@/views/components/User/Register.vue"),
        },
        {
          path: "profile",
          name: "profile",
          component: () => import("@/views/components/User/Profile.vue"),
          beforeEnter: function(to, from, next) {
            let token = sessionStorage.getItem("access-token");
            if (token == null) {
              alert("로그인이 필요합니다.");
              next("/user");
            } else {
              next();
            }
          },
        },
      ],
    },
    {
      path: "/search",
      name: "search",
      component: () => import("@/views/AptSearchView.vue"),
    },
    {
      path: "/qna",
      name: "qna",
      component: QnAView,
      redirect: "/qna/list",
      children: [
        {
          path: "list",
          name: "list",
          component: () => import("@/views/components/QnA/QnAList.vue"),
        },
        {
          path: "detail/:no",
          name: "detail",
          component: () => import("@/views/components/QnA/QnADetail.vue"),
        },
        {
          path: "write",
          name: "write",
          component: () => import("@/views/components/QnA/QnAWrite.vue"),
          beforeEnter: function(to, from, next) {
            let token = sessionStorage.getItem("access-token");
            if (token == null) {
              alert("로그인이 필요합니다.");
              next("/user");
            } else {
              next();
            }
          },
        },
        {
          path: "modify/:no",
          name: "modify",
          component: () => import("@/views/components/QnA/QnAModify.vue"),
          beforeEnter: function(to, from, next) {
            let token = sessionStorage.getItem("access-token");
            if (token == null) {
              alert("로그인이 필요합니다.");
              next("/user");
            } else {
              next();
            }
          },
        },
      ],
    },
  ],
  scrollBehavior: (to) => {
    if (to.hash) {
      return { selector: to.hash };
    } else {
      return { x: 0, y: 0 };
    }
  },
});
