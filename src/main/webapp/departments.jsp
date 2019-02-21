<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>List of departments</title>
</head>
<body>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Department code</th>
        <th scope="col">Department name</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items='${department}' var="item">
        <tr>
            <td>${item.departmentCode}</td>
            <td>${item.departmentName}</td>

            <td>
                <form method="get" action="/editDepartment">
                    <input type="hidden" name="Id" value="${item.id}"/>
                    <input type="submit" class="btn btn-default" value="Edit"/>
                </form>
            </td>
            <td>
                <form method="post" action="/deleteDepartment">
                    <input type="hidden" name="Id" value="${item.id}"/>
                    <input type="submit" class="btn btn-default" value="Delete"/>
                </form>
            </td>
            <td>
                <form method="get" action="/employeesList">
                    <input type="hidden" name="Id" value="${item.departmentCode}"/>
                    <input type="submit" class="btn btn-default" value="List employees"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </thead>
</table>
<h2>Add department</h2>
<form method="POST" action="/addDepartment">
    <input style="float: left;" type="text" name="DepName" placeholder="Enter department name"/>
    <input style="float: left;" type="text" name="DepCode" placeholder="Enter department code"/>
    <input style="float: left;" type="submit" class="btn btn-default"
           value="Add"/>
</form>
</body>
</html>