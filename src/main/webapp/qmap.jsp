<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商家地址</title>
</head>
<body>
	<form action="qmap.do" method="post">
		<table>
			<tr>
				<td>请输入商家名称</td>
				<td><input type="text" name="merchantName"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>
</body>
</html>