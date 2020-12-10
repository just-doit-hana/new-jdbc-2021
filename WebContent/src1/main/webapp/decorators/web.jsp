<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file ="/src1/main/webapp/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang Chủ "/></title>
<!-- Test  path link -->
 <%-- <%@include file ="/src1/main/webapp/template/web/jquery/jquery.min.js"%>  --%>
<link href ="<c:url value ='/src1/main/webapp/template/web/bootstrap/css/bootstrap.min.css'/>" rel ="stylesheet" type ="text/css" media ="all" />
<link href ="<c:url value ='/src1/main/webapp/template/web/css/style.css'/>" rel ="stylesheet" type ="text/css" media ="all" />
</head>
<body>
<!-- header -->
       <%@include file ="/src1/main/webapp/common/web/header.jsp" %>
    <!-- header -->
    
    <div class="container">
    	<dec:body/>
    </div>

	<!-- footer -->
 <%@include file ="/src1/main/webapp/common/web/footer.jsp" %>
	<!-- footer -->
	
	<script type="text/javascript" src="<c:url value='/src1/main/webapp/template/web/jquery/jquery.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/src1/main/webapp/template/web/bootstrap/js/bootstrap.bundle.min.js' />"></script>
	
</body>
</html>