$(function () {
  $(".btn-findpwd").on("click", function () {
    window.opener.location.replace("./findpwd.jsp");
    window.close();
  });
});
