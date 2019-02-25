<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Employees of department</title>
    <style>
        .myBut {
            width: 100%;
            height: 100%;
            background-color: white;
            border: hidden;
        }

        .myBut:hover {
            background-color: lightgrey;
        }
    </style>
</head>
<body>
<div class="container-full">
    <div class="row">
        <div class="col-md-1">
            <input class="myBut" type="button" value="&#8249;" onclick="history.back(-1)"/>
        </div>
        <div class="col-md-10 table-responsive">
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
                    <th colspan="2">
                        <button type="button" class="btn btn-block btn-outline-primary" data-toggle="modal"
                                data-target="#exampleModal">
                            Add
                        </button>
                    </th>
                </tr>
                </thead>
                <tbody>
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
                                <input type="hidden" name="id" value="${employee.id}"/>
                                <input class="btn btn-success" type="submit" class="btn btn-default" value="Edit"/>
                            </form>
                        </td>
                        <td>
                            <form method="post" action="/deleteEmployee">
                                <input type="hidden" name="code" value="${employee.department.departmentCode}"/>
                                <input type="hidden" name="id" value="${employee.id}"/>
                                <input class="btn btn-danger" type="submit" class="btn btn-default" value="Delete"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${empty employees}">
                <div class="text-secondary">
                    <h3>No employees</h3>
                </div>
            </c:if>
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

                    <form method="POST" action="/addEmployee">
                        <c:if test="${not empty errorMessage}">
                        <div class="alert alert-danger">
                            <c:out value="${errorMessage}"></c:out>
                        </div>
                        </c:if>
                        <div class="form-group">
                            <c:choose>
                                <c:when test="${not empty eName}">
                                    <input class="form-control" align="center" type="text" name="EmpName"
                                           value="${eName}"
                                           placeholder="Enter employee name"/>
                                </c:when>
                                <c:when test="${empty eName}">
                                    <input class="form-control" align="center" type="text" name="EmpName" value=""
                                           placeholder="Enter employee name"/>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="form-group">

                            <c:choose>
                                <c:when test="${not empty eLastName}">
                                    <input class="form-control" align="center" type="text" name="EmpLname"
                                           value="${eLastName}"
                                           placeholder="Enter employee lastName"/>
                                </c:when>
                                <c:when test="${empty eLastName}">
                                    <input class="form-control" align="center" type="text" name="EmpLname" value=""
                                           placeholder="Enter employee lastName"/>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="form-group">
                            <c:choose>
                                <c:when test="${not empty eThirdName}">
                                    <input class="form-control" align="center" type="text" name="EmpTname"
                                           value="${eThirdName}"
                                           placeholder="Enter employee third name"/>
                                </c:when>
                                <c:when test="${empty eThirdName}">
                                    <input class="form-control" align="center" type="text" name="EmpTname" value=""
                                           placeholder="Enter employee third name"/>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="form-group">

                            <c:choose>
                                <c:when test="${not empty eExp}">
                                    <input class="form-control" align="center" type="text" name="EmpExp" value="${eExp}"
                                           placeholder="Enter employee experience"/>
                                </c:when>
                                <c:when test="${empty eExp}">
                                    <input class="form-control" align="center" type="text" name="EmpExp" value=""
                                           placeholder="Enter employee experience"/>
                                </c:when>
                            </c:choose>
                        </div>
                        <input type="hidden" name="code" value="${idJob}"/>
                        <div class="form-group">
                            <select class="custom-select mr-sm-2" name="EmpSex">
                                <option value="MAN">Man</option>
                                <option value="WOMAN">Woman</option>
                            </select>
                        </div>

                        <div class="form-group">

                            <input class="form-control" type="date" name="EmpDob" value="2001-01-01"/>
                        </div>
                        <div class="form-group">

                            <c:choose>
                                <c:when test="${not empty eAddress}">
                                    <input class="form-control" align="center" type="text" name="EmpAdd"
                                           value="${eAddress}"
                                           placeholder="Enter employee address"/>
                                </c:when>
                                <c:when test="${empty eAddress}">
                                    <input class="form-control" align="center" type="text" name="EmpAdd" value=""
                                           placeholder="Enter employee adress"/>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="form-group">
                            <c:choose>
                                <c:when test="${not empty eTelephone}">
                                    <input class="form-control" align="center" type="text" name="EmpTel"
                                           value="${eTelephone}"
                                           placeholder="Enter employee telephone"/>
                                </c:when>
                                <c:when test="${empty eTelephone}">
                                    <input class="form-control" align="center" type="text" name="EmpTel" value=""
                                           placeholder="Enter employee telephone"/>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="form-group">

                            <c:choose>
                                <c:when test="${not empty eEmail}">
                                    <input class="form-control" align="center" type="text" name="EmpEmail"
                                           value="${eEmail}"
                                           placeholder="Enter employee email"/>
                                </c:when>
                                <c:when test="${empty eEmail}">
                                    <input class="form-control" align="center" type="text" name="EmpEmail" value=""
                                           placeholder="Enter employee email"/>
                                </c:when>
                            </c:choose>
                        </div>
                        <div class="form-group">
                            <select class="custom-select mr-sm-2" name="jobCode">
                                <option value="1">HR</option>
                                <option value="2">Java Developer</option>
                                <option value="3">Scala Developer</option>
                                <option value="4">Project manager</option>
                                <option value="5">SEO</option>
                                <option value="6">Tester</option>
                                <option value="7">Analyst</option>
                                <option value="8">Designer</option>
                            </select>
                        </div>
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
</html>
