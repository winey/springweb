<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.domain.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>수정</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
  <script src="http://code.jquery.com/jquery.js"></script>
  <script src="/bootstrap/js/bootstrap.min.js"></script>
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
          <h3 class="muted">MyBoard-글수정</h3>
      </div>


      <div class="jumbotron">

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
          </div></div>
  <%@ include file="/myboard/footer.jsp"%>
  </body>
</html>