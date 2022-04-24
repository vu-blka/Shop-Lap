<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
						<h2>Cập nhật sản phẩm</h2>
						<div class="col-md-12 compose-right">
							<div class="inbox-details-default">
								<div class="inbox-details-heading">Form chỉnh sửa thông
									tin sản phẩm</div>
								<div class="inbox-details-body">
									<div class="alert alert-info">${message}</div>
									<form class="com-mail"
										action="admin/product/update.htm?id=${product.id}"
										method="POST">
										<label>Id</label> <input type="text" name="id"
											value="${product.id}" readonly /> <label>Tên sản
											phẩm</label> <input type="text" name="name" value="${product.name}" />
										<label>Giá</label> <input type="number" name="price"
											value="${product.price}" /> <label>Số lượng</label> <input
											type="number" name="quantity" value="${product.quantity}" />
										<label>Số lượng đã bán</label> <input type="number"
											name="quantitySold" value="${product.quantitySold}" /> <label>Sale</label>
										<input type="number" name="sale" value="${product.sale}" /> <br>
										<label>Hình ảnh hiện tại của sản phẩm: <span style="color: red">${product.img }</span>
										</label> <br> <label>Chọn hình ảnh nếu thay đổi: <input
											type="file" name="photo" value="${product.img }"/>
										</label> <br> <label>Thể loại</label> <select name="category">
											<c:forEach var="item" items="${categories }">
												<c:if test="${item.category==product.category.category }">
													<option value="${item.id }" selected>${item.category }</option>
												</c:if>
												<c:if test="${item.category!=product.category.category }">
													<option value="${item.id }">${item.category }</option>
												</c:if>
											</c:forEach>

										</select> <br> <label>Thương hiệu</label> <select name="brand">
											<c:forEach var="item" items="${brands }">
												<c:if test="${item.brand==product.brand.brand }">
													<option value="${item.id }" selected>${item.brand }</option>
												</c:if>
												<c:if test="${item.brand!=product.brand.brand }">
													<option value="${item.id }">${item.brand }</option>
												</c:if>
											</c:forEach>

										</select> <br>
										<label>Rate</label> <input type="text" name="rate"
											value="${product.rate}" readonly />
										<br> <label>Description</label>
										<textarea rows="6" name="description"><c:out
												value="${product.description}" /></textarea>
										<br>
										<button type="submit">Cập nhật</button>
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
</body>
</html>
