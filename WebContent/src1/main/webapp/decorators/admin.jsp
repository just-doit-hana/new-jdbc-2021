<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <%@include file ="/src1/main/webapp/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title><dec:title default="Trang Chủ "/></title>
<!-- Test Path Link -->
 <%-- <%@include file ="/src1/main/webapp/template/web/jquery/jquery.min.js"%>   --%>
<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="<c:url value ='/src1/main/webapp/template/admin/assets/css/bootstrap.min.css'/>" rel ="stylesheet" type ="text/css" media ="all"/>
		<link rel="stylesheet" href="<c:url value ='/src1/main/webapp/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css'/>" rel ="stylesheet" type ="text/css" media ="all" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="<c:url value ='/src1/main/webapp/template/admin/assets/fonts/fonts.googleapis.com.css'/>" rel ="stylesheet" type ="text/css" media ="all" />

		<!-- ace styles -->
		<link rel="stylesheet" href="<c:url value ='/src1/main/webapp/template/admin/assets/css/ace.min.css'/>" rel ="stylesheet" type ="text/css" media ="all" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->

		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->
		<script src="/src1/main/webapp/template/admin/assets/js/ace-extra.min.js"></script>

		<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>
<body class="no-skin">

<!-- header -->
       <%@include file ="/src1/main/webapp/common/admin/header.jsp" %>
    <!-- header -->
    
    <div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
		<!-- menu -->
    	 <%@include file ="/src1/main/webapp/common/admin/menu.jsp" %>
    	<!-- menu -->
		
		<dec:body/>
		
		<!-- footer -->
    	 <%@include file ="/src1/main/webapp/common/admin/footer.jsp" %>
    	<!-- footer -->
    	
    	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	
    <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>
	
	<!-- page specific plugin scripts -->
	<script src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>