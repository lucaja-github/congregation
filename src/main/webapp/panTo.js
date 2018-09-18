var lng = document.getElementById("lng");
var lat = document.getElementById("lat");
var a = lng.textContent;
var b = lat.textContent;
var centerPoint = new BMap.Point(a, b);
var map = new BMap.Map("map1");
map.centerAndZoom(centerPoint, 16);
var mk = new BMap.Marker(centerPoint);
map.addOverlay(mk);