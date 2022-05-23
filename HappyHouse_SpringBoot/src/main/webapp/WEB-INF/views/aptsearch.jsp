<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="static/header.jsp" %>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA39YxLmR6_kW3azA2XIBCV_gmZjZagDF0&callback=initMap" async></script>
    <script src="/js/aptsearch.js"/>
<!DOCTYPE html>
<html> 
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>주택 실거래가 정보 조회</title>
    <link rel="icon" type="image/x-icon" href="assets/happy-house.ico" />

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/aptsearch.js"></script>
  </head>
  <body>
  
    <!-- Masthead-->
    <section class="page-section bg-dark">
      <div class="container d-flex align-items-center flex-column" style="margin-top: 30px">
        <div class="row row-cols-auto">
          <button
            id="btnGroupDrop1"
            type="button"
            class="btn bg-white dropdown-toggle aptBtn"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            도/광역시
          </button>
          <ul
            id="do"
            class="dropdown-menu"
            aria-labelledby="btnGroupDrop1"
            style="max-height: 200px; overflow-y: scroll"
          >
            <li><a class="dropdown-item" href="#">도/광역시</a></li>
            <li><a class="dropdown-item" href="#">강원도</a></li>
            <li><a class="dropdown-item" href="#">경기도</a></li>
            <li><a class="dropdown-item" href="#">경상남도</a></li>
            <li><a class="dropdown-item" href="#">경상북도</a></li>
            <li><a class="dropdown-item" href="#">광주광역시</a></li>
            <li><a class="dropdown-item" href="#">대구광역시</a></li>
            <li><a class="dropdown-item" href="#">대전광역시</a></li>
            <li><a class="dropdown-item" href="#">부산광역시</a></li>
            <li><a class="dropdown-item" href="#">서울특별시</a></li>
            <li><a class="dropdown-item" href="#">세종특별차지시</a></li>
            <li><a class="dropdown-item" href="#">울산광역시</a></li>
            <li><a class="dropdown-item" href="#">인천광역시</a></li>
            <li><a class="dropdown-item" href="#">전라남도</a></li>
            <li><a class="dropdown-item" href="#">전라북도</a></li>
            <li><a class="dropdown-item" href="#">제주특별자치도</a></li>
            <li><a class="dropdown-item" href="#">충청남도</a></li>
            <li><a class="dropdown-item" href="#">충청북도</a></li>
          </ul>
          <button
            id="btnGroupDrop2"
            type="button"
            class="btn bg-white dropdown-toggle aptBtn"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            시/구/군
          </button>
          <ul
            id="gu"
            class="dropdown-menu"
            aria-labelledby="btnGroupDrop1"
            style="max-height: 200px; overflow-y: scroll"
          >
            <li><a class="dropdown-item" href="#">시/구/군</a></li>
          </ul>
          <button
            id="btnGroupDrop3"
            type="button"
            class="btn bg-white dropdown-toggle aptBtn"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            동
          </button>
          <ul
            id="dong"
            class="dropdown-menu"
            aria-labelledby="btnGroupDrop1"
            style="max-height: 200px; overflow-y: scroll"
          >
            <li><a class="dropdown-item" href="#">동</a></li>
          </ul>
          <button id="search-btn" type="button" class="submitButton bg-light">검색</button>
        </div>
        <div class="row cols-auto" style="margin-top: 10px">
          <input
            type="text"
            class="form-control form-control-sm"
            id="aptNameInput"
            placeholder="아파트 이름"
          />
        </div>
      </div>
    </section>
   
    <div class="search-result">
      <div class="content">
        <div class="content_left">
          <!-- 좌측 아파트 리스트 -->
          <button id="backBtn"><</button>
          <label id="info-apt-name"></label>
          <ul id="aptinfo" class="aptlist"></ul>
        </div>
        <div class="content_body">
          <!-- 우측 지도 넣을 자리 -->
          <div id="map" style="width: 100%; height: 100%"></div>
        </div>
      </div>
    </div>

    <!-- About Section-->
    <section class="page-section bg-white text-white mb-0">
      <div class="container">
        <div class="row row-cols-3 text-black">
          <div class="col">
            <h2>SSAFY 고지서 신청하고 포인트 받으세요!</h2>
            <h4 style="color: blue">#100만원 당첨 기회</h4>
            <h4 style="color: blue">#재산세 #주민세</h4>
          </div>
          <div class="col">
            <h2>지혜롭게 내집 마련하기</h2>
            <hr />
            <p>가용자금 확인 및 대출 계획</p>
            <p>집 종류 및 지역 선택</p>
            <p>정보 수집 & 시세파악</p>
            <p>부동산 방문 & 집구경</p>
            <p>계약 및 잔금 치르기</p>
            <p>소유권 이전등기</p>
            <p>인테리어 공사</p>
            <hr />
          </div>
          <div class="col">
            <h2>오늘의 뉴스</h2>
            <hr />
            <h6>서울 아파트 매매 전세 다른 양상...상승...아시아경제</h6>
            <ul>
              <li>
                <span style="color: blue">서울 입주 2년차 아파트 전셋값 1억400만원 올라</span>
                한겨레
              </li>
              <li>
                <span style="color: blue">1216 거래한파...매수자가 사라졌다</span> 아사아경제
              </li>
              <li>
                <span style="color: blue">재건축 대안 또는 수직증축 리모델링... 추진... </span
                >동아일보
              </li>
              <li>
                <span style="color: blue">고가기준 9억, 서울 아파트 중간값 됐다</span> 동아일보
              </li>
            </ul>
            <hr />
          </div>
        </div>
      </div>
    </section>
    <%@ include file="static/footer.jsp" %>
  </body>
</html>
