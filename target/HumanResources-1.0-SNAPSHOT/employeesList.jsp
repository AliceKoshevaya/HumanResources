<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>Employees of department</title>
</head>
<body>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">LastName</th>
        <th scope="col">ThirdName</th>
        <th scope="col">Experience</th>
        <th scope="col">Sex</th>
        <th scope="col">Date Of Birthday</th>
        <th scope="col">Address</th>
        <th scope="col">Telephone</th>
        <th scope="col">Email</th>
        <th scope="col">Post</th>
    </tr>
    <c:forEach items='${employees}' var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.lastName}</td>
            <td>${employee.thirdName}</td>
            <td>${employee.experience}</td>
            <td>${employee.sex}</td>
            <td>${employee.dateOfBirthday}</td>
            <td>${employee.address}</td>
            <td>${employee.telephone}</td>
            <td>${employee.email}</td>
            <td>${employee.post.postName}</td>
            <td>
                <form method="get" action="/editEmployee">
                    <input type="hidden" name="code" value="${employee.department.departmentCode}"/>
                    <input type="hidden" name="Id" value="${employee.id}"/>
                    <input type="submit" class="btn btn-default" value="Edit"/>
                </form>
            </td>
            <td>
                <form method="post" action="/deleteEmployee">
                    <input type="hidden" name="code" value="${employee.department.departmentCode}"/>
                    <input type="hidden" name="Id" value="${employee.id}"/>
                    <input type="submit" class="btn btn-default" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>

    </thead>
</table>
<h2>Add employee</h2>
<form method="POST" action="/addEmployee">
    <input style="float: left;" type="text" name="EmpName" placeholder="Enter employee name"/>
    <input style="float: left;" type="text" name="EmpLname" placeholder="Enter employee lastName"/>
    <input style="float: left;" type="text" name="EmpTname" placeholder="Enter employee thirdName"/>
    <input style="float: left;" type="text" name="EmpExp" placeholder="Enter employee experience"/>
    <input style="float: left;" type="text" name="EmpSex" placeholder="Enter employee sex"/>
    <input style="float: left;" type="text" name="EmpDob" placeholder="Enter employee Date of Birthday"/>
    <input style="float: left;" type="text" name="EmpAdd" placeholder="Enter employee address"/>
    <input style="float: left;" type="text" name="EmpTel" placeholder="Enter employee telephone"/>
    <input style="float: left;" type="text" name="EmpEmail" placeholder="Enter employee email"/>
    <input style="float: left;" type="submit" class="btn btn-default"
           value="Add"/>
</form>
</body>
</html>
