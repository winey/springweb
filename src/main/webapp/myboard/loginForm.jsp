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
  <script src="http://code.jquery.com/jquery.js"></script>
  <script src="/bootstrap/js/bootstrap.min.js"></script>
  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
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
      <h3 class="muted">MyBoard-로그인</h3>
  </div>


  <div class="jumbotron">
  <spring:hasBindErrors name="command" />
  <form:errors path="command"/>
  <form method=get action="/myboard/login">
   <table class="table">
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
   </div></div>
  <%@ include file="/myboard/footer.jsp"%>
  </body>
</html>