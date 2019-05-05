<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>纯JS省市区联动</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/address_own.js"></script>
</head>
<body>
<div>
    省份：<select id="province"></select>
    市：<select id="city"></select>
    地区：<select id="area"></select>
    <br /><br />
    省份：<select id="Select1"></select>
    市：<select id="Select2"></select>
    地区：<select id="Select3"></select>
    <script type="text/javascript">
        addressInit('province', 'city', 'area', '北京', '直辖市', '东城区'); //赋值
        addressInit('Select1', 'Select2', 'Select3'); //必须写，不然如法实现
    </script>
</div>
</body>
</html>
