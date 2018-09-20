<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传商品</title>
</head>
<body>
	<form action="upload.do" enctype="multipart/form-data" method="post">
		<table>
			<tr>
				<td>商品名称:</td>
				<td><input type="text" name="goodsName"></td>
			</tr>
			<tr>
				<td>商品价格:</td>
				<td><input type="text" name="goodsPrice"></td>
			</tr>
			<tr>
				<td>提供数量:</td>
				<td><input type="text" name="goodsStock"></td>
			</tr>
			<tr>
				<td>商品图片:</td>
				<td><input type="file" name="goodsPic"></td>
			</tr>
			<tr>
				<td>商品描述:</td>
				<td><textarea rows="3" cols="20" name="goodsAtt"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>