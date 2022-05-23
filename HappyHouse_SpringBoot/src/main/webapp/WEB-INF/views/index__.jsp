<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
#title {
	text-align: center;
}

#user-info {
	text-align: right;
}
</style>
</head>
<body>

<h1 id="title">로그인/로그아웃/세션</h1>
<div id="user-info">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<%--로그인 정보가 없을 경우는 로그인을 위한 폼을 제공한다. --%>
	<c:if test="${empty loginUser }">
		<form method="post" action="main">
			<input type="hidden" name="action" value="login">
			<input type="text" name="userId" placeholder="아이디">
			<input type="password" name="userPwd" placeholder="비밀번호">
			<input type="submit" value="로그인">
		</form>
	</c:if>
	<%--로그인 정보가 있는 경우는 사용자 이름과 로그아웃을 위한 링크를 생성한다.--%>
	<%--회원정보도 여기서 수정할 수 있게끔 한다.--%>
	<c:if test="${!empty loginUser }">
		<div>
			${loginUser.userName }님 반갑습니다.
			<a href="main?action=logout">로그아웃</a>
		</div>
		
		<hr>
		
		<h1 id="title">회원정보 수정</h1>
		<div id="user-info">
		<form method="post" action="main">
			<input type="hidden" name="action" value="update">
			<input type="text" name="userId" value="${loginUser.userId }" readonly>
			<input type="password" name="userPwd" value="${loginUser.userPwd }">
			<input type="text" name="userAddress" value="${loginUser.userAddress }">
			<input type="text" name="userName" value="${loginUser.userName }">
			<input type="text" name="userPhone" value="${loginUser.userPhone }">
			<input type="submit" value="저장">
		</form>
		</div>
		
	</c:if>
</div>

<hr>

<h1 id="title">비밀번호 찾기</h1>
<div id="user-info">
		<form method="post" action="main">
			<input type="hidden" name="action" value="findpass">
			<input type="text" name="userId" placeholder="아이디">
			<input type="text" name="userName" placeholder="이름">
			<input type="text" name="userPhone" placeholder="전화번호">
			<input type="submit" value="찾기">
		</form>
</div>

<hr>

<h1 id="title">회원가입</h1>
<div id="user-info">
		<form method="post" action="main">
			<input type="hidden" name="action" value="regist">
			<input type="text" name="userId" placeholder="아이디">
			<input type="password" name="userPwd" placeholder="비밀번호">
			<input type="text" name="userAddress" placeholder="주소">
			<input type="text" name="userName" placeholder="이름">
			<input type="text" name="userPhone" placeholder="전화번호">
			<input type="submit" value="등록">
		</form>
</div>

<hr>

<h1 id="title">회원정보 조회</h1>
<div id="user-info">
		<form method="post" action="main">
			<input type="hidden" name="action" value="search">
			<input type="text" name="userId" placeholder="아이디">
			<input type="submit" value="조회">
		</form>
	<%--리퀘스트가 들어왔을 경우 사용자 정보를 출력한다--%>
	<c:if test="${!empty searchUser }">
		<div>
			비밀번호 : ${searchUser.userPwd }<br>
			주소 : ${searchUser.userAddress }<br>
			이름 : ${searchUser.userName }<br>
			전화번호 : ${searchUser.userPhone }
		</div>
	</c:if>
</div>

<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>

</body>
</html>