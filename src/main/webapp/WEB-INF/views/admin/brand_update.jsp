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
						<h2>Cập nhật Phương thức Thanh toán</h2>
						<div class="col-md-12 compose-right">
							<div class="inbox-details-default">
								<div class="inbox-details-heading">Form chỉnh sửa thông
									tin phương thức thanh toán</div>
								<div class="inbox-details-body">
									<div class="alert alert-info">${message}</div>
									<form class="com-mail"
										action="admin/brand/update.htm?id=${brand.id}"
										method="POST">
										<label>Mã thương hiệu</label> <input type="text" name="id"
											value="${brand.id}" readonly /> <label>Tên
											thương hiệu</label> <input type="text" name="brand"
											value="${brand.brand}" /> <br>
											<label>Hình ảnh hiện tại của thương hiệu: <span style="color: red">${brand.img }</span>
											<img alt="" src="<c:url value='/resources/assets/img/${brand.img }'/>">
										</label> <br> <label>Chọn hình ảnh nếu thay đổi: <input
											type="file" name="photo" value="${brand.img }"/>
										</label> 
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
