<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 class="page_title">내 정보 조회</h3>
	<div>
		<span class="label">아이디</span><span>${member.id}</span>
	</div>
	
	<div>
		<span class="label">패스워드</span><span>${member.pw}</span>
	</div>
	
	<div>
		<span class="label">직업</span><span>${member.job}</span>
	</div>	
	
	<div>
		<span class="label">가입동기</span><span>${member.gender}</span>
	</div>
	
	<div>
		<span class="label">성별</span><span>${member.reason}</span>
	</div>
	
	<div>
		<span class="label">메일수신여부</span><span>${member.mailyn}</span>
	</div>
	
	<div>
		<span class="label">취미</span><span>${member.hobby}</span>
	</div>
	
	<div>
		<span class="label">가입일</span><span>${member.regdate}</span>
	</div>
	
	<button type="button" id="btnPage">목록으로</button>
	<script>
		btnPage.addEventListener("click", goPage);
		
		function goPage()
		{
			history.go(-1);
			//location.href="memberAll.jsp";
			//location.assign("memberAll.jsp");
			//history.back();
			//네가지 전부 같은 방법임.
			//Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36 Edg/84.0.522.63"
			//userAgent: "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36"
		}
	</script>


</body>
</html>