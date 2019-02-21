<%--
  Created by IntelliJ IDEA.
  User: ajiek
  Date: 18.02.2019
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit employee</title>
</head>
<body>
<p class="form-control"></p>
<div class="container">
    <div class="row main-form">
        <form method="get" action="${pageContext.request.contextPath}/editEmployee">
            <div class="form-group">
                <label  class="cols-sm-2 control-label">Name</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="name" value="${dep.departmentCode}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Last Name</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="lastName" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Third Name</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="thirdName" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Experience</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="exp" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Sex</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="sex" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Sex</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="sex" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Date of Birthday</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="birthday" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Address</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="add" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Telephone</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="birthday" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="cols-sm-2 control-label">Email</label>
                <div class="cols-sm-10">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                        <input type="text" class="form-control" name="birthday" value="${dep.departmentName}"/>
                    </div>
                </div>
            </div>
            <div class="form-group ">
                <input type="submit" value="Edit" id="button" class="btn btn-primary btn-lg btn-block login-button />
                <a href="${pageContext.request.contextPath}/">
            </div>
        </form>
    </div>
</div>
</body>
</html>
