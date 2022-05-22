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
        },
        {
          path: "modify/:no",
          name: "modify",
          component: () => import("@/views/components/QnA/QnAModify.vue"),
        },
      ],
    },
    // {
    //   path: "/",
    //   name: "home",
    //   components: {
    //     header: AppHeader,
    //     default: HomeView,
    //     footer: AppFooter,
    //   },
    // },
    // {
    //   path: "/qna",
    //   name: "qna",
    //   components: {
    //     header: AppHeader,
    //     default: QnAView,
    //     footer: AppFooter,
    //   },
    //   children: [
    //     {
    //       path: "list",
    //       name: "list",
    //       component: () => import("@/views/components/QnA/QnADetail.vue"),
    //     },
    //   ]
    // },
    // {
    //   path: "/login",
    //   name: "login",
    //   components: {
    //     header: AppHeader,
    //     default: LoginView,
    //     footer: AppFooter,
    //   },
    // },
    // {
    //   path: "/register",
    //   name: "register",
    //   components: {
    //     header: AppHeader,
    //     default: RegisterView,
    //     footer: AppFooter,
    //   },
    // },
    // {
    //   path: "/search",
    //   name: "search",
    //   components: {
    //     header: AppHeader,
    //     default: AptSearchView,
    //     footer: AppFooter,
    //   },
    // },
  ],
  scrollBehavior: (to) => {
    if (to.hash) {
      return { selector: to.hash };
    } else {
      return { x: 0, y: 0 };
    }
  },
});
