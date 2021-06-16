<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>index</title>

<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<style>
            body {
                background-color: #534292;
            }
            #form {
                border: 1px solid black;
                width: 500px;
                padding: 1em;
                text-align: center;
                margin: 100px auto;
                background-color:white;
                color: #79589f;
            }
            #form > h1 {
                font-size: 1.6em;
                font-weight: bold;
                margin: 10px 0;
            }
            #form > h2 {
                color: #aaaaaa;
                margin-top: 100px;
            }
            #form > h2 > a {
                color: #79589f;
            }
            #accout {
                margin: 20px 0;
            }
            #accout > input {
                width: 350px;
                height: 20px;
            }
            #password {
                margin: 20px 0;
            }
            #password > input {
                width: 350px;
                height: 20px;
            }  

            #login > input {
                margin: 10px;
                width: 360px;
                height: 30px;
                color: white;
                background-color: #795879;
            }
        </style>
        

</head>
<body>
<!-- 
   <div class="container">
		<div class="jumbotron">
			<h1>로그인 하세요<small>로그인</small></h1>
			<form method="post" action="<c:url value="LoginProcess.do"/>">
					아이디  <input type="text" name="id" value="" />
					비밀번호 <input type="password" name="pwd" value="" />
					<input type="submit" value="로그인" />
			</form>
			
		</div>
	</div>
 -->
	<form action="<c:url value="LoginProcess.do"/>" method="POST" id="form">
            <h1>${NotMember }로그인 후 이용해주세요</h1>
            <p id="accout">
                <input type="text" name="id" minlength="4" placeholder="아이디" value="${param.id }">
            </p>
            <p id="password">
                <input type="password" name="pwd" minlength="4" placeholder="비밀번호">
            </p>
            <p id="login">
                <input type="submit" value="로그인" />
            </p>
            <h2>회원이 아니신가요?<a href="#">회원가입</a></h2>
        </form>
</body>
</html>