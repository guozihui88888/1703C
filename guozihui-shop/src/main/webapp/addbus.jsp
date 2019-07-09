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
		$(function(){
			$.ajax({
				url:"findbid.do",
				dataType:"json",
				type:"post",
				success:function(data){
					
					for ( var i in data) {
						$("#xid").append("<input type='checkbox' name="+data[i].bid+" value="+data[i].bid+">'"+data[i].bname+"'")
					}
				}
			})
		})
		
		function addshop() {
			var bid =$("input:checked").map(function(){
				return this.value
			}).get().join();
			var sid =$("#sid").val()
			var sname =$("#sname").val()
			var indate =$("#indate").val()
			
			$.ajax({
				url:"addshop.do",
				dataType:"json",
				data:{bid:bid,sid:sid,sname:sname,indate:indate},
				type:"post",
				success:function(data){
					if(data>0){
						alert("添加成功")
						location="list.do"
					}else{
						alert("添加失败")
					}
					
				}
			})
		}
	</script>
</head>
<body>
	<form action="">
	编号 <input type="text" name="sid" id="sid"><br>
	店铺名称 <input type="text" name="sname" id="sname"><br>
	创建日期<input type="date" name="indate" id="indate"><br>
	销售商品：
		<div id="xid">
			
		</div><br>
		
		<input type="button" value="保存" onclick="addshop()">
		<input type="button" value="关闭" >
	</form>
</body>
</html>