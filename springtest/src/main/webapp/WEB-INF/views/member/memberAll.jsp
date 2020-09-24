<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberAll</title>
</head>
<body>

<h3 class="page_title">회원 전체조회</h3>

<div>
	<ul class="search">
		<li>메일수신여부</li>
		<li>성별</li>	
		<li><button type="button">검색</button></li>
	</ul>
</div>

<table id="customers" border="1">
	<thead>
		<tr>
    		<th>아이디</th>
    		<th>비밀번호</th>
   			<th>직업</th>
   			<th>성별</th>
   			<th>가입동기</th>
   			<th>메일수신여부</th>
   			<th>취미</th>
   			<th>가입일</th>
  		</tr>
  	</thead>
  
	<tbody>
		<c:forEach items="${list}" var="temp">
  			<tr>
    			<td><a href="memberSelect?id=${temp.id}">${temp.id}</a></td>
    			<td>${temp.pw}</td>
		    	<td>${temp.job}</td>
		    	<td>${temp.gender}</td>
		    	<td>${temp.reason}</td>
		   	 	<td>${temp.mailyn}
		   	 		<c:if test="${temp.mailyn=='on'}">
		   	 			<button type="button">메일발송</button>
		   	 		</c:if>
		   	 	</td>
		    	<td>${temp.hobby}</td>
		   			<fmt:parseDate value="${temp.regdate}" pattern="yyyy-MM-dd" var="parseDate"/>
		   		<td>
		   			<fmt:formatDate value="${parseDate}" />
		   		</td>
	  		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>