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
    <title>회원가입</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/happy-house.ico" />
    <!-- bootstrap 아이콘 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
  </head>

  <body id="page-top">

    <!-- 회원가입 화면 중앙 -->
    <div class="main-content">
      <div class="main-content-signup">
        <div class="container">
          <!-- 회원가입 영역 상단 -->
          <h2 class="page-section-heading text-left text-black-50 mb-0">회원 가입</h2>
          <!-- 회원가입 영역 폼 -->
          <div class="row justify-content-center">
            <div class="col-lg-8 col-xl-7">
              <form id="contactForm" data-sb-form-api-token="API_TOKEN" method="post" action="main">
              <input type="hidden" name="action" value="regist">
                <!-- 아이디 입력-->
                <div class="form-floating mb-3">
                  <input name="userId" class="form-control" id="userid" type="text" placeholder="ID" data-sb-validations="required" />
                  <label for="userid" class="text-black-50">아이디</label>
                  <div class="invalid-feedback" data-sb-feedback="userid:required">아이디를 입력해주세요.</div>
                </div>
                <!-- 비밀번호 입력-->
                <div class="form-floating mb-3">
                  <input name="userPwd" class="form-control" id="password" type="password" placeholder="영문 숫자 포함 6자리 이상" data-sb-validations="required" />
                  <label for="password" class="text-black-50">비밀번호</label>
                  <div class="invalid-feedback" data-sb-feedback="password:required">비밀번호를 입력해주세요.</div>
                </div>
                <!-- 이름 입력-->
                <div class="form-floating mb-3">
                  <input name="userName" class="form-control" id="name" type="text" placeholder="User name" data-sb-validations="required" />
                  <label for="name" class="text-black-50">이름</label>
                  <div class="invalid-feedback" data-sb-feedback="name:required">이름을 입력해주세요.</div>
                </div>
                <!-- 주소 입력-->
                <div class="form-floating mb-3">
                  <input name="userAddress" class="form-control" id="email" type="text" placeholder="address" data-sb-validations="required" />
                  <label for="email" class="text-black-50">메일주소</label>
                  <div class="invalid-feedback" data-sb-feedback="email:required">주소를 입력해주세요.</div>
                </div>
                <!-- 전화번호 입력-->
                <div class="form-floating mb-3">
                  <input name="userPhone" class="form-control" id="tel" type="tel" placeholder="010-xxx-xxxx" data-sb-validations="required" />
                  <label for="tel" class="text-black-50">전화번호(-제외)</label>
                  <div class="invalid-feedback" data-sb-feedback="tel:required">전화번호를 입력해주세요.</div>
                </div>
                <!-- 등록 버튼-->
                <input id="registButton" class="submitButton" type="submit" value="등록✓" />
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <%@ include file="static/footer.jsp" %>

  </body>
</html>
