<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력처리2</title>
</head>
<body>
	<h1>JSP : Java Server Page</h1>

	<%
		//post일 때 
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("id");
		int userNum = Integer.parseInt(request.getParameter("num"));
		String userFile = request.getParameter("file");
		
		//db처리 , file 처리 - JAVA I/O 필요  
		
		
	%>
	
	<p>아이디 : <%= userId %> </p>
	<p>번호 : <%= userNum %> </p>
	<p>파일 : <%= userFile %> </p>
</body>
</html>