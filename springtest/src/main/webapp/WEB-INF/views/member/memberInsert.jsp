<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	function inputCheck(){
		//id, pw 필수입력체크
		if(frm.id.value == ""){
			window.alert("id 입력");
			frm.id.focus();
			return false;
		}
		if(frm.password.value == ""){
			alert("pw 입력하세요.")
			frm.pw.focus();
			return false;
		}
		if(frm.job.value == ""){
			alert("일단 선택은 하세요.")
			frm.job.focus();
			return false;
		}
		
		var gender = document.querySelectorAll("[name='gender']:checked").length;
		if(gender == 0){
			alert("성별 적어도 하나는 선택");
			return false;
		}
		
		// 회원가입폼 제출
		//frm.submit();
		return true;
	}
</script>
</head>

<body>
<form method="post" name="frm" id="frm" action="memberInsert"
onsubmit="return inputCheck()">

	<div>
		<h3 class="page_title">회원등록</h3>
		<div class="regist">
			<label for="id">Id</label>
			<input type="text" id="id" name="id">
		</div>
		
		<div>
			<label for="password">pw</label>
			<input type="password" id="password" name="pw">
		</div>
		
		<div>
			<input type="radio" value="male" id="man" name="gender">
			<label for="man">남자</label>
			<input type="radio" value="female" id="woman" name="gender">
			<label for="woman">여자</label>
		</div>
		
		<div>
			<label for="select">직업</label>
			<select id="select" name="job" size="4">
				<option value="">선택</option>
				<option value="degin">디자이너</option>
				<option value="programer">프로그래머</option>
				<option value="stu">학생</option>
				<option value="sal">회사원</option>
				<option value="teach">교사</option>
				<option value="profe">교수</option>
			</select>
		</div>
		
		<div>
			<label for="reason">가입동기</label>
			<textarea id="reason" placeholder="가입동기를 적으시오" name="reason" ></textarea>
		</div>
		
		<div>
			<label for="mailyn">메일수신여부</label>
			<input type="checkbox" id="mailyn" name="mailyn">
		</div>
		
		<div>
			<label for="select">취미</label>
			<input type="checkbox" value="read" name="hobby">독서
			<input type="checkbox" value="game" name="hobby">게임
			<input type="checkbox" value="ski" name="hobby">스키

		</div>
		
		<div>
			<button>등록</button>
			<button type="reset">초기화</button>
		</div>
		
		
	</div>
</form>
</body>
</html>