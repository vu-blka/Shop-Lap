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
						<h2>Quản lí Phương thức thanh toán</h2>
						<h2>${message }</h2>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									<div class="mail-toolbar clearfix">
										<div class="float-left">


											<a class="btn btn_1 btn-default mrg5R"
												href="admin/payment/insert.htm"><i class="fa fa-plus"></i></a>

											<div class="clearfix"></div>
										</div>
										<div class="float-right">
											<span class="text-muted m-r-sm">Showing ${totalItem} </span>

											<div class="clearfix"></div>
										</div>
									</div>
									<table class="table tab-border">
										<tbody>
											<tr class="unread checked">
												<td class="hidden-xs">Mã thanh toán</td>
												<td class="hidden-xs">Phương thức thanh toán</td>


												<td></td>
											</tr>
											<c:forEach var="item" items="${payments}">
												<tr class="unread checked">
													<td class="hidden-xs">${item.idPayment}</td>
													<td class="hidden-xs">${item.method}</td>

													<td style="text-align: center; width: 150px;"><a
														class="btn btn-default"
														href="admin/payment/update.htm?id=${item.idPayment}"><i
															class="fa fa-edit"></i></a> <a class="btn btn-default"
														href="admin/payment/remove.htm?id=${item.idPayment }"><i
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
