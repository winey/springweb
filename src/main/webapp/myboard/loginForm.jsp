<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.domain.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
  <head>
  <title>로그인</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
  <script src="http://code.jquery.com/jquery.js"></script>
  <script src="/bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="container">
  <spring:hasBindErrors name="command" />
  <form:errors path="command"/>
  <form method=get action="/myboard/login">
   <table class="table uneditable-input">
       <tr>
           <td>아이디</td>
           <td><input type="text" name="id" value="${id}" /><form:errors path="command.id" /></td>
       </tr>
       <tr>
           <td>비번</td><td><input type="password" name="pw" /><form:errors path="command.pw" /></td>
       </tr>
       <tr>
           <td>아이디저장</td><td><input type="checkbox" name="rem" value=1
           <c:if test="${rem != null}" > checked </c:if></td>
       </tr>
     </table>

   <input type="submit" value="로그인" />
   </form>
   </div>
  <%@ include file="/myboard/footer.jsp"%>
  </body>
</html>