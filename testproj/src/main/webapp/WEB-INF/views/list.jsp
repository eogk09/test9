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
    #log {
        height: 150px;
    }
    #nav {
        float: right;
    }
    #nav > ul > li {
        text-decoration: none;
        list-style: none;
        margin-right: 20px;
        display: inline;
    }
    #nav > ul > li > a {
        color: black;
    }
    #nav::after {display: block; content: ""; clear: both;}
    
    #wrap{
        width: 100%;
    }
    #wrap::after {display: block; content: ""; clear: both;}
    #content {
        width: 80%;
        float: left;
    }
    #sidebar {
        float: right;
        width: 20%;
    }
    #sidebar > ul > li {
        text-decoration: none;
        list-style: none;
    }
    #sidebar > ul > li > a{
        color: black;
    }
    #paging{
        width: 80%;
    }
</style>

</head>
<body>
    <div id="logo">
    </div>
    <div id="nav">
		<ul>
			<c:if test="${empty param.id }" var="login">
            	<li><a href="<c:url value="Login.do"/>">로그인</a></li>
			</c:if>
			<c:if test="${not login }">
			<li><a href="<c:url value="Logout.do"/>">로그아웃</a></li>
			</c:if>
			<li><a href="<c:url value=""/>">마이페이지</a></li>
			<li><a href="<c:url value=""/>">장바구니</a></li>
			<li><a href="<c:url value=""/>">고객센터</a></li>
			<li><a href="<c:url value=""/>">공지사항</a></li>
		</ul>
	</div>
	<div id="wrap">
        <div class="row" id="content">
            <div class="col-md-12">
                <table class="table table-bordered table-hover table-condensed text-center">
                <tr>
                    <th class="col-md-1 text-center">번호</th>
                    <th class="text-center">제목</th>
                    <th class="col-md-1 text-center">작성자</th>
                    <th class="col-md-2 text-center">작성일</th>
                </tr>
                <c:if test="${empty listPagingData.lists }" var="isEmpty">
					<tr>
						<td colspan="4">등록된 게시물이 없어요</td>
					</tr>
				</c:if>
				<c:if test="${not isEmpty }">
					<c:forEach items="${listPagingData.lists }" var="item"
						varStatus="loop">
						<tr>
							<td>${listPagingData.totalRecordCount - (((listPagingData.nowPage - 1) * listPagingData.pageSize) + loop.index)}</td>
							<td class="text-left"><a
								href="<c:url value="/OneMemo/BBS/View.do?no=${item.no}&nowPage="/><c:out value="${param.nowPage}" default="1"/>">${item.title }</a>
								<span class="badge">${item.commentCount }</span></td>
							<td>${item.name }</td>
							<td>${item.postDate }</td>
						</tr>
					</c:forEach>
				</c:if>
                </table>
            </div>
        </div>
        <div class="row" id="paging">
            <div class="col-md-12 text-center">${listPagingData.pagingString}</div>
        </div>
        <div id="sidebar">
            <ul>
                <li><a href="<c:url value=""/>">배송조회</a></li>
                <li><a href="<c:url value=""/>">주변 마트 조회</a></li>
                <li><a href="<c:url value=""/>">맞춤 장바구니 서비스</a></li>
            </ul>
        </div>
    </div>
</body>
</html>