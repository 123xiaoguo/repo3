<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
<style type="text/css">
	body{
	 background-color:rgb(93,106,123);
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
#email{
	background-image: url(images/13.png);
	background-repeat: no-repeat;
	background-position:5px;
}
#submit{
 background-color: rgb(249,50,153);
}
#radio{
   width:20px;
   height:20px;
}
#radio1{
	width:20px;
	height:20px;
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
					<span>欢迎用户注册.</span>
				</div>
	<form action="registerServlet.do" method="post" >
		<input type="text" name="username" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入用户名" id="text"><br /><br />
		<input type="password" name="password" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入密码" id="password"><br /><br />
	    <input type="email" name="email" placeholder="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入E-mail" id="email"/><br /><br />
		<input type="radio" name="sex" value="女" id="radio1"/><img src="images/16.png"/>
		<input type="radio" name="sex" value="男" id="radio"/><img src="images/17.png"/>
		<input type="submit" value="注      册" id="submit"/>
	</form>
	 </div>
	 <div id="rightDiv">
	   <img src="images/1.jpg"/>
	 </div>
</div>
</html>