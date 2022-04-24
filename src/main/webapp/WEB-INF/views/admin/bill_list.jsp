<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
</head>
<body>

	<div class="page-container">

		<div class="left-content">

			<div class="mother-grid-inner">

				<jsp:include page="header.jsp"></jsp:include>

				<div class="inner-block">
					<div class="inbox">
						<h2>Quản lí Bill</h2>
						<h3>${message }</h3>
						<br>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									<div class="mail-toolbar clearfix">
										<div class="float-left">


											<div class="clearfix"></div>
										</div>
										<div class="float-right">
											<span class="text-muted m-r-sm">Showing ${countItem}
												of ${totalItem} </span>
											<div class="btn-group">
												<c:if test="${page>1 }">
													<a class="btn btn-default"
														href="admin/product.htm?page=${page-1}"><i
														class="fa fa-angle-left"></i></a>
												</c:if>



												<a class="btn btn-default"
													href="admin/bill.htm?page=${page}"><c:out
														value="${page}" /></a>
												<c:if test="${page<totalPage }">
													<a class="btn btn-default"
														href="admin/bill.htm?page=${page+1}"><c:out
															value="${page+1}" /></a>
												</c:if>
												<c:if test="${page<totalPage }">
													<a class="btn btn-default"
														href="admin/bill.htm?page=${page+1}"><i
														class="fa fa-angle-right"></i></a>
												</c:if>

											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<table class="table tab-border">
										<tbody>
											<tr class="unread checked">
												<td class="hidden-xs">Mã ordered</td>
												<td>Mã bill</td>
												<td>Tình trạng</td>
												<td></td>
											</tr>
											<c:forEach var="item" items="${listBill}">
												<tr class="unread checked">
													<td class="hidden-xs">${item.idOrdered}</td>
													<td class="hidden-xs">${item.idBill}</td>
													<td class="hidden-xs">${item.idAdmin==""?"Chưa kiểm duyệt":""}
														${item.idAdmin!=""&& item.idAdmin!="0"?"Đã kiểm duyệt":""}
														${item.idAdmin=="0"?"Đã hủy":""}</td>


													<td style="text-align: center; width: 150px;"><a
														class="btn btn-default"
														href="admin/bill/detail.htm?id=${item.idOrdered}"><i
															class="fa fa-edit"></i></a></td>


												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>

				<jsp:include page="footer.jsp"></jsp:include>

			</div>

		</div>

		<jsp:include page="navigation.jsp"></jsp:include>

	</div>

</body>
</html>
