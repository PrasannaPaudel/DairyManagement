<%--
  Created by IntelliJ IDEA.
  User: MUTHAKA
  Date: 2/5/2015
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%ResultSet resultset = null;%>

<html lang="en">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Cow-Registration </title>

	<!-- modal CSS -->
	<link rel="shortcut icon" href="http://designshack.net/favicon.ico">
	<link rel="icon" href="http://designshack.net/favicon.ico">
	<link rel="stylesheet" type="text/css" media="all" href="style.css">
	<link type='text/css' href="${pageContext.request.contextPath}/resources/css/modal/style.css" rel="stylesheet"
	      media="screen"/>

	<!-- jquery -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modal/jquery-1.9.1.min.js"></script>

	<!-- date picker CSS -->
	<link rel="stylesheet" type="text/css" media="all"
	      href="${pageContext.request.contextPath}/resources/css/jsDatePick_ltr.min.css"/>

	<!-- Bootstrap Core CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">

	<!-- Custom Fonts -->
	<link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet"
	      type="text/css">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>








	<![endif]-->

	<script type="text/javascript">
		window.onload = function () {
			new JsDatePick({
				useMode: 2,
				target: "dob",
				dateFormat: "%d-%M-%Y"
				/*selectedDate:{				This is an example of what the full configuration offers.
				 day:5,						For full documentation about these settings please see the full version of the code.
				 month:9,
				 year:2006
				 },
				 yearsRange:[1978,2020],
				 limitToToday:false,
				 cellColorScheme:"beige",
				 dateFormat:"%m-%d-%Y",
				 imgPath:"img/",
				 weekStartDay:1*/
			});
		};
	</script>


	<!-- modal update cow js -->
	<script type="text/javascript">
		$(document).ready(function () {
			$(".cowUpdate").click(function () { // Click to only happen on announce links
				$("#cowId").val($(this).data('id'));
				$("#cowNo").val($(this).data('no'));
				$("#Status1").val($(this).data('st'));
				$("#breed1").val($(this).data('b'));
				$("#gender1").val($(this).data('g'));
				$("#dob1").val($(this).data('db'));
				$("#relatedTo1").val($(this).data('r'));
				$("#relationship1").val($(this).data('rp'));
				$("#date1").val($(this).data('dt'));
				$('#cowUpdate').modal('show');
			});
		});
	</script>

	<script type="text/javascript">
		window.setTimeout(function () {
			$("#viewGroup_message_alert").fadeTo(500, 0).slideUp(500, function () {
				$(this).add();
			});
		}, 2500);
	</script>

	<script type="text/javascript">
		window.setTimeout(function () {
			$("#loadGroup_message_alert").fadeTo(500, 0).slideUp(500, function () {
				$(this).show();
			});
		}, 2500);
	</script>

	<c:url var="addAction" value="/dairyAdmin/registerCows/save"/>
	<c:url var="updateAction" value="/dairyAdmin/registerCows/save"/>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<c:url var="logout" value="/j_spring_security_logout"/>


</head>


<body>
<%
	try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyFarm?user=root&password=root");
		Statement statement = connection.createStatement();
		resultset = statement.executeQuery("select * from cowregistration WHERE Status='' ");
%>


<div id="wrapper">


	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextPath}/dairyAdmin">Dairy-Farm-Management</a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b
						class="caret"></b></a>
				<ul class="dropdown-menu message-dropdown">
					<li class="message-preview">
						<a href="#">
							<div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>

								<div class="media-body">
									<h5 class="media-heading"><strong>${dairyAdminNm} </strong>
									</h5>

									<p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>

									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div>
							</div>
						</a>
					</li>
					<li class="message-preview">
						<a href="#">
							<div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>

								<div class="media-body">
									<h5 class="media-heading"><strong>${dairyAdminNm} </strong>
									</h5>

									<p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>

									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div>
							</div>
						</a>
					</li>
					<li class="message-preview">
						<a href="#">
							<div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>

								<div class="media-body">
									<h5 class="media-heading"><strong>${dairyAdminNm}</strong>
									</h5>

									<p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>

									<p>Lorem ipsum dolor sit amet, consectetur...</p>
								</div>
							</div>
						</a>
					</li>
					<li class="message-footer">
						<a href="#">Read All New Messages</a>
					</li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b
						class="caret"></b></a>
				<ul class="dropdown-menu alert-dropdown">
					<li>
						<a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
					</li>
					<li>
						<a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
					</li>
					<li>
						<a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
					</li>
					<li>
						<a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
					</li>
					<li>
						<a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
					</li>
					<li>
						<a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#">View All</a>
					</li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${dairyAdminNm} <b
						class="caret"></b></a>
				<ul class="dropdown-menu">
					<li>
						<a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
					</li>
				</ul>
			</li>
		</ul>
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li>
					<a href="${contextPath}/dairyAdmin"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
				</li>
				<li class="active">
					<a href="${contextPath}/dairyAdmin/regHerd"><i class="fa fa-fw fa-edit"></i> Register a Cow</a>
				</li>
				<li>
					<a href="${contextPath}/dairyAdmin/milkProduced"><i class="fa fa-fw fa-edit"></i> Enter Milk
						Produced</a>
				</li>
				<li>
					<a href="${contextPath}/dairyAdmin/breeding"><i class="fa fa-fw fa-edit"></i> Enter Breeding
						Information</a>
				</li>
				<li>
					<a href="${contextPath}/dairyAdmin/mealTaken"><i class="fa fa-fw fa-edit"></i> Enter Meal
						Information</a>
				</li>
				<li>
					<a href="${contextPath}/dairyAdmin/cowHealth"><i class="fa fa-fw fa-edit"></i> Enter Health
						Information</a>
				</li>
				<li>
					<a href="${contextPath}/dairyAdmin/sellMilk"><i class="fa fa-bitbucket"></i> Sell Milk</a>
				</li>
				<li>
					<a href="javascript:;" data-toggle="collapse" data-target="#demo"><i
							class="fa fa-fw fa-arrows-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
					<ul id="demo" class="collapse">
						<li>
							<a href="${contextPath}/dairyAdmin/adminRegistration">Register Another Admin</a>
						</li>
						<li>
							<a href="${contextPath}/dairyAdmin/workerRegistration">Register a Worker</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="#"><i class="fa fa-fw fa-file"></i> Blank Page</a>
				</li>
				<li>
					<a href="rtl.jsp"><i class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>

	<div id="page-wrapper">

		<div class="container-fluid">

			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Registration of Cows
					</h1>
					<ol class="breadcrumb">
						<li>
							<i class="fa fa-dashboard"></i> <a href="${contextPath}/dairyAdmin">Dashboard</a>
						</li>
						<li class="active">
							<i class="fa fa-edit"></i> Forms
						</li>
					</ol>
				</div>
			</div>
			<!-- /.row -->

			<div class="row">
				<c:if test="${not empty error}">
					<div class="alert alert-danger" id="viewGroup_error_alert"><i class="fa fa-ban"></i> ${error}
					</div>
				</c:if>

				<c:if test="${not empty info}">
					<div class="alert alert-info" id="loadGroup_message_alert"><i
							class="fa fa-info-circle"></i> ${info}</div>
				</c:if>
				<form role="form" action="${addAction}" commandName="cowRegistration" method="post">
					<div class="col-lg-6">

						<div class="form-group">
							<label>Breed</label>
							<select class="form-control" name="breed" id="breed">
								<option value="Holstein Friesian">Holstein Friesian</option>
								<option value="Brown Swiss">Brown Swiss</option>
								<option value="Ayrshire">Ayrshire</option>
								<option value="Jersey">Jersey</option>
								<option value="Guernsey">Guernsey</option>

							</select>
						</div>

						<div class="form-group">
							<label>Gender</label>
							<select class="form-control" name="gender" id="gender">
								<option value="Female">Female</option>
								<option value="Male">Male</option>

							</select>
						</div>

						<div class="form-group">
							<label>Date of Birth</label>
							<input class="form-control" type="date" name="dob" id="dob">
						</div>


					</div>


					<div class="col-lg-6">

						<div class="form-group">
							<label>Related-To</label>
							<select class="form-control" name="relatedTo" id="relatedTo">
								<option value="">Not Related</option>
								<% while (resultset.next()) { %>
								<option value="<%= resultset.getString(1)%>"><%= resultset.getString(2)%>
								</option>
								<% } %>

							</select>
						</div>

						<div class="form-group">
							<label>Relationship</label>
							<select class="form-control" name="relationship" id="relationship">
								<option value="">No Relationship</option>
								<option value="Mother">Mother</option>
								<option value="Daughter">Daughter</option>
								<option value="GrandDaughter">GrandDaughter</option>

							</select>
						</div>

						<div class="form-group">
							<%--<label>Status</label>--%>
							<input class="form-control" type="hidden" placeholder="Present" name="status" id="status" readonly>
						</div>


						<button type="submit" class="btn btn-default" id="saveData">Submit Button</button>
						<button type="reset" class="btn btn-default" id="reset">Reset Button</button>


					</div>
				</form>


			</div>
			<c:if test="${not empty message}">
				<div class="alert alert-success" id="viewGroup_message_alert"><i
						class="fa fa-check"></i> ${message}</div>
			</c:if>
			<!-- /.row -->

			<!-- /.display row -->

			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default" >
						<div class="panel-heading">
							<h3 class="panel-title"><i class="fa fa-fw fa-table"></i> Information Feedback</h3>
						</div>
						<c:if test="${!empty listCows}">
							<table class="table table-bordered table-hover table-striped" id="dairyCows">

								<thead>
								<tr>
									<th>Cow-Id</th>
									<th>Breed</th>
									<th>Gender</th>
									<th>Date of Birth</th>
									<th>Related-To</th>
									<th>Relationship</th>
									<th>Date Registered</th>
									<th width="40px"></th>

								</tr>
								</thead>
								<tbody>
								<c:forEach items="${listCows}" var="dairyCows">
									<tr>
										<td>${dairyCows.cowId}</td>
										<td>${dairyCows.breed}</td>
										<td>${dairyCows.gender}</td>
										<td>${dairyCows.dob}</td>
										<td>${dairyCows.relatedTo}</td>
										<td>${dairyCows.relationship}</td>
										<td>${dairyCows.date}</td>
										<td width="40px">
												<%--<a href="<c:url value="/dairyAdmin/registerCows/remove/${dairyCows.cowId}"/>"--%>
												<%--class="btn btn-sm btn-danger"--%>
												<%--data-confirm="Are you sure you want to delete?"><i--%>
												<%--class="ion ion-ios7-trash"></i> Delete</a>--%>

													<a href="#"
													   class="btn btn-danger btn-sm cowUpdate " data-toggle="tooltip"
													   data-placement="top" title="Remove"
													   data-id="${dairyCows.cowId}"
													   data-no="${dairyCows.cowNo}"
													   data-b="${dairyCows.breed}"
													   data-g="${dairyCows.gender}"
													   data-db="${dairyCows.dob}"
													   data-st="${dairyCows.status}"
													   data-r="${dairyCows.relatedTo}"
													   data-rp="${dairyCows.relationship}"
													   data-dt="${dairyCows.date}"><i class="fa fa-bucket">Remove</i></a>
										</td>

									</tr>
								</c:forEach>
								</tbody>
							</table>

						</c:if>
					</div>
				</div>
				+
			</div>

			<!-- /.display row -->


		</div>

		<!-- Modal -->
		<%--Start cow update modal--%>
		<form:form action="${updateAction}" commandName="cowRegistration"
		           id="cowRegistration" method="post">
			<div class="modal fade" id="cowUpdate" tabindex="-1" role="dialog"
			     aria-labelledby="studentsAddition" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header  bg-black">
							<a href="#" class="btn btn-danger btn-sm closebtn" aria-hidden="true"
							   data-dismiss="modal"><i class="ion ion-ios7-trash"></i> Close</a>
							<h4 class="modal-title center" id="cowUpdatemodal">Cow
								Update</h4>
						</div>
						<div class="modal-body" id="modalUpdateCow">
							<div class="row">

								<div class="col-lg-6">
									<label>Cow Id : </label>

									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user-md"></i></span>
										<input class="form-control" type="text" id="cowId" name="cowId"  readonly/>
									</div>
								</div>

								<div class="col-lg-6">
									<label>Reason to Remove Cow :</label>

									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input class="form-control" type="text" id="Status1" name="Status" />
									</div>
								</div>

							</div>
							<br/>

							<div class="row">

								<div class="col-lg-6">
									<%--<label>Breed : </label>--%>

									<div class="input-group">
										<%--<span class="input-group-addon"><i class="fa fa-user-md"></i></span>--%>
										<input class="form-control" type="hidden" id="breed1" name="breed"  readonly/>
									</div>
								</div>

								<div class="col-lg-6">
									<%--<label>Gender : </label>--%>

									<div class="input-group">
										<%--<span class="input-group-addon"><i class="fa fa-user-md"></i></span>--%>
										<input class="form-control" type="hidden" id="gender1" name="gender"  readonly/>
									</div>
								</div>

							</div>

							<div class="row">

								<div class="col-lg-6">
									<%--<label>Cow No : </label>--%>

									<div class="input-group">
										<%--<span class="input-group-addon"><i class="fa fa-user-md"></i></span>--%>
										<input class="form-control" type="hidden" id="cowNo" name="cowNo"  readonly/>
									</div>
								</div>

								<div class="col-lg-6">
									<%--<label>Date of Birth :</label>--%>

									<div class="input-group">
										<%--<span class="input-group-addon"><i class="fa fa-user"></i></span>--%>
										<input class="form-control" type="hidden" id="dob1" name="dob"  readonly/>
									</div>
								</div>

							</div>
							<div class="row">

								<div class="col-lg-6">
									<%--<label>Related To : </label>--%>

									<div class="input-group">
										<%--<span class="input-group-addon"><i class="fa fa-user-md"></i></span>--%>
										<input class="form-control" type="hidden" id="relatedTo1" name="relatedTo" readonly/>
									</div>
								</div>

								<div class="col-lg-6">
									<%--<label>Relationship :</label>--%>

									<div class="input-group">
										<%--<span class="input-group-addon"><i class="fa fa-user"></i></span>--%>
										<input class="form-control" type="hidden" id="relationship1" name="relationship" readonly/>
									</div>
								</div>


							</div>

							<div class="row">

								<div class="col-lg-6">
									<%--<label>Registration Date :</label>--%>

									<div class="input-group">
										<%--<span class="input-group-addon"><i class="fa fa-user"></i></span>--%>
										<input class="form-control" type="hidden" id="date1" name="date" readonly/>
									</div>
								</div>

							</div>

							<div class="row">
								<div class="col-lg-4">
								</div>
								<div class="col-lg-4">
									<button class="btn btn-success pull-right" type="submit">
										<i
												class="fa fa-check-circle-o"></i> Remove
									</button>
								</div>
								<div class="col-lg-4">
									<a href="#" class="btn btn-danger btn-sm closebtn pull-right" aria-hidden="true"
									   data-dismiss="modal"><i class="ion ion-ios7-trash "></i> Cancel</a>
								</div>
								<%--<div class="col-lg-4">--%>
									<%--<button class="btn btn-danger pull-right" type="reset"><i--%>
											<%--class="fa fa-ban"></i>--%>
										<%--Reset--%>
									<%--</button>--%>
								<%--</div>--%>
							</div>
							<br/>
						</div>
						<div class="modal-footer">
							<p class="text-center small-box-footer">Copyrights &copy;
								2015 DFMS |
								Designed &amp;
								Maintained
								by : <a rel="nofollow"
								        href="http://www.api-crafttech.com"
								        target="_blank">PETSAMOD</a> <a
										rel="nofollow"
										href=""></a></p>
						</div>
					</div>
				</div>
			</div>
		</form:form>
		<%--End cow update modal--%>


		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<%--<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>--%>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<!-- Date picker JavaScript -->
<%
	} catch (Exception e) {
		System.out.println("wrong entry" + e);
	}
%>
</body>

</html>






