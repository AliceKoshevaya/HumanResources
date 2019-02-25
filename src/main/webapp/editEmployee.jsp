
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>Edit employee</title>
</head>
<body>
<p class="form-control"></p>
<div class="container">
    <div class="row main-form">
        <form method="post" action="${pageContext.request.contextPath}/editEmployee">
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">
                    <c:out value="${errorMessage}"></c:out>
                </div>
            </c:if>
            <input type="hidden" name="id" value="${emp.id}"/>
            <input type="hidden" name="idDep" value="${dep}"/>
            <div class="form-group">
                <label  class="cols-sm-2 control-label">Name</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="name" value="${emp.name}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Last Name</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="lastName" value="${emp.lastName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Experience</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="exp" value="${emp.experience}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Address</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="add" value="${emp.address}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Telephone</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="tel" value="${emp.telephone}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Email</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="email" value="${emp.email}"/>
                    </div>
                </div>
            </div>
            <div class="form-group ">
                <input type="submit" value="Edit" id="button" class="btn btn-outline-primary btn-lg btn-block login-button />
                <a href="${pageContext.request.contextPath}/">
            </div>
        </form>
    </div>
</div>
</body>
</html>
