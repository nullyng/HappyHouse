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
    <title>HappyHouse</title>
    
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/happy-house.ico" />

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/js/scripts.js"></script>
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    
    <!-- Core theme CSS (includes Bootstrap)-->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css"
    />
    <link href="css/styles.css" rel="stylesheet" />
  </head>

    <header
      class="masthead bg-black text-white text-center"
      style="
        background-image: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
          url('img/homesweethome.png');
        background-size: cover;
      "
    >
      <div class="container d-flex align-items-center flex-column">
        <h1 class="text-uppercase mb-0">HAPPY HOUSE</h1>
        <h5 class="text-uppercase mb-0">행복한 우리 집</h5>
      </div>
    </header>

    <section class="page-section bg-dark">
      <div class="container">
        <div class="container d-flex align-items-center flex-column">
          <div class="row row-cols-auto gx-2">
            <div class="col">
              <select name="sido" id="sido" class="form-select" aria-label="sido"></select>
            </div>
            <div class="col">
              <select name="gugun" id="gugun" class="form-select" aria-label="gugun">
                <option value="">시/구/군</option>
              </select>
            </div>
            <div class="col">
              <select name="dong" id="dong" class="form-select" aria-label="dong">
                <option value="">동</option>
              </select>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Portfolio Section-->
    <section class="page-section">
      <div class="container vw-100 vh-100">
        <!-- Portfolio Section Heading-->
        <!-- <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">Map</h2> -->
        <div id="map" style="width: 100%; height: 100%"></div>
      </div>
    </section>

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

    <script src="/js/common.js"></script>
    <script>
      let url = "https://grpc-proxy-server-mkvo6j4wsq-du.a.run.app/v1/regcodes";
      let regcode = "*00000000";
      let map;
      let geocoder;
      $(document).ready(function () {
        $.ajax({
          url: url,
          type: "GET",
          data: {
            regcode_pattern: regcode,
          },
          dataType: "json",
          success: function (response) {
            let code = ``;
            console.log(response)
            $.each(response.regcodes, function (i, regcode) {
            	console.log(regcode.code)
            	console.log(regcode.name)
              code += '<option value=' + regcode.code + '>' + regcode.name + '</option>';
            });
            $("#sido").empty().append('<option value="">도/광역시</option>').append(code);
          },
          error: function (xhr, status, msg) {
            console.log("상태값 : " + status + " Http에러메시지 : " + msg);
          },
        });
      });

      $(document).on("change", "#sido", function (e) {
        regcode = $(this).val().substr(0, 2) + "*00000";
        $.ajax({
          url: url,
          type: "GET",
          data: {
            regcode_pattern: regcode,
            is_ignore_zero: true,
          },
          dataType: "json",
          success: function (response) {
            window.localStorage.setItem("sido", $("#sido option:selected").text());
            geocoder.geocode(
              { address: $("#sido option:selected").text() },
              function (result, status) {
                if (status == "OK") {
                  map = new google.maps.Map(document.getElementById("map"), {
                    center: result[0].geometry.location,
                    zoom: 11,
                  });
                  new google.maps.Marker({ map, position: result[0].geometry.location });
                } else {
                  console.log("cannot get locate");
                }
              }
            );

            let code = ``;
            $.each(response.regcodes, function (i, regcode) {
              code += '<option value=' + regcode.code + ">" + regcode.name.split(" ")[1] + '</option>';
              geocoder.geocode(
                { address: $("#sido option:selected").text() + regcode.name.split(" ")[1] },
                function (result, status) {
                  if (status == "OK") {
                    $("#map").ready(() => {
                      new google.maps.Marker({ map, position: result[0].geometry.location });
                      console.log("create Marker at " + regcode.name.split(" ")[1]);
                    });
                  } else {
                    console.log("cannot create Marker at " + result[0].geometry.location);
                  }
                }
              );
            });
            $("#gugun").empty().append('<option value="">시/구/군</option>').append(code);
          },
          error: function (xhr, status, msg) {
            console.log("상태값 : " + status + " Http에러메시지 : " + msg);
          },
        });
      });

      $(document).on("change", "#gugun", function () {
        regcode = $(this).val().substr(0, 4) + "*";
        $.ajax({
          url: url,
          type: "GET",
          data: {
            regcode_pattern: regcode,
            is_ignore_zero: true,
          },
          dataType: "json",
          success: function (response) {
            window.localStorage.setItem("gugun", $("#gugun option:selected").text());
            let code = ``;
            $.each(response.regcodes, function (i, regcode) {
              code += '<option value=' + regcode.code + ">" + regcode.name.split(" ")[2] +'</option>';
            });
            $("#dong").empty().append('<option value="">동</option>').append(code);
          },
          error: function (xhr, status, msg) {
            console.log("상태값 : " + status + " Http에러메시지 : " + msg);
          },
        });
      });

      $(document).on("change", "#dong", function () {
        window.localStorage.setItem("dong", $("#dong option:selected").text());
        console.log($("#dong option:selected").text());
        location.href = "aptsearch";
      });

      function initMap() {
        let seoul = { lat: 37.5642135, lng: 127.0016985 };
        map = new google.maps.Map(document.getElementById("map"), {
          center: seoul,
          zoom: 11,
        });

        geocoder = new google.maps.Geocoder();

        new google.maps.Marker({ map, position: seoul });
      }
    </script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA39YxLmR6_kW3azA2XIBCV_gmZjZagDF0&callback=initMap" async></script>
  </body>
</html>
