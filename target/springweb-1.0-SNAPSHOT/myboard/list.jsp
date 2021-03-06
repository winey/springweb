<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.domain.Board" %>
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
    <style type="text/css">
        body {
            padding-top: 20px;
            padding-bottom: 40px;
        }

            /* Custom container */
        .container-narrow {
            margin: 0 auto;
            max-width: 700px;
        }
        .container-narrow > hr {
            margin: 30px 0;
        }

            /* Main marketing message and sign up button */
        .jumbotron {
            margin: 60px 0;
            text-align: center;
        }
        .jumbotron h1 {
            font-size: 72px;
            line-height: 1;
        }
        .jumbotron .btn {
            font-size: 21px;
            padding: 14px 24px;
        }

            /* Supporting marketing content */
        .marketing {
            margin: 60px 0;
        }
        .marketing p + h4 {
            margin-top: 28px;
        }
    </style>
</head>
<body>
<div class="container-narrow">

    <div class="masthead">
        <h3 class="muted">MyBoard</h3>
    </div>


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

<div><input type="button" value="등록" onclick="goSaveForm()" /></div>
    </div>
</div>
<%--<div>방문자수 : ${loginCount}</div>--%>
<c:if test="${sessionScope.isLogin eq true}"><div><a href="/myboard/logout">로그아웃</a></div></c:if>
<%@ include file="/myboard/footer.jsp"%>
</body>
</html>