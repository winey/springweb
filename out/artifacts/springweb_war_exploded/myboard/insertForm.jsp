<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.domain.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
  <title>등록</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
  <script src="http://code.jquery.com/jquery.js"></script>
  <script src="/bootstrap/js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="container">
  <spring:hasBindErrors name="command" />
  <form:errors path="command"/>
  <form method=post action="/myboard/save">
    <table class="table uneditable-input">
       <tr>
           <td>title</td><td><input type="text" name="title" value="${command.title}"/></td>
       </tr>
       <tr>
           <td>writer</td><td><input type="text" name="writer" value="${command.writer}"/></td>
       </tr>
       <tr>
           <td>pw</td><td><input type="password" name="pw" value="${command.pw}"/></td>
       </tr>
       <tr>
           <td>content</td><td><textarea name="content"></textarea> </td>

       </tr>
   </table>

   <input type="submit" value="등록" />
   </form>
   </div>
  <%@ include file="/myboard/footer.jsp"%>
  </body>
</html>