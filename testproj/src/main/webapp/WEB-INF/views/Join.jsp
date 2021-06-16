<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	${message }
	<form action="<c:url value="/join"/>" method="post">
		아이디 <input type="text" name="id"/>
		비번 <input type="password" name="pwd"/>
		이름 <input type="text" name="name"/>
		<input type="submit" value="회원가입"/>
	</form>
</body>
</html>