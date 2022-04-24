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
						<h2>Insert New Product</h2>
						<div class="col-md-12 compose-right">
							<div class="inbox-details-default">
								<div class="inbox-details-heading">Compose New Message</div>
								<div class="inbox-details-body">
									<div class="alert alert-info">${message }</div>
									<form class="com-mail" action="admin/product/insert.htm"
										method="POST">
										<label>Tên sản phẩm</label> <input type="text"
											placeholder="Nhập tên sản phẩm" name="name"
											required="required" /> <label>Giá</label> <input type="text"
											placeholder="Nhập giá sản phẩm" name="price"
											required="required" /> <label>Sale</label> <input type="text"
											placeholder="Nhập sale" name="sale" required="required" /> <label>Số
											lượng</label> <input type="text" placeholder="Nhập số lượng hiện có"
											name="quantity" required="required" /> <br> <label>Thể
											loại</label> <select name="category" required="required">
											<c:forEach var="item" items="${categories }">
												<option value="${item.id }">${item.category }</option>
											</c:forEach>

										</select> <br> <label>Thương hiệu</label> <select name="brand"
											required="required">
											<c:forEach var="item" items="${brands }">
												<option value="${item.id }">${item.brand }</option>
											</c:forEach>

										</select> <br>
										<label>Hình ảnh</label> <input type="file" placeholder="..."
											name="photo" required="required" /> <label>Description</label>

										<textarea rows="6" cols="10" name="description"
											required="required"></textarea>

										<button type="submit">Insert</button>
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
