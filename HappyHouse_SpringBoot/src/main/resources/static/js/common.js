$(function () {
  $("#nav-item-login").on("click", function () {
	    $(location).attr('href','http://localhost:8080/loginPage');
  });
  $("#nav-item-logout").on("click", function () {
	  $(location).attr('href','http://localhost:8080/user/logout');
  });

  $("#nav-item-signup").on("click", function () {
	  $(location).attr('href','http://localhost:8080/signupPage');
  });

  $("#nav-item-userinfo").on("click", function () {
	  $(location).attr('href','http://localhost:8080/userinfoPage');
  });
});