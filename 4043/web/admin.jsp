<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员界面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>


    <script>
        function deleteUser(userID){
            //用户安全提示
            if(confirm("您确定要删除吗？")){
                //访问路径
                location.href="deleteUser.do?userID="+userID;
            }
        }
        window.onload = function () {
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要删除选中条目吗？")) {
                    var flag = false;
                    //判断是否有选中
                    var cb = document.getElementsByName("userID");
                    for (var i = 0; i < cb.length; i++) {
                        if (cb[i].checked) {
                            //有一个被选中
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }
                }
            }
            //获取第一个cb
            document.getElementById("firstCb").onclick = function () {
                //获取列表中所有的cb
                var cbs = document.getElementsByName("userID");
                for (var i = 0; i < cbs.length; i++) {
                    //设置这些cbs的[i]中的checked状态 = firstCb.checked
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body>
<div class="container ">
    <a href="queryMess.do"><img src="images/29.png"> </a>
    <h4 style="text-align: center">用户信息列表</h4>
    <%--<div style="float: right;margin: 5px; ">--%>
        <%--<a class="btn btn-danger mr-2 mt-3" href="javascript:void(0);" id="delSelected" ><i class="fa fa-trash-o" aria-hidden="true"></i> 删除选中</a>--%>
    <%--</div>--%>
    <div >
        <form id="form" action="deleteUser.do" method="post">
            <table border="1" class="table table-bordered table-hover text-center">
                <tr class="text-success">
                    <th><input type="checkbox" id="firstCb"></th>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>性别</th>
                    <th>邮箱</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${requestScope.users}" var="user" varStatus="s">
                    <tr class="text-success">
                        <td>
                            <input type="checkbox" name="userID" value="${user.userID}">
                        </td>
                        <td>
                                ${user.getUserID()}
                        </td>
                        <td>
                                ${user.getUserName()}
                        </td>
                        <td>
                                ${user.getPassword()}
                        </td>
                        <td>
                                ${user.getSex()}
                        </td>
                        <td>

                                ${user.getEmail()}
                        </td>
                        <td>
                        <a class="btn btn-success btn-sm" href="queryUserById.do?userID=${user.userID}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>修改</a>
                        <a class="btn btn-danger btn-sm" href="javascript:deleteUser(${user.userID});"><i class="fa fa-trash-o" aria-hidden="true"></i>删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>

</div>

</body>
</html>
