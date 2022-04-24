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
						<h2>Quản lí Message</h2>
						<h2>${message }</h2>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									<div class="mail-toolbar clearfix">
										<div class="float-left">




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
												<td class="hidden-xs">Mã Message</td>
												<td class="hidden-xs">Mail</td>
												<td class="hidden-xs">Date</td>
												<td class="hidden-xs">Subject</td>
												<td class="hidden-xs">Trạng thái</td>

												<td></td>
											</tr>
											<c:forEach var="item" items="${messages}">
												<tr class="unread checked">
													<td class="hidden-xs">${item.idMessage}</td>
													<td class="hidden-xs">${item.email}</td>
													<td class="hidden-xs">${item.date}</td>
													<td class="hidden-xs">${item.subject}</td>
													<td class="hidden-xs">${item.seen=="0"?"Chưa đọc":"Đã đọc"}</td>
													<td style="text-align: center; width: 150px;"><a
														class="btn btn-default"
														href="admin/message/detail.htm?id=${item.idMessage }"><i
															class="fa fa-edit"></i></a> <a class="btn btn-default"
														href="admin/message/remove.htm?id=${item.idMessage }"><i
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
