<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
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
						<h2>Product Manage</h2>
						<br>
						<p>${message }</p>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									<div class="mail-toolbar clearfix">
										<div class="float-left">
											<a class="btn btn_1 btn-default mrg5R"
												href="${pageContext.request.contextPath}/admin/product/insert.htm"><i
												class="fa fa-plus"></i></a>

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
													href="admin/product.htm?page=${page}"><c:out
														value="${page}" /></a>
												<c:if test="${page<totalPage }">
													<a class="btn btn-default"
														href="admin/product.htm?page=${page+1}"><c:out
															value="${page+1}" /></a>
												</c:if>
												<c:if test="${page<totalPage }">
													<a class="btn btn-default"
														href="admin/product.htm?page=${page+1}"><i
														class="fa fa-angle-right"></i></a>
												</c:if>

											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<table class="table tab-border">
										<tbody>
											<tr class="unread checked">
												<td class="hidden-xs">Mã SP</td>
												<td class="hidden-xs">Tên Sản Phẩm</td>
												<td>Category</td>
												<td>Brand</td>
												<td>Số lượng</td>

												<td>Giá</td>
												<td>Sale</td>
												<td>Đã bán</td>
												<td>Mô tả</td>
												<td>Hình ảnh</td>
												<td>Rate</td>
												<td></td>
											</tr>
											<c:forEach var="item" items="${listProduct}">
												<tr class="unread checked">
													<td class="hidden-xs">${item.id}</td>
													<td class="hidden-md">${item.name}</td>
													<td class="hidden-md">${item.category.category}</td>
													<td>${item.brand.brand}</td>
													<td>${item.quantity }</td>
													<td><fmt:formatNumber value="${item.price}"
															type="number" /> VNĐ</td>
													<td>${item.sale }%</td>
													<td>${item.quantitySold }</td>
													<td>...</td>
													<td>${item.img }</td>
													<td>${item.rate }</td>
													<td style="text-align: center; width: 150px;"><a
														class="btn btn-default"
														href="admin/product/update.htm?id=${item.id}"><i
															class="fa fa-edit"></i></a> <a class="btn btn-default"
														href="admin/product/remove.htm?id=${item.id }"><i
															class="fa fa-remove"></i></a></td>
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
