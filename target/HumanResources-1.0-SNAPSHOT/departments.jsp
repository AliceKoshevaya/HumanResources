<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                                                         integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                                                         crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <title>List of departments</title>
</head>
<style>
    .myBut{
        width: 100%;
        height: 100%;
        background-color: white;
        border: hidden;
    }
    .myBut:hover {
        background-color: lightgrey;
    }
</style>
<body>
<div class="container-full">
    <div class="row">
        <div class="col-md-1">
            <input class="myBut" type="button" value="&#8249;" onclick="history.back(-1)"/>
        </div>
        <div class="col-md-10">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Department code</th>
                    <th scope="col">Department name</th>
                    <th></th>
                    <th colspan="2">
                        <button type="button" class="btn btn-block btn-outline-primary" data-toggle="modal"
                                data-target="#exampleModal">
                            Add
                        </button>
                    </th>
                </tr>
                </thead>

                <c:forEach items='${department}' var="item">
                    <tr>
                        <td>${item.departmentCode}</td>
                        <td>${item.departmentName}</td>

                        <td>
                            <form method="get" action="/editDepartment">
                                <input type="hidden" name="id" value="${item.id}"/>
                                <input class="btn btn-outline-success" type="submit" class="btn btn-default"
                                       value="Edit"/>
                            </form>
                        </td>
                        <td>
                            <form method="post" action="/deleteDepartment">
                                <input type="hidden" name="Id" value="${item.id}"/>
                                <input class="btn btn-outline-danger" type="submit" class="btn btn-default"
                                       value="Delete"/>
                            </form>
                        </td>
                        <td>
                            <form method="get" action="/employeesList">
                                <input type="hidden" name="Id" value="${item.departmentCode}"/>
                                <input class="btn btn-outline-info" type="submit" class="btn btn-default"
                                       value="List employees"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">

                    <h2 align="center">Add department</h2>
                    <form method="POST" action="/addDepartment">
                        <c:if test="${not empty errorMessage}">
                            <div class="alert alert-danger">
                                <c:out value="${errorMessage}"></c:out>
                            </div>
                        </c:if>
                        <div class="input-group">

                            <c:choose>
                                <c:when test="${not empty dName}">
                                    <input class="form-control" type="text" name="DepName" value="${dName}"
                                           placeholder="Enter department name"/>
                                </c:when>
                                <c:when test="${empty dName}">
                                    <input class="form-control" type="text" name="DepName" value=""
                                           placeholder="Enter department name"/>
                                </c:when>
                            </c:choose>

                            <c:choose>
                                <c:when test="${not empty dCode}">
                                    <input class="form-control" type="text" name="DepCode" value="${dCode}"
                                           placeholder="Enter department name"/>
                                </c:when>
                                <c:when test="${empty dCode}">
                                    <input class="form-control" type="text" name="DepCode" value=""
                                           placeholder="Enter department code"/>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                            <button type="button " type="submit" class="btn btn-outline-primary">Save changes</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</body>
<script>
    <c:if test="${not empty errorMessage}">
    $('#exampleModal').modal('toggle')
    </c:if>
</script>
</html>