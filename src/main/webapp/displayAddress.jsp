<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>定位商家地图地址</title>
<style type="text/css">
body, html, #map1 {
	width: 100%;
	height: 90%;
	overflow: hidden;
	margin: 0;
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=3.0&ak=FkOcEQbes2zZaZ4BwWia8D9OWbCICLMh"></script>
</head>
<body>
	<div>
			<table>
				<tr>
					<td>经度:<span id="lng">${addP.getLng() }</span>
					</td>
					<td>纬度:<span id="lat">${addP.getLat() }</span></td>
				</tr>
			</table>
	</div>
	<div id="map1"></div>
</body>
<script type="text/javascript" src="panTo.js">
</script>
</html>