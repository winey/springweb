<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.domain.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <title>보기</title>
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
          <h3 class="muted">MyBoard-글읽기</h3>
      </div>


      <div class="jumbotron">
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
      </div></div>
      <div><a href="/myboard">목록으로</a></div>
  <%@ include file="/myboard/footer.jsp"%>
  </body>
</html>