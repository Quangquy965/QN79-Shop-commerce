<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>

	<!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css' />" type="text/css">

  	<!-- Custom styles for this template -->
  	<link rel="stylesheet" href="<c:url value='/template/web/css/small-business.css' />" type="text/css">
  	
</head>

<body>
	<!-- Head -->
	<%@ include file="/common/web/header.jsp" %>
	
	<div class="container">
	<!-- Body -->
	<dec:body/>
	</div>
	
	<!-- Footer -->
	<%@ include file="/common/web/footer.jsp" %>
	
	<!-- Bootstrap core JavaScript -->
  	<script src="<c:url value = '/template/web/vendor/jquery/jquery.min.js' />"></script>
   	<script src="<c:url value = '/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
</body>

</html>