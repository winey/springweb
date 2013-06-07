<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>수정</title>
  </head>
  <body>

  <form method=post action="/myboard/update">
      <table>
          <tr>
              <td>id</td><td><input type="text" name="id" value="${board.id}" readonly /></td>
          </tr>
          <tr>
              <td>title</td><td><input type="text" name="title" value="${board.title}" /></td>
          </tr>
          <tr>
              <td>writer</td><td><input type="text" name="writer" value="${board.writer}" /></td>
          </tr>
          <tr>
              <td>pw</td><td><input type="password" name="pw" value="${board.pw}"/></td>
          </tr>
          <tr>
              <td>content</td><td><textarea name="content">${board.content}</textarea> </td>

          </tr>
      </table>

      <input type="submit" value="수정" />
  </form>
  <%@ include file="/myboard/footer.jsp"%>
  </body>
</html>