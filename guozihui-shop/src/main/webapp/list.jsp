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

	<script type="text/javascript">
		function addbus() {
			location="addbus.jsp"
		}
		
		function chakan(sid) {
			location="chakan.do?sid="+sid
		}
		function delbus(sid) {
			var sid=$("input:checked").map(function(){
				return this.value
			}).get().join();
			$.ajax({
				url:"delbus.do",
				dataType:"json",
				data:{sid:sid},
				type:"post",
				success:function(data){
					if(data>0){
						alert("删除成功")
						location="list.do"
					}
					
				}
			})
			
		}
		
	</script>
</head>
<body>
	<form action="list.do" method="post">
		<c:forEach items="${bus}" var="b">
			<input type="checkbox" name="${b.bid}" value="${b.bid}">${b.bname}
		</c:forEach><br>
		店铺名称<input type="text" name="name"> 
		<input type="submit" value="查询"> 
		<input type="button" value="添加" onclick="addbus()"> 
		<input type="button" value="批量删除" onclick="delbus()"> 
		<table>
			<tr>
				<td>
					<input type="checkbox" >
				</td>
				<td>编号</td>
				<td>店铺名称</td>
				<td>创建日期</td>
				<td>销售商品</td>
				<td>操作</td>
			</tr>
			
			<c:forEach items="${info.list}" var="s">
			<tr>
				<td>
					<input type="checkbox" name="sid" value="${s.sid}">
				</td>
				<td>${s.sid}</td>
				<td>${s.sname}</td>
				<td>${s.indate}</td>
				<td>${s.cname}</td>
				<td>
					<input type="button" value="详情" onclick="chakan(${s.sid})">
				</td>
			</tr>
			</c:forEach>
			
			<tr>
				<td colspan="10">
					<a href="list.do?pageNum=${info.firstPage}">首页</a>
					<a href="list.do?pageNum=${info.prePage}">上一页</a>
					<a href="list.do?pageNum=${info.nextPage}">下一页</a>
					<a href="list.do?pageNum=${info.lastPage}">末页</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>