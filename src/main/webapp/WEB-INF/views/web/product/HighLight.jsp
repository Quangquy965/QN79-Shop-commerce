<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ HighLight.size() > 0 }">
		<div class="section group">
			<c:forEach var="item" items="${ HighLight }" varStatus="loop">
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview.html"><img src="template/images/feature-pic2.jpg" alt="" /></a>
					<h2>${ item.name }</h2>
					<div class="price-details">
						<div class="price-number">
							<p>
								<span class="rupees"><fmt:formatNumber type="number" groupingUsed="true" value="${ item.price}" />₫ </span>
							</p>
						</div>
						<div class="add-cart">
							<h4> <a href="#">Add to Cart</a> </h4>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<c:if test="${ (loop.index + 1) % 4 == 0 || (loop.index +1) == HighLight.size() }">
						</div>
				<c:if test="${ (loop.index + 1) < HighLight.size() }">
					<div class="section group">
				</c:if>
				</c:if>
			</c:forEach>
	</c:if>
</body>
</html>