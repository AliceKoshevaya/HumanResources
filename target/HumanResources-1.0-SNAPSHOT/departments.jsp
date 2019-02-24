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
    <thead class="table-info">
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
                    <input class="btn btn-success" type="submit" class="btn btn-default" value="Edit"/>
                </form>
            </td>
            <td>
                <form method="post" action="/deleteDepartment">
                    <input type="hidden" name="Id" value="${item.id}"/>
                    <input class="btn btn-danger" type="submit" class="btn btn-default" value="Delete"/>
                </form>
            </td>
            <td>
                <form method="get" action="/employeesList">
                    <input type="hidden" name="Id" value="${item.departmentCode}"/>
                    <input class="btn btn-info" type="submit" class="btn btn-default" value="List employees"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </thead>
</table>
<h2 align="center">Add department</h2>
<div align="center">
    <form method="POST" action="/addDepartment">
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">
                <c:out value="${errorMessage}"></c:out>
            </div>
        </c:if>
        <c:choose>
            <c:when test="${not empty dName}">
                <input align="center" type="text" name="DepName" value="${dName}" placeholder="Enter department name"/>
            </c:when>
            <c:when test="${empty dName}">
                <input align="center" type="text" name="DepName" value="" placeholder="Enter department name"/>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${not empty dCode}">
                <input align="center" type="text" name="DepCode" value="${dCode}" placeholder="Enter department name"/>
            </c:when>
            <c:when test="${empty dCode}">
                <input align="center" type="text" name="DepCode" value="" placeholder="Enter department code"/>
            </c:when>
        </c:choose>
        <input class="btn btn-primary" type="submit" class="btn btn-default"
               value="Add"/>
    </form>
</div>
</body>
</html>