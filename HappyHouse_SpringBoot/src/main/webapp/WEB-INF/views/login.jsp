<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="static/header.jsp" %>
<!DOCTYPE html>
<html lang="kor">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>로그인</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/happy-house.ico" />
    <!-- bootstrap 아이콘 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
  </head>

  <body id="page-top">
    <div class="main-content">
      <div class="main-content-signup">
        <div class="container">
          <!-- 로그인 영역 상단 -->
          <h2 class="page-section-heading text-left text-black-50 mb-0">로그인</h2>
        </div>
          <div class="row justify-content-center">
            <div class="col-lg-8 col-xl-7">
              <form id="contactForm" data-sb-form-api-token="API_TOKEN" method="post" action="main">
              	<input type="hidden" name="action" value="login">
                <!-- 아이디 입력-->
                <div class="form-floating mb-3">
                  <input name="userId" class="form-control" id="userid" type="text" placeholder="ID" data-sb-validations="required" />
                  <label for="userid" class="text-black-50">아이디</label>
                  <div class="invalid-feedback" data-sb-feedback="userid:required">아이디를 입력해주세요.</div>
                </div>
                <!-- 비밀번호 입력-->
                <div class="form-floating mb-3">
                  <input name="userPwd" class="form-control" id="password" type="password" placeholder="PWD" data-sb-validations="required" />
                  <label for="password" class="text-black-50">비밀번호</label>
                  <div class="invalid-feedback" data-sb-feedback="password:required">비밀번호를 입력해주세요.</div>
                </div>
                <!-- 등록 버튼-->
                <input id="registButton" class="submitButton" type="submit" value="로그인✓" />
              </form>
              <button onclick="location.href='findpwd.jsp'">비밀번호 찾기</button>
            </div>
            </div>
      </div>
    </div>
    <script src="/js/login.js"></script>
    <%@ include file="static/footer.jsp" %>
  </body>
</html>
