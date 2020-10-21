<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
</head>
<body>
    	<div class="content_top">
    		<div class="heading">
    		<h3>Sản phẩm mới</h3>
    		</div>
<%--     		<div class="see">
    			<p><a href="<c:url  value="/trang-chu/newsProduct"/>">See all Products</a></p>
    		</div> --%>
    		<div class="clear"></div>
    	</div>
	    	<c:if test="${ productNews.size() > 0 }">
	    	 <div class="section group">
	    		<c:forEach var="item" items="${ productNews }" varStatus="loop">
	    		   	 <div class="grid_1_of_4 images_1_of_4">
	    			 <a href="preview.html"><img src="template/images/feature-pic1.jpg" alt="" /></a>
					 <h2>${ item.name } </h2>
					 <div class="price-details">
							<div class="price-number">
								<p>
									<span class="rupees"><fmt:formatNumber type="number" groupingUsed="true" value="${ item.price}" />₫  </span>
								</p>
							</div>
							<div class="add-cart">
								<h4>
									<a href="<c:url  value="/trang-chu/xem-truoc"/>">Add to Cart</a>
								</h4>
							</div>
							<div class="clear"></div>
					 </div>
					 </div>
				 <c:if test="${ (loop.index + 1) % 4 == 0 || (loop.index +1) == productNews.size() }">
					  </div>
					<c:if test="${ (loop.index + 1) < productNews.size() }">
					 	 <div class="section group">
					</c:if>
				 </c:if>	
	    			
	    		</c:forEach>	
	    	</c:if>

		<div class="content_bottom">
    		<div class="heading">
    		<h3>Sản phẩm nổi bật</h3>
    		</div>
    		<%-- <div class="see">
    			<p><a href="<c:url  value="/trang-chu/highLight"/>">See all Products</a></p>
    		</div> --%>
    		<div class="clear"></div>
    	</div>

	<c:if test="${ productHighLight.size() > 0 }">
		<div class="section group">
			<c:forEach var="item" items="${ productHighLight }" varStatus="loop">
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
							<h4> <a href="<c:url  value="/trang-chu/xem-truoc"/>">Add to Cart</a> </h4>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<c:if test="${ (loop.index + 1) % 4 == 0 || (loop.index +1) == productHighLight.size() }">
						</div>
				<c:if test="${ (loop.index + 1) < productHighLight.size() }">
					<div class="section group">
				</c:if>
				</c:if>
			</c:forEach>
	</c:if>
	
</body>
</html>