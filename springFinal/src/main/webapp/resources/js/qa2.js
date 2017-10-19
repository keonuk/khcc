function find_check() {
	if ($.trim($("#qa_pass").val()) == "") {
		alert("비밀번호를 입력하세요!");
		$("#qa_pass").val("").focus();
		return false;
	}
	if ($.trim($("#qa_subject").val()) == "") {
		alert("글제목을 입력하세요!");
		$("#qa_subject").val("").focus();
		return false;
	}
	if ($.trim($("#qa_content").val()) == "") {
		alert("글내용을 입력하세요!");
		$("#qa_content").val("").focus();
		return false;

	}
}

function ntfind_check() {
	/*if ($.trim($("#nt_name").val()) == "") {
		alert("글쓴이를 입력하세요!");
		$("#nt_name").val("").focus();
		return false;
	}
	if ($.trim($("#nt_pass").val()) == "") {
		alert("비밀번호를 입력하세요!");
		$("#nt_pass").val("").focus();
		return false;
	}*/
	if ($.trim($("#nt_subject").val()) == "") {
		alert("글제목을 입력하세요!");
		$("#nt_subject").val("").focus();
		return false;
	}
	if ($.trim($("#nt_content").val()) == "") {
		alert("글내용을 입력하세요!");
		$("#nt_content").val("").focus();
		return false;
	}
}

function faqfind_check() {
	/*if ($.trim($("#faq_name").val()) == "") {
		alert("글쓴이를 입력하세요!");
		$("#faq_name").val("").focus();
		return false;
	}
	if ($.trim($("#faq_pass").val()) == "") {
		alert("비밀번호를 입력하세요!");
		$("#faq_pass").val("").focus();
		return false;
	}*/
	if ($.trim($("#faq_subject").val()) == "") {
		alert("글제목을 입력하세요!");
		$("#faq_subject").val("").focus();
		return false;
	}
	if ($.trim($("#faq_content").val()) == "") {
		alert("글내용을 입력하세요!");
		$("#faq_content").val("").focus();
		return false;

	}
}

function qnafind_check() {
	/*if ($.trim($("#qna_name").val()) == "") {
		alert("글쓴이를 입력하세요!");
		$("#qna_name").val("").focus();
		return false;
	}
	if ($.trim($("#qna_pass").val()) == "") {
		alert("비밀번호를 입력하세요!");
		$("#qna_pass").val("").focus();
		return false;
	}*/
	if ($.trim($("#qna_subject").val()) == "") {
		alert("글제목을 입력하세요!");
		$("#qna_subject").val("").focus();
		return false;
	}
	if ($.trim($("#qna_content").val()) == "") {
		alert("글내용을 입력하세요!");
		$("#qna_content").val("").focus();
		return false;

	}
}

function write_window() {
	if ($.trim($("#login_email").val()) == ""){
		alert("로그인이 필요한 서비스 입니다!");
		window.location.href = 'khcc_login.nhn';
		/*window.location.href = 'qa_list.nhn';*/
		/*$(location).attr('href','khcc_login.nhn');*/
	}else{
	window.open("qa_write.nhn", "", "width=650,height=500,scrollbars=no");
	}
	// 폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 팝업창을 만듬
}

function ntwrite_window() {
	window.open("nt_write.nhn", "", "width=650,height=500,scrollbars=no");
	// 폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 팝업창을 만듬
}

function faqwrite_window() {
	window.open("faq_write.nhn", "", "width=650,height=500,scrollbars=no");
	// 폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 팝업창을 만듬
}

function qnawrite_window() {
	if ($.trim($("#login_email").val()) == ""){
		alert("로그인이 필요한 서비스 입니다!");
		window.location.href = 'khcc_login.nhn';
	}else{
	window.open("qna_write.nhn", "", "width=650,height=500,scrollbars=no");
	}
	// 폭이 420이고 높이가 200,스크롤바가 생성되는 새로운 팝업창을 만듬
}
