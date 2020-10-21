<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var ="CategoryURL" value="/quan-tri/the-loai/danh-sach"/>
<c:url var="CategoryAPI" value="/api/category"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thể loại</title>
</head>
<body>
<div id="content-wrapper">
	   <form action="<c:url value='/quan-tri/the-loai/danh-sach'/>" id="formSubmit" method="get"> 
		<div class="container-fluid">
			  <div class="card mb-3">
			  		<div class="card-header"> <i class="fas fa-table"></i> Danh sách thể loại</div>
			  		 	<div class="card-body">
            				<div class="table-responsive">
            				
            				<c:if test = "${not empty message}">
            					<div class = "alert alert-${alert}">
            							${message}
            					</div>
            				</c:if>
            				
            				<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												  <c:url var="creatCategoryURL" value="/quan-tri/the-loai/chinh-sua"/> 
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='Thêm thể loại' href="${creatCategoryURL}">
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa thể loại'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
												</button>
											</div>
										</div>
									</div>
								</div>
            								
            					<table class="table table-dark">
            						 <thead>
                  						<tr>
                  							<th><input type="checkbox" id="checkAll"></th>
                    						<th>Tên thể loại</th>
                    						<th>Mô tả ngắn</th>
                    						<th>code thể loại</th>
                    						<th>Thao tác</th>
                  						</tr>
                					</thead>
                					 <tbody>
                  						  <c:forEach var="items" items="${model.listResult}">  
											<tr>
												<td><input type="checkbox" id="checkbox_${items.id}" value="${items.id}"></td>
												<td> ${items.name} </td>
												<td> ${items.description} </td>
												<td> ${items.code} </td>
												<td>			
													<c:url var ="updateCategoryURL" value ="/quan-tri/the-loai/chinh-sua">
														<c:param name="id" value="${items.id}" />
													</c:url>										
												<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
														title="Cập nhật thể loại" href="${updateCategoryURL}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
												</a>
												</td>
											 </tr>
									  	</c:forEach>  
                					 </tbody>
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
 		    var totalPages =${model.totalPage};
		    var currentPage =${model.page};
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
			
			function warningBeforeDelete() {
				swal({
				  title: "Xác nhận xóa",
				  text: "Bạn có chắc chắn muốn xóa hay không",
				  type: "warning",
				  showCancelButton: true,
				  confirmButtonClass: "btn-success",
				  cancelButtonClass: "btn-danger",
				  confirmButtonText: "Xác nhận",
				  cancelButtonText: "Hủy bỏ",
				}).then(function(isConfirm) {
				  if (isConfirm ) {
					  
						var ids = $('tbody input[type=checkbox]:checked').map(function () {
				            return $(this).val();
				        }).get();
						deleteNew(ids);
				  }
				});
		} 
		function deleteNew(data) {
	        $.ajax({
	            url: '${CategoryAPI}',
	            type: 'DELETE',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            success: function (result) {
	            	window.location.href = "${CategoryURL}?page=1&limit=2&message=delete_success";
	            },
	            error: function (error) {
	            	window.location.href = "${CategoryURL}?page=1&limit=2&message=error_system";
	            }
	        });
	    }
			
	</script>

</body>
</html>