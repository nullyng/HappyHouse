$(document).ready(function () {
  // areaCode : 법정동 코드 5자리
  // aptDict : 아파트 중복을 저장하는 사전형식 데이터
  var areaCode;
  var aptDict;
  initMap();

  function init() {
    let sido;
    if (window.localStorage.getItem("sido") != null) {
      sido = window.localStorage.getItem("sido");
      $("#btnGroupDrop1").text(sido);
    }
    let gugun;
    if (window.localStorage.getItem("gugun") != null) {
      gugun = window.localStorage.getItem("gugun");
      $("#btnGroupDrop2").text(gugun);
    }
    let dong;
    if (window.localStorage.getItem("dong") != null) {
      dong = window.localStorage.getItem("dong");
      $("#btnGroupDrop3").text(dong);
    }
    $.ajax({
      url: "/data/법정동코드.json",
      dataType: "json",
      type: "get",
      success: function (json) {
        let dongList = [];
        for (var i = 0; i < json.length; i++) {
          if (json[i].city == sido && json[i].gu == gugun && json[i].dong == dong) {
            dongList.push(json[i].dong);
            areaCode = json[i].code.toString().substring(0, 5);
          }
        }
      },
      error: function (xhr, status, msg) {
        console.log("상태값 : " + status + " Http에러메시지 : " + msg);
      },
    });

    console.log($("#btnGroupDrop1").text());
    console.log($("#btnGroupDrop2").text());
    console.log($("#btnGroupDrop3").text());
  }

  init();
  // 시/도 선택할 때
  $("#do li > a").on("click", function () {
    // city : 도시이름
    let city = $(this).text();
    // 선택 안했을 때
    if (city == "도/광역시") {
      // 전부 초기화
      $("#btnGroupDrop1").text("도/광역시");
      $("#btnGroupDrop2").text("시/구/군");
      $("#btnGroupDrop3").text("동");
      $("#gu").empty().append(`<li><a class="dropdown-item" href="#">시/구/군</a></li>`);
    }
    // 선택 했을 때
    else {
      $("#btnGroupDrop1").text(city);
      $.ajax({
        url: "./data/행정구역.json",
        dataType: "json",
        type: "get",
        success: function (json) {
          // 시/구/군 추가함수
          makeGuList(json, city);
        },
        error: function (xhr, status, msg) {
          console.log("상태값 : " + status + " Http에러메시지 : " + msg);
        },
      });
    }
  });
  
  
  // 검색버튼 눌렀을 때
  $("#search-btn").click(function () {
    var ServiceKey =
      "SY0wwUOUgR+XvLXazywXmEeMbGvaGqsDrAIjvacheY12NY0tXxrGd/DONoLyIa2eV6y0SVI4zxfqZZRECk8wIw==";
    var pageNo = "1";
    var numOfRows = "20";
    var LAWD_CD = areaCode;
    var DEAL_YMD = "202002";
    // server에서 넘어온 data
    $.ajax({
      url: // servlet
        "http://localhost:8080/houseInfo?aptName=" +
        $("#aptNameInput").val() +
        "&" +
        "dongName=" +
        $("#btnGroupDrop3").text(),
      type: "GET",
      dataType: "json",
      success: function (response) {
        // 시/도만 선택 했거나 선택을 안했을 때는 skip
        if (
          $("#btnGroupDrop1").text().includes("도/광역시") ||
          $("#btnGroupDrop2").text().includes("시/구/군")
        ) {
          alert("지역을 선택해 주세요. (시/구/군까지)");
          return;
        }

        geocoder.geocode({ address: $("#btnGroupDrop2").text() }, function (result, status) {
          if (status == "OK") {
            console.log($("#btnGroupDrop2").text());
            map = new google.maps.Map(document.getElementById("map"), {
              center: result[0].geometry.location,
              zoom: 11,
            });
            new google.maps.Marker({ map, position: result[0].geometry.location });
          } else {
            console.log("cannot get locate");
          }
        });
        console.log($("#btnGroupDrop1").text());
        console.log($("#btnGroupDrop2").text());
        console.log($("#btnGroupDrop3").text());
        console.log(response);
        makeList(response);
      },
      error: function (xhr, status, msg) {
        console.log("상태값 : " + status + " Http에러메시지 : " + msg);
      },
    });
  });

  // 뒤로가기 버튼 눌렀을 때
  $("#backBtn").on("click", function () {
    $("#aptinfo").empty();
    $("#backBtn").css("display", "none");
    $("#info-apt-name").css("display", "none");

    for (let apt in aptDict) {
      $("#aptinfo").append(aptDict[apt][0]);
    }
    addAptOnClick();
  });

  // 아파트 거래정보 화면에 뿌리는 함수
  function makeList(data) {
	  // data = 
    var aptinfo = ``;
    aptDict = {};

    $("#aptinfo").empty();
    
    console.log(data)
    $.each(data, function (key, value) {
    	console.log(key)
    	console.log(value)
      let aptinfo = `<ul class="aptitem">
      <li name="aptName">${value.aptName}</li>
      <li>거래금액: ${value.dealAmount} 만원</li>
      <li>전용면적: ${value.area}m2</li>
      <li>법정동: ${value.dongName}</li>
      </ul>`;
      $("#aptinfo").append(aptinfo);

      geocoder.geocode(
        { address: value.dongName + " " + value.aptName },
        function (result, status) {
          console.log(value.dongName + " " + value.aptName);
          if (status == "OK") {
            new google.maps.Marker({ map, position: result[0].geometry.location });
          } else {
            console.log("cannot get locate");
          }
        }
      );
    });
  }

  // 시/구/군 추가함수
  function makeGuList(json, city) {
    let guList;
    // json에서 일치하는 시/도의 시/구/군 받음
    for (var i = 0; i < json.length; i++) {
      if (json[i].area == city) {
        guList = json[i].gu;
        break;
      }
    }
    let guMenu = $("#gu");
    guMenu.empty().append(`<li><a class="dropdown-item" href="#">시/구/군</a></li>`);

    // 받은 시/구/군 추가
    for (let gu of guList) {
      let item = `<li><a class="dropdown-item" href="#">${gu}</a></li>`;
      guMenu.append(item);
    }

    // 추가한 시/구/군에 click이벤트 정의
    guMenu.find("li > a").on("click", function () {
      guItemEvent($(this));
    });
  }

  // 선택한 시/구/군의 동정보 받아서 추가하는 함수
  function guItemEvent(data) {
    if (data.text() == "시/구/군") {
      $("#btnGroupDrop2").text("시/구/군");
      $("#btnGroupDrop3").text("동");
      $("#dong").empty().append(`<li><a class="dropdown-item" href="#">동</a></li>`);
    } else {
      $("#btnGroupDrop2").text(data.text());
      let city = $("#btnGroupDrop1").text();
      let gu = $("#btnGroupDrop2").text();
      $.ajax({
        url: "./data/법정동코드.json",
        dataType: "json",
        type: "get",
        success: function (json) {
          let dongList = [];
          for (var i = 0; i < json.length; i++) {
            if (json[i].city == city && json[i].gu == gu && json[i].dong != "") {
              dongList.push(json[i].dong);
              areaCode = json[i].code.toString().substring(0, 5);
            }
          }

          // 중복원소 제거
          dongList = new Set(dongList);

          let dongMenu = $("#dong");
          dongMenu.empty().append(`<li><a class="dropdown-item" href="#">동</a></li>`);

          for (let dong of dongList) {
            let item = `<li><a class="dropdown-item" href="#">${dong}</a></li>`;
            dongMenu.append(item);
          }
          dongMenu.find("li > a").on("click", function () {
            $("#btnGroupDrop3").text($(this).text());
          });
        },
        error: function (xhr, status, msg) {
          console.log("상태값 : " + status + " Http에러메시지 : " + msg);
        },
      });
    }
  }

  // 아파트 정보 리스트에서 아파트 이름클릭 이벤트 추가 함수
  function addAptOnClick() {
    $("#aptinfo ul > li:first-child").on("click", function () {
      $("#aptinfo").empty();
      $("#backBtn").css("display", "inline-block");
      $("#info-apt-name").css("display", "inline-block");

      for (let apt of aptDict[$(this).text()]) {
        $("#aptinfo").prepend(apt.replace(`<li name="aptName">${$(this).text()}</li>`, ``));
      }
      $("#info-apt-name").text(`${$(this).text()}`);
    });
  }
});

function initMap() {
  let seoul = { lat: 37.5642135, lng: 127.0016985 };
  map = new google.maps.Map(document.getElementById("map"), {
    center: seoul,
    zoom: 11,
  });

  geocoder = new google.maps.Geocoder();

  new google.maps.Marker({ map, position: seoul });

  geocoder.geocode({ address: window.localStorage.getItem("sido") }, function (result, status) {
    if (status == "OK") {
      map = new google.maps.Map(document.getElementById("map"), {
        center: result[0].geometry.location,
        zoom: 11,
      });
      console.log(result[0].geometry.location);
      new google.maps.Marker({ map, position: result[0].geometry.location });
    } else {
      console.log("cannot get locate");
    }
  });
}
