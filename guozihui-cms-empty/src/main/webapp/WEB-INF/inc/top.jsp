<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="/" title="CMS"><img alt="CMS" src="/images/logo.png"></a>
  
  <!-- 搜索框：在专业高级二学完ElasticSearch后实现 -->
  <form class="form-inline">
    <div class="input-group">
      <input type="text" name="key" class="form-control" placeholder="输入关键字..." aria-label="key" aria-describedby="basic-addon1">
      <div class="input-group-prepend">
        <button class="input-group-btn btn btn-outline-primary" id="basic-addon1">搜索</button>
      </div>
    </div>
  </form>
  
  <!-- 右边登录注册 -->
  <ul class="nav">
   	<c:choose>
   	<%-- 登录显示用户菜单 --%>
    <c:when test="${_LOGIN_USER_  != null}">
   	 <li class="nav-item">
   		<a class="nav-link" href="/my/home">
		<c:choose>
	<c:when test="${_LOGIN_USER_.avatar!=null && _LOGIN_USER_.avatar!=''}">
	<%-- <img alt="" src="<%=request.getContextPath()%>${_LOGIN_USER_.avatar}" class="img-thumbnail" style="width: 100px"> --%>
	</c:when>
	<c:otherwise>
		<img alt="" src="/images/logo.png" class="img-thumbnail" style="width: 100px">
	</c:otherwise>
	</c:choose>
   		</a>
   	 </li>
   	 <li class="nav-item">
   		<div class="dropdown" style="padding-top: 0.4rem;">
		  <a href="#" class="nav-link dropdown-toggle" role="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    <c:out value="${_LOGIN_USER_.nickname}" default="CMS-User"/>
		  </a>
		  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
		    <a class="dropdown-item" href="/my/home">个人主页</a>
		    <a class="dropdown-item" href="/my/profile">个人设置</a>
		    <a class="dropdown-item" href="/my/articles">我的文章</a>
		    <div class="dropdown-divider"></div>
		    <a class="dropdown-item" href="/logout">退出</a>
		  </div>
		</div>
   	 </li>
    </c:when>
    <c:otherwise>
      <%-- 未登录显示登录注册链接 --%>
	   <li class="nav-item"><a class="nav-link" href="/reg">注册</a></li>
	   <li class="nav-item"><a class="nav-link" href="/login">登录</a></li>
     </c:otherwise>
    </c:choose>
  </ul>
</nav>