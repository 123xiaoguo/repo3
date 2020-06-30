
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>


</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="update.do" method="post">
        <!--  隐藏域 提交id-->
        <input type="hidden" name="userID" value="${user.userID}">

        <div class="form-group">

            <label for="name">用户名：</label>
            <input type="text" class="form-control" id="name" name="username"  value="${user.userName}"  placeholder="请输入姓名" />
        </div>
        <div class="form-group">
            <label for="email">密码：</label>
            <input type="text" id="password" class="form-control" value="${user.password}" name="password" placeholder="请输入密码"/>
        </div>
        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="sex" value="女" /><img src="images/16.png"/>
            <input type="radio" name="sex" value="男"  /><img src="images/17.png"/>
        </div>
        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${user.email}" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
        </div>
    </form>
</div>
</body>
</html>

