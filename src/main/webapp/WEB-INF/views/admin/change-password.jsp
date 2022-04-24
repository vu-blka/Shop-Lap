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
						<h2>Đổi mật khẩu tài khoản</h2>
						<div class="col-md-12 compose-right">
							<div class="inbox-details-default">
								<div class="inbox-details-heading">Form đổi mật khẩu</div>
								<div class="inbox-details-body">
									<div class="alert alert-info">${msg}</div>
									<form:form action="admin/change-password.htm" class="com-mail"
										method="POST">
										<label>Họ và tên</label>
										<input type="text" name="fullname"
											value="${sessionScope.adminsession.fullname}"
											readonly="readonly" />
										<label>Username</label>
										<input type="text" name="username" readonly="readonly"
											value="${sessionScope.adminsession.username}" />
										<label for="id_name1"><b>Mật khẩu cũ:</b> </label>
										<p>
											<input id="id_name1" "
							name="oldpass" required
												style="width: 300px" />
										</p>
										<form:errors path="oldpass" />

										<label for="id_phone1"><b>Mật khẩu mới:</b> </label>
										<p>
											<input id="id_phone1" "
							name="newpass" required
												style="width: 300px" />
										</p>
										<form:errors path="newpass" />

										<label for="id_mail1"><b>Nhập lại mật khẩu mới:</b> </label>
										<p>
											<input id="id_mail1" name="reNewpass" required
												style="width: 300px" />
										</p>
										<form:errors path="reNewpass" />
										<br>
										<button type="submit">Đổi pass</button>
									</form:form>
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
