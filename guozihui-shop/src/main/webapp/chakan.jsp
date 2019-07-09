<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link    rel="stylesheet"    href="<%=request.getContextPath() %>/css/css.css"  type="text/css"  >
<script type="text/javascript"  src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script> 


</head>
<body>
	<form action="">
		<table>
			<tr>
				<td>店铺名称</td>
				<td>创建日期</td>
				<td>销售商品</td>
			</tr>
			
			<c:forEach items="${list}" var="s">
			<tr>
				<td>${s.sname }</td>
				<td>${s.indate}</td>
				<td>${s.bname}</td>
			
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>