<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员界面</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" >
    <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <script src="js/jquery-3.5.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script>
        function deleteMess(messID){
            //用户安全提示
            if(confirm("您确定要删除吗？")){
                //访问路径
                location.href="deleteMess.do?messID="+messID;
            }
        }
   window.onload=function () {
       //给删除选中按钮添加单击事件
       document.getElementById("delSelected").onclick = function () {
           if (confirm("您确定要删除选中条目吗？")) {
               var flag = false;
               //判断是否有选中
               var cb = document.getElementsByName("messID");
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
               var cbs = document.getElementsByName("messID");
               for (var i = 0; i < cbs.length; i++) {
                   //设置这些cbs的[i]中的checked状态 = firstCb.checked
                   cbs[i].checked = this.checked;
               }
           }
       }

    </script>
</head>
<body>
<div class="container">
    <a href="query.do"><img src="images/29.png"> </a>
    <a href="queryUser.do">用户信息管理</a>
    <h4 style="text-align: center">用户评论列表</h4>
    <%--<div style="float: right;margin: 5px;">--%>
        <%--<a class="btn btn-primary" href="javascript:void(0);" id="delSelected" >删除选中</a>--%>
    <%--</div>--%>
    <form id="form" action="deleteMess.do" method="post">
        <table border="1" class="table table-bordered table-hover text-center">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>用户ID</th>
                <th>评论内容</th>
                <th>评论时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.messes}" var="mess" varStatus="s">
                <tr class="text-success">
                    <td>
                        <input type="checkbox" name="messID" value="${mess.messID}">
                    </td>
                    <td>
                            ${mess.getUserID()}
                    </td>
                    <td>
                            ${mess.getMess_text()}
                    </td>
                    <td>
                            ${mess.getMess_time()}
                    </td>
                    <td>
                        <a class="btn  btn-danger"  href="javascript:deleteMess(${mess.messID});"><i class="fa fa-trash-o"></i> 删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
