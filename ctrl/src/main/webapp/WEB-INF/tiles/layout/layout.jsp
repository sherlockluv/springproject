<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>        
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper">
<div id="header">
<tiles:insertAttribute name="header" />
</div>
<div id="01_topbar">
<tiles:insertAttribute name="01_topbar" />
</div>
<div id="content">
<tiles:insertAttribute name="content" />
</div>
<div id="footer">
<tiles:insertAttribute name="footer" />
</div>
</div>
</body>
</html>