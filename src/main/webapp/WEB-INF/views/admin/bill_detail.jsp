<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

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
						<h2>Quản lý người dùng</h2>
						<div class="col-md-12 compose-right">
							<div class="inbox-details-default">
								<div class="inbox-details-heading">Thông tin chi tiết Bill
									${id }</div>
								<div class="inbox-details-body">
									<div class="alert alert-info">${message}</div>
									<form action="admin/bill/update.htm?id=${ordered.idOrdered }"
										class="com-mail" method="POST">
										<h2>Chi tiết Order</h2>
										<p>Mã Ordered: ${ordered.idOrdered }</p>
										<p>Mã Bill: ${ordered.idBill }</p>
										<p>Người kiểm duyệt: ${ordered.idAdmin==""?"Chưa kiểm duyệt":""}
											${ordered.idAdmin!=""&& ordered.idAdmin.trim()!="0"?"Đã kiểm duyệt":""}
											${ordered.idAdmin.trim()=="0"?"Đã hủy":""}</p>

										<br>
										<h2>Chi tiết Bill</h2>
										<p>Tài khoản: ${bill.username }</p>
										<p>Người đặt hàng: ${bill.fullname }</p>
										<p>Số điện thoại: ${bill.phone }</p>
										<p>Mail: ${bill.mail }</p>
										<p>Địa chỉ: ${bill.address }</p>
										<p>Ngày đặt hàng: ${bill.date}</p>
										<p>Note: ${bill.note }</p>
										<p>Phương thức thanh toán: ${bill.payment.method }</p>
										<p>Phương thức giao hàng: ${bill.shipping.method }</p>
										<p>Phí giao hàng: ${bill.shipping.fee }</p>
										<p>
											Tổng tiền hàng:
											<fmt:formatNumber value="${bill.money}" type="number" />
											vnđ
										</p>
										<h2>Danh sách sản phẩm</h2>
										<ul>
											<c:forEach var="item" items="${listOrderedItem }">
												<li style="border: 2px solid black; margin-bottom: 5px;"><a
													href="shop/product-detail.htm?id=${item.product.id }">Mã
														sản phẩm: ${item.product.id } <br> Tên sản phẩm:
														${item.product.name} <br> <img alt=""
														src="<c:url value='/resources/assets/img/${item.product.img }'/>">
														<br> Số lượng: ${item.quantity }
												</a></li>

											</c:forEach>
										</ul>
										<br>
										<c:if test="${ ordered.idAdmin.isEmpty()}">
											<a id="buttonA"
												style='border: none; margin-left: 200px; margin-top: 25px; padding: 15px 30px; width: 100%; border-radius: 5px; cursor: pointer; background-color: #d31531; color: #ffffff; -webkit-transition: 0.5s; transition: 0.5s;'
												data-toggle="modal" data-target="#confirmationid"
												onclick="showConfirmModelDialog()">Duyệt Hóa đơn</a>

											<button id="buttonId" style='display: none' type="submit">Duyệt
												Hóa đơn</button>
										</c:if>


									</form>
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
	<script>
		function showConfirmModelDialog() {
			//$('#confirmationid').modal('show');

			$("#yesId").click(function() {
				$("#buttonId").click();
			})
		}
	</script>

	<div class="modal fade" id="confirmationid" tabindex="-1" role="dialog"
		aria-labelledby="modelTitleId" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">confirmation</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Bạn có muốn tiếp tục ?</div>
				<div class="modal-footer">
					<a type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</a>
					<a id="yesId" type="button" class="btn btn-danger">OK</a>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>
