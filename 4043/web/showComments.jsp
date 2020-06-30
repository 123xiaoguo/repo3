
<%@page import="com.xiaoguo.model.Comment"%>
<%@page import="com.xiaoguo.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>评论列表</title>
<style type="text/css">
body{
	 background-image:url("images/4.jpg");
	}

	body,ul,ol,dl,dd,p,h1,h2,h3,h4,h5,h6,input,textarea,hr{
		margin:0;
		padding:0;
	}
	a{
		text-decoration: none;
	}
	.cont{
		border: 7px solid rgb(27,26,22);
		border-radius: 40px;
		width: 1200px;
		height: 550px;
		margin-left: 165px;
		margin-top: 80px;

	}
	
.header{
	width:100%;
	height:45px;
	border-bottom: 1px solid rgb(136 157 176);
}
.header-left{
	width: 120px;
	height:45px;
	border-right: 1px solid rgb(136 157 176);
}
.header-left p{
	line-height: 45px;
	text-align: center;
	color: whitesmoke;
	font-size: smaller;
}
.header-right{
	position: absolute;
	left:400px;
	top:87px;
}
.mess{
	float: right;
	width: 340px;
	font-size:18px;
	margin-right: 10px;
	line-height: 40px;
}
.mess a{
	 color: white;
	 text-decoration:none ;
	 font-family: 华文楷体;

 }
.mess a:hover{
	text-decoration:none ;
	color: darkgray;

}
.center{
	width: 460px;
	height: 460px;
	margin-left: 100px;
	background-color: rgba(225,225,225,0.5);
	border-radius: 15px;
	margin-top: 25px;
}
.commentDiv{
		width:380px;
		border:1px solid rgb(16,36,53);	
		color:white;
		border-radius: 8px;
	    box-shadow: 5px 5px 5px rgb(60,67,83);
		float:left;
		height:50px;
		margin-left:20px;
	    margin-top:20px;
		padding-left:10px;
		padding-top:20px;
	}
.commentDiv:hover{
		border-radius:5px;
		box-shadow: 3px 3px  rgb(115,134,151);
		cursor: pointer;
	}
.commentDiv a{
	color: black;
	font-weight: bold;
	text-decoration:none ;
}
	.commentDiv a:hover{
		text-decoration:none ;
		color: darkgray;
		font-size: larger;
	}
.right{
	width:90px;
	height: 530px;
	border-left:1px solid rgb(136 157 176);
	border-right: none;
	position: absolute;
	top:87px;
	left:1270px;

}

	.text{
		border: 0px solid red;
		width: 400px;
		position: absolute;
		top: 180px;
		left: 810px;
	}
	.text p{
		font-size: 38px;
	    font-weight: bold;
		font-family:"Franklin Gothic Book";
		color: black;
	}
	.text h3{
		margin-top: 20px;
		text-indent: 10px;
		line-height: 30px;
		color: white;
		font-family: 仿宋;
	}
.pagin-bar{
	width: 400px;
	height:50px;
	border:0px solid red;
	line-height:50px;
	text-align: center;
}
.pagin-bar>.pagin-span{
	margin-right: 20px;
	letter-spacing: 3px;
}
.pagin-span>input{
	width:50px;
	height:30px;
}
.pagin-span>input[type="button"]{

	height:36px;
	margin-left:10px;
	cursor:pointer;
}
</style>
</head>
<body>
    <div class="cont">
		<div class="header">
			<div class="header-left">
				<p >Weclome</p>
			</div>
			<div class="header-right">
				<c:choose>
					<c:when test="${sessionScope.user!=null}">
						<table cellpadding="0" cellspacing="0"   class="mess" >
							<tr>
								<th><a href="">你好， ${sessionScope.user.userName}</a></th>
								<th><a href="exit.do">退出</a></th>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<table cellpadding="0" cellspacing="0"   class="mess" >
							<tr>
								<th><a href="query.do">首页</a></th>
								<th><a href="register.jsp">注册</a></th>
								<th ><a href="login.jsp">登录</a></th>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
			</div>

		</div>

			 <div class="center">
				 <c:forEach items="${requestScope.comments}" var="comment">
					 <div class="commentDiv" >
						 <span>
							  <img src="images/21.png"/>
							 今日热点：
							 <a href="queryById.do?commentId=${comment.commentID}">${comment.getTitle()}</a>
						 </span>
					 </div>
				 </c:forEach>
				 <div class="pagin-bar">
					 <c:choose>
						 <c:when test="${requestScope.currPageNum == 1 }">
							 <span>首页</span>
							 <span>上一页</span>
						 </c:when>
						 <c:otherwise>
							 <span><a href="query.do?pageNum=1">首页</a></span>
							 <span><a href="query.do?pageNum=${requestScope.currPageNum-1 }">上一页</a></span>
						 </c:otherwise>
					 </c:choose>

					 <c:choose>
						 <c:when test="${requestScope.currPageNum == requestScope.countPage }">
							 <span>下一页</span>
							 <span>尾页</span>
						 </c:when>
						 <c:otherwise>
							 <span><a href="query.do?pageNum=${requestScope.currPageNum+1}">下一页</a></span>
							 <span><a href="query.do?pageNum=${requestScope.countPage}">尾页</a></span>
						 </c:otherwise>
					 </c:choose>
					 <span class="pagin-span">
					共${requestScope.countPage}页/当前第${requestScope.currPageNum }页
				</span>
				 </div>
			 </div>
			 </div>
		<div class="right">
			<img src="images/20.png" >
		</div>
       <div class="text">
		  <p>FUNNY Bulletin Board System</p>
		   <h3>
			   FUNNY Bulletin Board System是一款以快速、美妙、有趣的方式将好玩的好吃的好用的彼此分享的小小型的最新热点话题的论坛。
		   </h3>
	   </div>

	</div>
   </body>
</html>