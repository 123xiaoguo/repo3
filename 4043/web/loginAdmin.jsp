<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/5/29
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <style type="text/css">
    body{
    background-color:rgb(92,106,122);
    }

    body,ul,ol,dl,dd,p,h1,h2,h3,h4,h5,h6,input,textarea,hr{
    margin:0;
    padding:0;
    }
    a{
    text-decoration: none;
    }
    #leftDiv{
    background-color:rgb(48,49,53);
    box-shadow: 10px 10px 10px rgb(60,67,83);
    position:relative;
    left:130px;
    width:780px;
    height:620px;
    }


    .cont1{
    width: 340px;
    height: 450px;
    display: block;
    margin-right: 50px;
    background-color: rgb(19,36,53);
    position: absolute;
    top: 70px;
    left:220px;

    }
    span{
    font-size: 20px;
    color: rgb(11,132,211);
    line-height: 110px;
    display: inline-block;
    margin-left: 80px;
    }
    .cont0{
    width:100%;
    height:50px;
    color:white;
    font-size: 40px;
    }
    .cont2{
    width:340px;
    height: 110px;
    }
    input{
    width: 250px;
    height: 35px;
    background-color: rgb(61,62,64);
    border-radius: 8px;
    display: inline-block;
    margin-left: 45px;
    border: 1px solid rgb(18,42,67);
    color: white;
    }
    #text{
    background-image: url(images/11.png);
    background-repeat: no-repeat;
    background-position:5px;
    }
    #password{
    background-image: url(images/12.png);
    background-repeat: no-repeat;
    background-position:5px;
    }

    #submit{
    background-color: rgb(249,50,153);
    }
    #rightDiv{
    position:relative;
    left:780px;

    }
    </style>
</head>
<body>

<div id="bigDiv">
    <div class="cont0">

    </div>
    <div id="leftDiv">
        <div class="cont1">
            <div class="cont2">
                <span>欢迎管理员登录.</span>
            </div>
            <form action="loginAdmin.do" method="post">
                <input type="text" name="username" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入用户名" id="text"><br /><br />
                <input type="password" name="password" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入密码" id="password"><br /><br />
                <input type="submit" value="登录" id="submit"/>
            </form>
        </div>
        <div id="rightDiv">
            <img src="images/1.jpg"/>
        </div>
    </div>
</div>
</body>
</html>
