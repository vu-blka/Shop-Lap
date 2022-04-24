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
						<h2>Chi tiết</h2>
						<div class="col-md-12 compose-right">
							<div class="inbox-details-default">

								<div class="inbox-details-body">
									<div class="alert alert-info">${messageF}</div>
									<form class="com-mail"
										action="admin/message/update.htm?id=${message.idMessage}"
										method="POST">
										<p>Người gửi: ${message.name }</p>
										<p>Mail: ${message.email }</p>
										<p>Date: ${message.date }</p>
										<p>Subject: ${message.subject }</p>
										<p>Message: ${message.msg }</p>
										<p>Trạng thái: ${seen==1?"Đã đọc":"Chưa đọc"}</p>
										<c:if test="${seen ==0}">
											<button type="submit">Đánh dấu đã đọc</button>
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
</body>
</html>
