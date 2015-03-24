<%--
  Created by IntelliJ IDEA.
  User: MUTHAKA
  Date: 2/6/2015
  Time: 7:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true" %>
<html lang="en">

<head>

	<%--<meta charset="utf-8">--%>
	<%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
	<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
	<%--<meta name="description" content="">--%>
	<%--<meta name="author" content="">--%>

	<%--<title>Dairy-Farm-Management</title>--%>

	<%--<!-- Bootstrap Core CSS -->--%>
	<%--<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>

	<%--<!-- Custom CSS -->--%>
	<%--<link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">--%>

	<%--<!-- Custom Fonts -->--%>
	<%--<link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>
	<!-- Graphs -->
	<link rel="shortcut icon" href="/images/favicon2.ico" type="image/x-icon" />
	<link href="/style/demoPages" media="screen" rel="Stylesheet" type="text/css" />
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/graphs/css/visualize.jQuery.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/graphs/css/demopage.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/graphs/js/jquery.min.js"></script>

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<!--<script src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>-->
	<!--<script src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>-->

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/graphs/js/visualize.jQuery.js"></script>
	<script type="text/javascript">

		$(function(){
			$('table').visualize();

			//hide table
			//$('table').addClass('accessHide');

			$('.chartConfiguratorThingy')
					.show()
					.find('.typeOptions>.fieldGroup>input[type=radio]')
					.bind('updateDependencies',function(){
						if($(this).is(':checked')){
							$(this).next().next(':hidden').slideDown(function(){ $(this).find('input,select').removeAttr('disabled');  });
						}
						else{
							$(this).next().next(':visible').slideUp(function(){ $(this).find('input,select').attr('disabled','disabled'); });
						}
					})
					.trigger('updateDependencies')
					.click(function(){ $('.typeOptions>.fieldGroup>input[type=radio]').trigger('updateDependencies'); })
					.end()
					.bind('click keyup',function(){
						var chartOptions = {};
						var formVars = $(this).serialize();
						$.each(formVars.split('&'),function(){
							var thisPair = this.split('=');
							if(thisPair[1]){
								//fix non-string types
								var thisVal = unescape(thisPair[1]);
								//bool true
								if(thisVal == 'true'){ thisVal = true; }
								//bool false
								if(thisVal == 'false'){ thisVal = false; }
								//arrays
								if(thisPair[0] == 'colors' || thisPair[0] == 'textColors'){
									thisVal = thisVal.replace(/[\[\]\']/g,'').split(',');
								}

								chartOptions[thisPair[0]] = thisVal;
							}
						});
						$('.visualize').remove();
						$('table').visualize(chartOptions);
					});

		});
	</script>
	<![endif]-->

</head>

<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:url var="logout" value="/j_spring_security_logout"/>

<%--<div id="wrapper">--%>

	<%--<!-- Navigation -->--%>
	<%--<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">--%>
		<%--<!-- Brand and toggle get grouped for better mobile display -->--%>
		<%--<div class="navbar-header">--%>
			<%--<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">--%>
				<%--<span class="sr-only">Toggle navigation</span>--%>
				<%--<span class="icon-bar"></span>--%>
				<%--<span class="icon-bar"></span>--%>
				<%--<span class="icon-bar"></span>--%>
			<%--</button>--%>
			<%--<a class="navbar-brand" href="${contextPath}/dairyAdmin">Dairy-Farm-Management</a>--%>
		<%--</div>--%>
		<%--<!-- Top Menu Items -->--%>
		<%--<ul class="nav navbar-right top-nav">--%>
			<%--<li class="dropdown">--%>
				<%--<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b--%>
						<%--class="caret"></b></a>--%>
				<%--<ul class="dropdown-menu message-dropdown">--%>
					<%--<li class="message-preview">--%>
						<%--<a href="#">--%>
							<%--<div class="media">--%>
                                    <%--<span class="pull-left">--%>
                                        <%--<img class="media-object" src="http://placehold.it/50x50" alt="">--%>
                                    <%--</span>--%>

								<%--<div class="media-body">--%>
									<%--<h5 class="media-heading">--%>
										<%--<strong>${dairyAdminNm} </strong>--%>
									<%--</h5>--%>

									<%--<p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>--%>

									<%--<p>Lorem ipsum dolor sit amet, consectetur...</p>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</a>--%>
					<%--</li>--%>
					<%--<li class="message-preview">--%>
						<%--<a href="#">--%>
							<%--<div class="media">--%>
                                    <%--<span class="pull-left">--%>
                                        <%--<img class="media-object" src="http://placehold.it/50x50" alt="">--%>
                                    <%--</span>--%>

								<%--<div class="media-body">--%>
									<%--<h5 class="media-heading">--%>
										<%--<strong>${dairyAdminNm} </strong>--%>
									<%--</h5>--%>

									<%--<p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>--%>

									<%--<p>Lorem ipsum dolor sit amet, consectetur...</p>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</a>--%>
					<%--</li>--%>
					<%--<li class="message-preview">--%>
						<%--<a href="#">--%>
							<%--<div class="media">--%>
                                    <%--<span class="pull-left">--%>
                                        <%--<img class="media-object" src="http://placehold.it/50x50" alt="">--%>
                                    <%--</span>--%>

								<%--<div class="media-body">--%>
									<%--<h5 class="media-heading">--%>
										<%--<strong>${dairyAdminNm} </strong>--%>
									<%--</h5>--%>

									<%--<p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>--%>

									<%--<p>Lorem ipsum dolor sit amet, consectetur...</p>--%>
								<%--</div>--%>
							<%--</div>--%>
						<%--</a>--%>
					<%--</li>--%>
					<%--<li class="message-footer">--%>
						<%--<a href="#">Read All New Messages</a>--%>
					<%--</li>--%>
				<%--</ul>--%>
			<%--</li>--%>
			<%--<li class="dropdown">--%>
				<%--<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b--%>
						<%--class="caret"></b></a>--%>
				<%--<ul class="dropdown-menu alert-dropdown">--%>
					<%--<li>--%>
						<%--<a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>--%>
					<%--</li>--%>
					<%--<li class="divider"></li>--%>
					<%--<li>--%>
						<%--<a href="#">View All</a>--%>
					<%--</li>--%>
				<%--</ul>--%>
			<%--</li>--%>
			<%--<li class="dropdown">--%>
				<%--<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${dairyAdminNm} <b--%>
						<%--class="caret"></b></a>--%>
				<%--<ul class="dropdown-menu">--%>
					<%--<li>--%>
						<%--<a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>--%>
					<%--</li>--%>
					<%--<li>--%>
						<%--<a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>--%>
					<%--</li>--%>
					<%--<li class="divider"></li>--%>
					<%--<li>--%>
						<%--<a href="${logout}"><i class="fa fa-fw fa-power-off"></i> Log Out</a>--%>
					<%--</li>--%>
				<%--</ul>--%>
			<%--</li>--%>
		<%--</ul>--%>
		<%--<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->--%>
		<%--<div class="collapse navbar-collapse navbar-ex1-collapse">--%>
			<%--<ul class="nav navbar-nav side-nav">--%>
				<%--<li>--%>
					<%--<a href="${contextPath}/dairyAdmin"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					<%--<a href="${contextPath}/dairyAdmin/registerCows"><i class="fa fa-fw fa-edit"></i> Register a Cow</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					<%--<a href="${contextPath}/dairyAdmin/milkProduced"><i class="fa fa-fw fa-edit"></i> Enter Milk Produced</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					<%--<a href="${contextPath}/dairyAdmin/breeding"><i class="fa fa-fw fa-edit"></i> Enter Breeding Information</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					<%--<a href="${contextPath}/dairyAdmin/mealTaken"><i class="fa fa-fw fa-edit"></i> Enter Meal Information</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					<%--<a href="${contextPath}/dairyAdmin/cowHealth"><i class="fa fa-fw fa-edit"></i> Enter Health--%>
						<%--Information</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					<%--<a href="${contextPath}/dairyAdmin/sellMilk"><i class="fa fa-bitbucket"></i> Sell Milk</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					<%--<a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i>--%>
						<%--Dropdown <i class="fa fa-fw fa-caret-down"></i></a>--%>
					<%--<ul id="demo" class="collapse">--%>
						<%--<li>--%>
							<%--<a href="${contextPath}/dairyAdmin/adminRegistration">Register Another Admin</a>--%>
						<%--</li>--%>
						<%--<li>--%>
							<%--<a href="${contextPath}/dairyAdmin/workerRegistration">Register a Worker</a>--%>
						<%--</li>--%>
					<%--</ul>--%>
				<%--</li>--%>
				<%--<li class="active">--%>
					<%--<a href="${contextPath}/dairyAdmin/blankPage"><i class="fa fa-fw fa-file"></i> Blank Page</a>--%>
				<%--</li>--%>
				<%--<li>--%>
					<%--<a href="rtl.jsp"><i class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a>--%>
				<%--</li>--%>
			<%--</ul>--%>
		<%--</div>--%>
		<%--<!-- /.navbar-collapse -->--%>
	<%--</nav>--%>

	<%--<div id="page-wrapper">--%>

		<%--<div class="container-fluid">--%>

			<%--<!-- Page Heading -->--%>
			<%--<div class="row">--%>
				<%--<div class="col-lg-12">--%>
					<%--<h1 class="page-header">--%>
						<%--Dairy-Farm-Management-System--%>
						<%--<small>Statistics Overview</small>--%>
					<%--</h1>--%>
					<%--<ol class="breadcrumb">--%>
						<%--<li>--%>
							<%--<i class="fa fa-dashboard"></i> <a href="${contextPath}/dairyAdmin">Dashboard</a>--%>
						<%--</li>--%>
						<%--<li class="active">--%>
							<%--<i class="fa fa-file"></i> Blank Page--%>
						<%--</li>--%>
					<%--</ol>--%>
				<%--</div>--%>
			<%--</div>--%>
			<!-- /.row -->


			<form class="chartConfiguratorThingy">
				<h2>Visualize Options:</h2>
				<fieldset class="typeOptions">
					<legend>Chart Type Options</legend>

					<div class="fieldGroup">
						<input type="radio" name="type" id="bar" value="bar" checked="checked" />
						<label for="bar" class="radio">Bar</label>
						<div class="dependencies">
							<div class="fieldGroup">
								<label for="barMargin">barMargin:</label>
								<input type="text" name="barMargin" id="barMargin" value="1" />
							</div>
							<div class="fieldGroup">
								<label for="barGroupMargin">barGroupMargin:</label>
								<input type="text" name="barGroupMargin" id="barGroupMargin" value="10" />
							</div>
						</div>
					</div>
					<div class="fieldGroup">
						<input type="radio" name="type" id="line" value="line" />
						<label for="line" class="radio">Line</label>
						<div class="dependencies">
							<div class="fieldGroup">
								<label for="lineWeight">lineWeight</label>
								<input type="text" name="lineWeight" id="lineWeight" value="4" />
							</div>
						</div>
					</div>
					<div class="fieldGroup">
						<input type="radio" name="type" id="area" value="area" />
						<label for="area" class="radio">Area</label>
						<div class="dependencies">
							<div class="fieldGroup">
								<label for="lineWeight">lineWeight</label>
								<input type="text" name="lineWeight" id="lineWeight" value="4" />
							</div>
						</div>
					</div>
					<div class="fieldGroup">
						<input type="radio" name="type" id="pie" value="pie" />
						<label for="pie" class="radio">Pie</label>
						<div class="dependencies">
							<div class="fieldGroup">
								<label for="pieMargin">pieMargin</label>
								<input type="text" name="pieMargin" id="pieMargin" value="20" />
							</div>
							<div class="fieldGroup">
								<label for="pieLabelPos">pieLabelPos:</label>
								<select name="pieLabelPos" id="pieLabelPos">
									<option value="inside">inside</option>
									<option value="outside">outside</option>
								</select>
							</div>
						</div>
					</div>
				</fieldset>


				<fieldset>
					<legend>Global Options:</legend>

					<div class="fieldGroup">
						<label for="width">Width:</label>
						<input type="text" name="width" id="width" value="" />
					</div>

					<div class="fieldGroup">
						<label for="height">Height:</label>
						<input type="text" name="height" id="height" value="" />
					</div>

					<div class="fieldGroup">
						<label for="appendTitle">appendTitle:</label>
						<select name="appendTitle" id="appendTitle">
							<option value="true">True</option>
							<option value="false">False</option>
						</select>
					</div>

					<div class="fieldGroup">
						<label for="title">title:</label>
						<input type="text" name="title" id="title" value="" />
					</div>

					<div class="fieldGroup">
						<label for="appendKey">appendKey:</label>
						<select name="appendKey" id="appendKey">
							<option value="true">True</option>
							<option value="false">False</option>
						</select>
					</div>

					<div class="fieldGroup">
						<label for="colors">colors:</label>
						<input type="text" name="colors" id="colors" value="['#be1e2d','#666699','#92d5ea','#ee8310','#8d10ee','#5a3b16','#26a4ed','#f45a90','#e9e744']" />
					</div>

					<div class="fieldGroup">
						<label for="textColors">textColors:</label>
						<input type="text" name="textColors" id="textColors" value="[]" />
					</div>

					<div class="fieldGroup">
						<label for="parseDirection">parseDirection:</label>
						<select name="parseDirection" id="parseDirection">
							<option value="x">x</option>
							<option value="y">y</option>
						</select>
					</div>

				</fieldset>

			</form>

			<!--<div style="float:right">
				<form class="chartConfiguratorThingy" action="" method="post">
					<div class="fieldGroup">
							<label for="title">Name:</label>
							<select name="name" id="title" >
								<option value="Brad">Brad</option>
								<option value="Mary">Mary</option>
								<option value="Kate">Kate</option>
								<option value="Tom">Tom</option>
							</select>
						</div>
						<div class="fieldGroup">
							<label for="title">Apple:</label>
							<input type="text" name="apple" id="title" value="" />
						</div>
						<div class="fieldGroup">
							<label for="title">Guava:</label>
							<input type="text" name="guava" id="title" value="" />
						</div>
						<div class="fieldGroup">
							<label for="title">Mango:</label>
							<input type="text" name="mango" id="title" value="" />
						</div>
						<div class="fieldGroup">
							<label for="title">Pawpaw:</label>
							<input type="text" name="pawpaw" id="title" value="" />
						</div>
						<div class="fieldGroup">
							<label for="title">Orange:</label>
							<input type="text" name="orange" id="title" value="" />
						</div>
						<div class="fieldGroup">
							<label for="title">Lemon:</label>
							<input type="text" name="lemon" id="title" value="" />
						</div>
						<div class="fieldGroup">
							<input type="submit" name="submit" id="submit" value="submit" />
						</div>


				</form>
			</div>-->

			<div style="float:">


					<form role="form">

						<h4>Milk Production Information</h4>

						<div id="mydata">
							<br/>
							<c:if test="${not empty error}">
								<div class="alert alert-danger" id="viewGroup_error_alert"><i class="fa fa-ban"></i> ${error}
								</div>
							</c:if>
							<c:if test="${not empty message}">
								<div class="alert alert-success" id="viewGroup_message_alert"><i
										class="fa fa-check"></i> ${message}</div>
							</c:if>
							<c:if test="${not empty info}">
								<div class="alert alert-info" id="loadGroup_message_alert"><i
										class="fa fa-info-circle"></i> ${info}</div>
							</c:if>
							<br/>

							<c:if test="${!empty listMilkProduced}">
								<table  id="milkProduced">

									<thead>
									<tr>
										<th>Cow-Id</th>
										<th>Amount-Produced</th>

									</tr>
									</thead>
									<tbody>
									<c:forEach items="${listMilkProduced}" var="milkProduced">
										<tr>
											<td>${milkProduced.cowId}</td>
											<td>${milkProduced.amountProduced}</td>

										</tr>
									</c:forEach>
									</tbody>
								</table>

							</c:if>

							<c:if test="${empty listMilkProduced}">
								<table id="milkProduced"  width="100%" cellspacing="0">
									<thead>
									<tr>
										<th>Cow-Id</th>
										<th>Amount-Produced</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${listMilkProduced}" var="milkProduced">

									</c:forEach>
									</tbody>
								</table>
							</c:if>

						</div>


					</form>

			</div>





		<%--</div>--%>
		<%--<!-- /.container-fluid -->--%>

	<%--</div>--%>
	<%--<!-- /#page-wrapper -->--%>

<%--</div>--%>
<%--<!-- /#wrapper -->--%>

<%--<!-- jQuery -->--%>
<%--&lt;%&ndash;<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>&ndash;%&gt;--%>

<%--<!-- Bootstrap Core JavaScript -->--%>
<%--<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>--%>

</body>

</html>
