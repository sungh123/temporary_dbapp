<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<<<<<<< HEAD
<%@include file="../layout/header.jsp"%>

<div class="container">
	<!-- username=머시기 &password=머시기&email=머시기&address=머시기 -->
	<!-- 컨트롤러에 만들어놓은 http://localhost:8000/auth/join 로 POST 전달-->
	<form action="/auth/join" method="post">
		<div class="form-group">
			<label for="username">Username:</label> 
			<input type="text" class="form-control" placeholder="Enter username" name="username"/>
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" class="form-control" placeholder="Enter password" name="password"/>
		</div>
		<div class="form-group">
			<label for="email">Email:</label> 
			<input type="email" class="form-control" placeholder="Enter email" name="email"/>
		</div>

		<input class="btn btn-info" type="button" onClick="goPopup();" value="주소찾기" />
		<div class="form-group">
			<label for="address">Address:</label> 
			<input type="text" class="form-control" placeholder="Enter address" name="address" id="address" readonly="readonly"/>
=======
<%@ include file="../layout/header.jsp"%>

<div class="container">

	<!-- username=머시기&password=머시기&email=머시기&address=머시기 -->
	<form action="/auth/join" method="post">
		<div class="form-group">
			<label for="username">Username:</label> 
			<input type="text" class="form-control" placeholder="Enter username"  name="username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" class="form-control" placeholder="Enter password"  name="password">
		</div>
		<div class="form-group">
			<label for="email">Email:</label> 
			<input type="email" class="form-control" placeholder="Enter email"  name="email">
		</div>
		<div class="form-group">
			<label for="address">Address:</label> 
			<input type="text" class="form-control" placeholder="Enter address"  name="address">
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
		</div>

		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
<<<<<<< HEAD
</div>
<br />
<!-- javaScript는 제일 하단에 코드놓기! -->
<script>
	function goPopup() {
		var pop = window.open("/juso", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");
	}

	function jusoCallBack(roadFullAddr) {
		//alert("나 실행됨?  jusoCallBack");
		let addressEL=document.querySelector("#address");
		console.log(addressEL);
		addressEL.value = roadFullAddr;
	}
</script>
<%@include file="../layout/footer.jsp"%>

=======
	
</div>




<%@ include file="../layout/footer.jsp"%>
>>>>>>> 036f4e5 (1. ORM 매핑 시작)
