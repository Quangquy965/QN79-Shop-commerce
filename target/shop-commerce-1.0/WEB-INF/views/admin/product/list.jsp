<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="UTF-8">
	<title>Danh sách sản phẩm</title>

</head>
<body>
	<div id="content-wrapper">
	  <form action="<c:url value='/quan-tri/san-pham/danh-sach'/>" id="formSubmit" method="get">
		<div class="container-fluid">
			  <div class="card mb-3">
			  		<div class="card-header"> <i class="fas fa-table"></i> Danh sách sản phẩm</div>
			  		 	<div class="card-body">
            				<div class="table-responsive">
            					<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            						 <thead>
                  						<tr>
                    						<th>Tên sản phẩm</th>
                    						<th>Mô tả ngắn</th>
                    						<th>Giá</th>
                    						<th>Thao tác</th>
                  						</tr>
                					</thead>
                					<tfoot>
                  						<c:forEach var="item" items="${model.listResult}">
											<tr>
												<td>${item.name}</td>
												<td>${item.shortDescription}</td>
												<td>${item.price}</td>
												<td>																
												<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
														title="Cập nhật bài viết" href='#'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</a>
												</td>
											 </tr>
										</c:forEach>
                					</tfoot>
            					</table>
            					
            					 <ul class="pagination" id="pagination"></ul>
								 <input type="hidden" value="" id="page" name="page"/>
								 <input type="hidden" value="" id="limit" name="limit"/>	
            				</div>
			  			</div>
			  </div>
		</div>
		</form>
	</div>

	<script>
		    var totalPages = ${model.totalPage};
		    var currentPage = ${model.page};
			$(function() {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages : totalPages,
					visiblePages : 10,
					startPage: currentPage,
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