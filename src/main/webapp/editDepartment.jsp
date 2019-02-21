<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet" type="text/css"/>
    <title>Edit department</title>
</head>
<body>
<p class="form-control"></p>
<div class="container">
    <div class="row main-form">
        <form method="post" action="${pageContext.request.contextPath}/editDepartment">
            <div class="form-group">
                <label  class="cols-sm-2 control-label">Department Code</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="depCode" value="${dep.departmentCode}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Department Name</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="depName" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group ">
                <input type="hidden" name="Id" value="${dep.id}"/>
                <input type="submit" value="Edit" id="button" class="btn btn-primary btn-lg btn-block login-button />
                <a href="${pageContext.request.contextPath}/">
            </div>
        </form>
    </div>
</div>
</body>
</html>
