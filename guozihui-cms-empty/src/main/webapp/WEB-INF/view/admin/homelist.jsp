<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="howsun">

<title>CMS后台管理系统</title>

<!-- Bootstrap core CSS-->
<link href="/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="/libs/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Custom styles for this template-->
<link href="/libs/sb-admin/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- 后台管理系统顶部 -->
	<jsp:include page="_inc_top.jsp" />

	<div id="wrapper">

		<!-- 后台管理系统左部菜单 -->
		<jsp:include page="_inc_left.jsp" />

		<div id="content-wrapper">

			<div class="container-fluid">
	
				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">专题文章设置</a></li>
					<li class="breadcrumb-item active">概览</li>
				</ol>

				<!-- Icon Cards-->
				<br /> <br /> <br />
			</div>
			<form action="jiaspecial?sid=${sid}" method="post">
				<input type="hidden" value="${sid}" >
			<table  class="table table-condensed">
				<tr>
					<td>文章ID</td>
					<td>文章标题</td>
					<td>文章发布时间</td>
					<td>操作</td>
				</tr>
				
				<c:forEach items="${listart}" var="s">
					<tr>
						<td>${s.id}</td>
						<td>${s.title}</td>
						<td>${s.created}</td>
						<td>
							<a class="btn btn-primary" href="/admin/removespec?id=${s.id}" ><span class="glyphicon glyphicon-edit">移除</span></a>&nbsp;&nbsp;
							
						</td>
					</tr>
				</c:forEach>
				<span>${delmsg}</span>
			</table>
		<!-- /.container-fluid -->

		<!-- Sticky Footer -->
		<input type="text" name="aid" >
		<input type="submit" value="添加文章">		
			</form>
		<footer class="sticky-footer">
			<div class="container my-auto">
				<div class="copyright text-center my-auto">
					<span>Copyright Â© Your Website 2019</span>
				</div>
			</div>
		</footer>

		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Bootstrap core JavaScript-->
	<script src="/libs/jquery/jquery.min.js"></script>
	<script src="/libs/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/libs/sb-admin/sb-admin.min.js"></script>
</body>

</html>
