<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>목록</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script>
function goSaveForm() {
    document.location.href="/myboard/insertform";
    return;
}
</script>
</head>
<body>
<div class="container">
  <div class="jumbotron">
  <table class="table table-bordered table-striped">
   <tr>
       <td>id</td>
       <td>title</td>
       <td>writer</td>
       <td>pw</td>
       <td></td>
       <td></td>
   </tr>

    <c:forEach var="board" items="${boards}">
    <tr>
    <td>${board.id}</td>
    <td><a href="/myboard/detail?id=${board.id}">${board.title}</a></td>
    <td>${board.writer}</td>
    <td>${board.pw}</td>
    <td><a href="/myboard/updateform?id=${board.id}">수정</a></td>
    <td><a href="/myboard/delete?id=${board.id}">삭제</a></td>
    </tr>
    </c:forEach>
    </table>
    </div>
</div>
<div><input type="button" value="등록" onclick="goSaveForm()" /></div>
<div></div>
<%--<div>방문자수 : ${loginCount}</div>--%>
<c:if test="${sessionScope.isLogin eq true}"><div><a href="/myboard/logout">로그아웃</a></div></c:if>
<%@ include file="/myboard/footer.jsp"%>
</body>
</html>