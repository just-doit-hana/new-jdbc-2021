<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/src1/main/webapp/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sach Bai viet</title>
</head>
<body>
	<div class="main-content">
	<form action="'<c:url value="/admin-new"/>'" id="formSubmit" method="GET">

		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trangchủ</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<div class="table-responsive">
							<div class="table table-striped">
								<table class="table table-striped">
									<thead>
										<tr>
											<th scope="col">Name</th>
											<th scope="col">Short Description</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${model.listResultList}">
											<tr>
												<td>${item.title}</td>
												<td>${item.shortDescription }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<!--
								tong so page dua tren 2 yeu to 
								1. tong so item co trong db 
								2.tong item hien thi tren 1 page  
								 -->
								<ul class="pagination" id="pagination"></ul>
								<!--cai nay  la bat buoc phai co de hien thi phan trang leen  -->
								<input type="hidden" value="" id="page" name="page" />
								 <input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
									

						           <input	type="hidden" value="" id="sortName" name="sortName" />
									 
									<input type="hidden" value="" id="sortBy" name="sortBy" /> 
									
									<!-- <input type="hidden" value="" id="type" name="type" />   -->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			</form>
	</div>
	<!-- /.main-content -->
	<!-- function hien thi phan trang  -->
<!-- 	<script type="text/javascript">
    $(function () {
        var totalPage =${model.totalPage};
        var curentPage =${model.page};
        /* var maxPage=${model.maxPageItem};*/
        var limit=2;
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage, /*  tong page la 10 */
            visiblePages: 10,/*so trang hien thi tren giao dien la  3  */
             startPage:curentPage, /* cais page minh dang dung hoac tren ui se hien thi  */
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
           /*  console.info(page + ' (from event listening)'); */
           if(curentPage!=page){
        	   $('#maxPageItem').val(limit); 
               $('#page').val(page);
               $('#formSubmit').submit();
               } 
        });
    });
</script> -->

 <script type="text/javascript">
     var totalPages = ${model.totalPage};
	var currentPage = ${model.page};
	var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages:totalPages;
            visiblePages: 10,
        	startPage: currentPage,
            onPageClick: function (event, page) {
               if(currentPage!=page){
                    $('#maxPageItem').val(limit);
    				$('#page').val(page);
    		        $('#sortName').val('title');
    				$('#sortBy').val('desc'); 
    				$('#formSubmit').submit();
            }
        })
        });
    });
</script> 
</body>
</html>