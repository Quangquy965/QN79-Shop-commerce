<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="CategoryAPI" value="/api/category"/>
<c:url var ="CategoryURL" value="/quan-tri/the-loai/danh-sach"/>
<c:url var ="editCategoryURL" value="/quan-tri/the-loai/chinh-sua"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa thể loại</title>
</head>
<body>
<div id="content-wrapper">
		<div class="container-fluid">
			  <div class="card mb-3">
			  		<div class="card-header"> <i class="fas fa-table"></i>Cập nhật thể loại </div>
			  		 	<div class="card-body">
            				<div class="table-responsive">
            				
            				<c:if test = "${not empty message}">
            					<div class = "alert alert-${alert}">
            							${message}
            					</div>
            				</c:if>
            				
            				<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
            				
            				
                            	<div class="form-group">
                                	<label class="col-sm-3 control-label no-padding-right">Tên thể loại</label>
                                	<div class="col-sm-9">
                                    	<form:input path="name" cssClass="form-control" id="name"  rows="5" cols="10"/>
                                	</div>
                            	</div>     	
                            	
                            	<div class="form-group">
                                	<label for = "description" class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                                	<div class="col-sm-9">
                                    	<form:input path="description" cssClass="form-control" id="description"  rows="5" cols="10"/>
                                	</div>
                            	</div>
                             	
                            	<div class="form-group">
                                	<label class="col-sm-3 control-label no-padding-right">code thể loại</label>
                                	<div class="col-sm-9">                                 
                                   		<form:input path="code" cssClass="form-control" id="code"  rows="5" cols="10"/>
                                	</div>
                            	</div>
                            	 
                            	
                             	 <form:hidden path="id" id="categoryId"/> 
                            	
                            		<div class="container">

								  		<c:if test="${not empty model.id}">
								 			<button type="button" class="btn btn-info" id="btnAddOrUpdateCategory">Cập nhật thể loại sản phẩm</button>
								 		</c:if>
								 	
								 		<c:if test="${empty model.id}">
								 			<button type="button" class="btn btn-info" id="btnAddOrUpdateCategory">Thêm thể loại sản phẩm</button>
									 	</c:if>
								  			<button type="button" class="btn btn-info">Hủy</button>			
									</div>
                            	 </form:form> 
            				</div>
            		</div>
            	</div>
          </div>
	</div>
	
<script type="text/javascript">
	$('#btnAddOrUpdateCategory').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
	        data[""+v.name+""] = v.value;
	    });
	    var id = $('#categoryId').val();
	    if (id === "") {
	    	addNew(data);
	    } else {
	    	updateNew(data);
	    }
	});
	
	function addNew(data) {
		$.ajax({
            url: '${CategoryAPI}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${CategoryURL}?page=1&limit=2&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${CategoryURL}?page=1&limit=2&message=error_system";
            }
        });
	}
	
	function updateNew(data) {
		$.ajax({
            url: '${CategoryAPI}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${CategoryURL}?page=1&limit=2&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${editCategoryURL}?id="+result.id+"&message=error_system";
            }
        });
	}
</script>
</body>
</html>