<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 20px;">
	抱歉,注册失败！
	失败原因：<%=request.getAttribute("error_type") %>。
</body>
</html>