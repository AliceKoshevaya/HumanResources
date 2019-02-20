<%--
  Created by IntelliJ IDEA.
  User: ajiek
  Date: 18.02.2019
  Time: 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>Title</title>
</head>
<body>
<form action="/action_page.php">
    <div class="form-group">
        <label>Department code:</label>
        <input type="code" class="form-control" id="code">
    </div>
    <div class="form-group">
        <label>Department name:</label>
        <input type="name" class="form-control" id="name">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
