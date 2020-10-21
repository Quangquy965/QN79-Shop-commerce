<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sản phẩm</title>

</head>
<body>
 <form action="<c:url value='/trang-chu/san-pham'/>" id="formSubmit" method="get">
	<div class="section group">
	  <c:forEach var="item" items="${model.listResult}">
		<div class="grid_1_of_4 images_1_of_4">
			<a href="preview.html"><img src="images/feature-pic1.jpg" alt="" /></a>
			<h2>${item.name}</h2>
			<div class="price-details">
				<div class="price-number">
					<p>
						<span class="rupees">${ item.price }</span>
					</p>
					<div class="add-cart">
						<h4>
							<a href="preview.html">Add to Cart</a>
						</h4>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>

	<ul class="pagination" id="pagination"></ul>
	<input type="hidden" value="" id="page" name="page"/>
	<input type="hidden" value="" id="limit" name="limit"/>
	<style type="text/css">
		.pagination {
	display: flex;
	justify-content: center;
		}
	</style>
</form>

	<script type="text/javascript">
	
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages : 10,
				startPage : currentPage,
				onPageClick : function(event, page) {
					if (currentPage != page) {
						$('#limit').val(2);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
				}
			});
		});
	</script>

</body>

</html>