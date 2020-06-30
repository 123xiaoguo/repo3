
<%@page import="com.xiaoguo.model.Comment"%>
<%@page import="com.xiaoguo.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加留言</title>

	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/bootstrap-table.min.css" />
	<!-- 引入图标库的CSS -->
	<link rel="stylesheet"
		  href="font-awesome-4.7.0/css/font-awesome.min.css" />
	<style type="text/css">
		body{
			background-image:url("images/7.jpg");
		}

		body,ul,ol,dl,dd,p,h1,h2,h3,h4,h5,h6,input,textarea,hr{
			margin:0;
			padding:0;
		}
		a{
			text-decoration: none;
		}
		label a{
			color: wheat;
			text-decoration:none ;
			font-family: 华文楷体;

		}
		label a:hover{
			text-decoration:none ;
			color: darkgray;
			font-size: 26px;

		}
		.bigDiv{

			border-radius: 40px;
			width: 1200px;
			height: 1000px;
			margin-left: 165px;
			margin-top: 10px;
			background-color: rgba(225,225,225,0.5);
		}
		.leftDiv{
			border: 0px solid red;
			width: 550px;
			height: 450px;
			margin-left: 40px;
			padding-top: 40px;
		}
		.text{
			width: 250px;
			height: 150px;
			border: 0px solid red;
			float: left;
			position: absolute;
			left: 580px;
			top: 130px;
		}
		.text p{
			color: white;
			font-size: 20px;
			font-family: 华文仿宋;

		}
		#daoyu{
			border: 0px solid red;
			width: 500px;
			height: 300px;
			position: absolute;
			top: 80px;
			left: 850px;
		}
		#daoyu p{
			text-indent: 10px;
			line-height: 30px;
			color: white;
			font-size: 20px;
			font-family: 华文仿宋;
		}
		#messDiv{
			border: 0px solid red;
			width: 1000px;
			margin-left: 60px;
			margin-top: -140px;
		}
		#messDivtop{
			color: white;
			font-size: 20px;
			font-family: 华文仿宋;
		}
		#messDivmod{
			border: 0px solid red;
			width: 1000px;
			color: white;
			font-size: 20px;
			font-family: 华文仿宋;
		}
		input{
			width: 100px;
			height: 35px;
			background-color: rgb(23,55,52);
			border-radius: 8px;
			display: inline-block;
			border: 1px solid rgb(18,42,67);
			color: white;
		}
		#submit{
			background-color: rgb(249,50,153);
		}
		textarea{
			width: 900px;
			height: 80px;
		}
		label{
			color: white;
			font-size: 20px;
			font-family: 华文仿宋;
		}
		#submitMess{
			border: 0px solid red;
			width: 1000px;
			height:80px ;
			margin-left: 40px;
		}
		#messTable{
			width: 100%;
			height: 35px;
			background-color: rgba(143,209,158,0.5);
			border-radius: 8px;
			margin-bottom: 10px;
		}
	</style>
</head>
<body>
    <div >

        <a href="query.do"><img src="images/29.png"> </a>
		<div class="bigDiv">
          <div class="leftDiv">
			  <div class="img">
				  <img src="images/photos/${requestScope.comment.image}"/>
			  </div>
              <div class="text">
				  <p>主题:${requestScope.comment.title }</p>
				  <br>
				  <p>时间:${requestScope.comment.time}</p>
				  <br>
				  <p>发布者：${requestScope.comment.postName}</p>
			  </div>
			  <div id="daoyu">
				  <br>
				  <br>
				  <p>导语:${requestScope.comment.content}</p>
			  </div>
		  </div>

			<div id="messDiv">
				<p id="messDivtop">
					<img src="images/25.png">评论<span>
					共${fn:length(requestScope.messList) }条 </span><br/>
				</p>
				<div id="messDivmod">
					<c:choose>
						<c:when
								test="${requestScope.messList!=null && fn:length(requestScope.messList)!=0 }">
							<c:forEach items="${requestScope.messList }" var="mess">
								<table  id="messTable">
									<tr>
										<td><img src="images/26.png">${mess.mess_text}</td>
									</tr>
									<tr>
										<td align="right" style="padding-right: 20px;">
											<img src="images/23.png">${mess.userID ==0?"匿名者":mess.userID }&nbsp;&nbsp;&nbsp;&nbsp;
											<img src="images/24.png"><fmt:formatDate value="${mess.mess_time }" pattern="yyyy-MM-dd HH:mm:ss"/>
										</td>
									</tr>
								</table>
								</p>
							</c:forEach>

						</c:when>
						<c:otherwise>
							<h2 align="center">暂无评论</h2>
						</c:otherwise>
					</c:choose>
				</div>

				<div>
					<form action="addMessServlet.do" method="post">
							<label>
								<c:choose>
								<c:when test="${sessionScope.user!=null }">
									<img src="images/23.png">用户名:${sessionScope.user.userName }
								</c:when>
								<c:otherwise>
									您当前没有登录<a href="login.jsp">请先登录呦</a>
								</c:otherwise>
							</c:choose>
							</label>
							<div id="submitMess">
								<!-- 隐藏域可以提交数据但页面不显示 -->
								<input type="hidden" name="commentId" value="${requestScope.comment.commentID }"><br/>
								<textarea name="mess_text" placeholder="在这儿写下你想说的话"></textarea>
								<input type="submit" value="提交评论" id="submit"/>
					        </div>
					</form>

				</div>

		</div>


	</div>
</div>
</body>
</html>