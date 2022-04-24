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
						<h2>Quản lí Tài khoản Admin</h2>
						<h2>${message }</h2>
						<div class="col-md-12 mailbox-content  tab-content tab-content-in">
							<div class="tab-pane active text-style" id="tab1">
								<div class="mailbox-border">
									<div class="mail-toolbar clearfix">
										<div class="float-left">


											<a class="btn btn_1 btn-default mrg5R"
												href="admin/admin/insert.htm"><i class="fa fa-plus"></i></a>

											<div class="clearfix"></div>
										</div>
										<div class="float-right">
											<span class="text-muted m-r-sm">Showing ${countItem}
												of ${totalItem} </span>
											<div class="btn-group">
												<c:if test="${page>1 }">
													<a class="btn btn-default"
														href="admin/admin.htm?page=${page-1}"><i
														class="fa fa-angle-left"></i></a>
												</c:if>



												<a class="btn btn-default"
													href="admin/admin.htm?page=${page}"><c:out
														value="${page}" /></a>
												<c:if test="${page<totalPage }">
													<a class="btn btn-default"
														href="admin/admin.htm?page=${page+1}"><c:out
															value="${page+1}" /></a>
												</c:if>
												<c:if test="${page<totalPage }">
													<a class="btn btn-default"
														href="admin/user.htm?page=${page+1}"><i
														class="fa fa-angle-right"></i></a>
												</c:if>

											</div>
											<div class="clearfix"></div>
										</div>
									</div>
									<table class="table tab-border">
										<tbody>
											<tr class="unread checked">
												<td class="hidden-xs">Username</td>
												<td class="hidden-xs">Fullname</td>

												<td></td>
											</tr>
											<c:forEach var="item" items="${admins}">
												<tr class="unread checked">
													<td class="hidden-xs">${item.username}</td>
													<td class="hidden-xs">${item.fullname}</td>



													<td></td>
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
