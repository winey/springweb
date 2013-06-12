<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.domain.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>보기</title>
  </head>
  <body>
  <table>
          <tr>
              <td>id</td><td>${board.id}</td>
          </tr>
          <tr>
              <td>title</td><td>${board.title}</td>
          </tr>
          <tr>
              <td>writer</td><td>${board.writer}</td>
          </tr>
          <tr>
              <td>pw</td><td>${board.pw}</td>
          </tr>
          <tr>
              <td>content</td><td><textarea name="content">${board.content}</textarea> </td>

          </tr>
      </table>
      <div><a href="/myboard">목록으로</a></div>
  <%@ include file="/myboard/footer.jsp"%>
  </body>
</html>