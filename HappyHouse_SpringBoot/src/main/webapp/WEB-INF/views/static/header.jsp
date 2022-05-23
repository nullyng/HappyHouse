<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	    <script
      src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
      crossorigin="anonymous"
    ></script>
    <link href="css/styles.css" rel="stylesheet" />
    <link href="css/aptsearch.css" rel="stylesheet" />
    <script src="js/scripts.js"></script>
    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
	<style>
 		 body, h1, h2, h3, h4, h5, h6, p, span {
    		font-family: 'Gowun Dodum'!important;
  			}
	</style>

    <!-- 상단 네비-->
    <nav class="navbar navbar-expand-lg bg-light text-uppercase fixed-top" id="mainNav">
      <div class="container">
        <div class="position-absolute top-0 start-0 bg-dark w-100 h-25">
          <div
            class="position-absolute top-0 end-0 btn-group h-100"
            role="group"
            aria-label="Basic example"
          >
          	<c:if test="${empty loginUser }">
            <button
              id="nav-item-signup"
              type="button"
              class="btn btn-sm btn-dark h-100 text-sm-start"
            >
              <i class="bi bi-person-fill"></i>Sign Up
            </button>
            <button
              id="nav-item-login"
              type="button"
              class="btn btn-sm btn-dark h-100 text-sm-start"
            >
              <i class="bi bi-lock-fill"></i>Login
            </button>
            </c:if>
           <c:if test="${!empty loginUser }">
            <button
              id="nav-item-logout"
              type="button"
              class="btn btn-sm btn-dark h-100 text-sm-start"
            >
              <i class="bi bi-unlock-fill"></i>Logout
            </button>
            <button
              id="nav-item-userinfo"
              type="button"
              class="btn btn-sm btn-dark h-100 text-sm-start"
            >
              <i class="bi bi-person-fill"></i>회원정보
            </button>
            </c:if>
            
            
          </div>
        </div>
        
        <a class="navbar-brand text-black" href="./index.jsp">행복한집</a>
        <button
          class="navbar-toggler text-uppercase font-weight-bold bg-secondary text-white rounded"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarResponsive"
          aria-controls="navbarResponsive"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ms-auto">
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded text-black" href="#">공지사항</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded text-black" href="#">오늘의 뉴스</a>
            </li>
            <li id="exploreSurroud" class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded text-black" href="#">주변 탐방</a>
            </li>
            <li id="setInterestArea" class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded text-black" href="#">관심 지역 설정</a>
            </li>
            <li id="exploreInterestArea" class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded text-black" href="#"
                >관심 지역 둘러보기</a
              >
            </li>

            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded text-black" href="#"
                ><i class="bi bi-search"></i
              ></a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
        <script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>