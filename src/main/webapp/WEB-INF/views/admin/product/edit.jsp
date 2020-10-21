<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="ProductAPI" value="/api/product"/>
<c:url var ="ProductURL" value="/quan-tri/san-pham/danh-sach"/>
<c:url var ="editProductURL" value="/quan-tri/san-pham/chinh-sua"/>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Chỉnh sửa sản phẩm</title>

</head>
<body>
	<div id="content-wrapper">
		<div class="container-fluid">
			  <div class="card mb-3">
			  		<div class="card-header"> <i class="fas fa-table"></i>Cập nhật sản phẩm </div>
			  		 	<div class="card-body">
            				<div class="table-responsive">
            				
            				<c:if test = "${not empty message}">
            					<div class = "alert alert-${alert}">
            							${message}
            					</div>
            				</c:if>
            				
            			 <form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model"> 
            					
            					<div class="form-group"> 
                                	<label class="col-sm-3 control-label no-padding-right">Thể loại sản phẩm</label>
                                	<div class="col-sm-9">
  										<form:select path="categoryCode" id="categoryCode" >
  											<form:option value="" lable="--- Chọn thể loại ---"/>
  											<form:options items="${categories}"/>
  										</form:select>
                                	</div>
                            	</div>
            				
            					<div class="form-group">
                                	<label class="col-sm-3 control-label no-padding-right">Tiêu đề sản phẩm</label>
                                	<div class="col-sm-9">
                                    	<form:input path="title" cssClass="form-control" id="title"  rows="5" cols="10"/>
                                	</div>
                            	</div>
                            	
                            	<div class="form-group">
                                	<label class="col-sm-3 control-label no-padding-right">Tên sản phẩm</label>
                                	<div class="col-sm-9">
                                    	<form:input path="name" cssClass="form-control" id="name"  rows="5" cols="10"/>
                                	</div>
                            	</div>
                            	
                            	<div class="form-group">
                                	<label class="col-sm-3 control-label no-padding-right">Giá sản phẩm</label>
                                	<div class="col-sm-9">
                                    	<form:input path="price" cssClass="form-control" id="price"  rows="5" cols="10"/>
                                	</div>
                            	</div>
                            	
                            	<div class="form-group">
                                	<label for = "shortDescription" class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                                	<div class="col-sm-9">
                                    	<form:input path="shortDescription" cssClass="form-control" id="shortDescription"  rows="5" cols="10"/>
                                	</div>
                            	</div>
                            	
                            	<div class="form-group">
                                	<label class="col-sm-3 control-label no-padding-right">Ảnh đại diện</label>
                                	<div class="col-sm-9">
                                		<form:input path="thumbnail" cssClass="form-control" id="thumbnail"  rows="5" cols="10"/>
                                	</div>
                            	</div>
                            	
                            	<div class="form-group">
                                <label  for = "content" class="col-sm-3 control-label no-padding-right">Nội dung</label>
                                <div class="col-sm-9">                                 
                                    <form:input path="content" rows="5" cols="10" id="content" style="width: 820px;height: 175px" />
                                </div>
                            	</div>
                            	
                            		<form:hidden path="id" id="productId"/>
                            	
                            	<div class="container">

								  	<c:if test="${not empty model.id}">
								 		<button type="button" class="btn btn-info" id="btnAddOrUpdateProduct">Cập nhật sản phẩm</button>
								 	</c:if>
								 	<c:if test="${empty model.id}">
								 		<button type="button" class="btn btn-info" id="btnAddOrUpdateProduct">Thêm sản phẩm</button>
									 </c:if>
						
								  			<button type="button" class="btn btn-info">Hủy</button>
							
								</div>
                            	</form:form>
            				</div>
            		</div>
            	</div>
          </div>
	</div>
	
<script>
 		var editor ='';
		$(document).ready(function(){
			editor = CKEDITOR.replace('content');
		});   
		
		$('#btnAddOrUpdateProduct').click(function (e) {
		    e.preventDefault();
		    var data = {};
		    var formData = $('#formSubmit').serializeArray();
		    $.each(formData, function (i, v) {
	            data[""+v.name+""] = v.value;
	        });
		    var id = $('#productId').val();
		    if (id === "") {
		    	addNew(data);
		    } else {
		    	updateNew(data);
		    }
		});
		
		function addNew(data) {
			$.ajax({
	            url: '${ProductAPI}',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${ProductURL}?page=1&limit=2&message=insert_success";
	            },
	            error: function (error) {
	            	window.location.href = "${ProductURL}?page=1&limit=2&message=error_system";
	            }
	        });
		}
		
		function updateNew(data) {
			$.ajax({
	            url: '${ProductAPI}',
	            type: 'PUT',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${ProductURL}?page=1&limit=2&message=update_success";
	            },
	            error: function (error) {
	            	window.location.href = "${editProductURL}?id="+result.id+"&message=error_system";
	            }
	        });
		}

		
</script>

</body>
</html>