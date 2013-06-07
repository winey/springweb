<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>로그인</title>
  </head>
  <body>
  <form method=get action="/myboard/login">
   <table>
       <tr>
           <td>아이디</td><td><input type="text" name="id" value="${id}" /></td>
       </tr>
       <tr>
           <td>비번</td><td><input type="password" name="pw" /></td>
       </tr>
       <tr>
           <td>아이디저장</td><td><input type="checkbox" name="rem" value=1
           <c:if test="${rem != null}" > checked </c:if></td>
       </tr>
     </table>

   <input type="submit" value="로그인" />
   </form>
  <%@ include file="/myboard/footer.jsp"%>
  </body>
</html>