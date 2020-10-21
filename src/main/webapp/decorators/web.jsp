<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><dec:title default="Trang chủ" /></title>
    


    <!-- css -->
    <link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all"/>
    <link href="<c:url value='/template/web/css/slider.css' />" rel="stylesheet" type="text/css" media="all"/>
    
    <!-- phân trang -->
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"> 
   <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
    
</head>
<body>

	<div class="wrap">
	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    
    <!-- header -->
   	 <%@ include file="/common/web/menu.jsp" %>
   	 <!-- body -->
   	 <div class="main">
    	<div class="content">
    		<dec:body/>
    	</div>
    </div>

	</div>
	
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->
	
	<script type="text/javascript" src="<c:url value='/template/web/js/jquery-1.7.2.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/template/web/js/move-top.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/easing.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/startstop-slider.js' />"></script>

	<script src='<c:url value="/template/paging/jquery.twbsPagination.js" />'></script>


	
</body>
</html>