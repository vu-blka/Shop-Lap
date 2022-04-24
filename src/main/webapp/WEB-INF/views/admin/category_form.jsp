<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
								<div class="inbox-details-heading">Form thêm Category</div>
								<div class="inbox-details-body">
									<div class="alert alert-info">${message}</div>
									<form action="admin/category/insert.htm" class="com-mail"
										method="POST">
										<label>Mã category</label>
										<input type="text" name="id" required="required"/>
										
										<br>
										<label>Category</label> <input type="text" name="category" required="required" />
										<button type="submit">Thêm mới</button>
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
