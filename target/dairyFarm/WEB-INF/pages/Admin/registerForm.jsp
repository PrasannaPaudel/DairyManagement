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
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>

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
    <link type='text/css' href="${pageContext.request.contextPath}/resources/css/modal/style.css" rel="stylesheet" media="screen" />

    <!-- date picker CSS -->
    <link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/css/jsDatePick_ltr.min.css" />

  <!-- Bootstrap Core CSS -->
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modal/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/js/modal/jquery.leanModal.min.js"></script>



  <script type="text/javascript">
      window.onload = function(){
          new JsDatePick({
              useMode:2,
              target:"dob",
              dateFormat:"%d-%M-%Y"
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

<!-- modal JavaScript -->
    <script type="text/javascript">
        $(function(){
            $('#loginform').submit(function(e){
                return false;
            });

            $('#modaltrigger').leanModal({ top: 110, overlay: 0.45, closeButton: ".hidemodal" });
        });
    </script>

  <![endif]-->
    <c:url var="addAction" value="/dairyAdmin/registerCows/save"/>
    <c:url var="updateAction" value="/dairyAdmin/registerCows/save"/>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <c:url var="logout" value="/j_spring_security_logout"/>


</head>


<body >
<%
    try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dairyFarm?user=root&password=root");
        Statement statement = connection.createStatement() ;
        resultset =statement.executeQuery("select * from cowregistration WHERE Status=''") ;
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
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
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
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
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
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${dairyAdminNm} <b class="caret"></b></a>
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
        <li >
          <a href="${contextPath}/dairyAdmin"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
        </li>
        <li class="active">
          <a href="${contextPath}/dairyAdmin/registerCows"><i class="fa fa-fw fa-edit"></i> Register a Cow</a>
        </li>
        <li>
          <a href="${contextPath}/dairyAdmin/milkProduced"><i class="fa fa-fw fa-edit"></i> Enter Milk Produced</a>
        </li>
        <li>
          <a href="${contextPath}/dairyAdmin/breeding"><i class="fa fa-fw fa-edit"></i> Enter Breeding Information</a>
        </li>
        <li>
          <a href="${contextPath}/dairyAdmin/mealTaken"><i class="fa fa-fw fa-edit"></i> Enter Meal Information</a>
        </li>
          <li>
              <a href="${contextPath}/dairyAdmin/cowHealth"><i class="fa fa-fw fa-edit"></i> Enter Health Information</a>
          </li>
        <li>
          <a href="${contextPath}/dairyAdmin/sellMilk"><i class="fa fa-bitbucket"></i> Sell Milk</a>
        </li>
        <li>
          <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
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


        <!-- Modal -->
        <%--<div id="w">--%>
            <%--<div id="content">--%>
                <%--<h1>Reason To Remove The Cow From The Herd </h1>--%>
                <%--<p>Just system.</p>--%>
                <%--<center><a href="#loginmodal" class="flatbtn" id="modaltrigger">Cow Status</a></center>--%>
            <%--</div>--%>
        <%--</div>--%>
        <div id="loginmodal" style="display:none;">
            <h1>User Login</h1>
            <form id="loginform" name="loginform" method="post" action="${updateAction}" commandName="cowRegistration">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" class="txtfield" tabindex="1">

                <label >Password:</label>
                <input type="text" name="status" id="statusupdate" class="txtfield" tabindex="2">

                <div class="center"><input type="submit" name="loginbtn" id="loginbtn" class="flatbtn-blu hidemodal" value="Log In" tabindex="3"></div>
            </form>
        </div>







        <!-- Page Heading -->
      <div class="row">
        <div class="col-lg-12">
          <h1 class="page-header">
            Registration of Cows
          </h1>
          <ol class="breadcrumb">
            <li>
              <i class="fa fa-dashboard"></i>  <a href="${contextPath}/dairyAdmin">Dashboard</a>
            </li>
            <li class="active">
              <i class="fa fa-edit"></i> Forms
            </li>
          </ol>
        </div>
      </div>
      <!-- /.row -->

      <div class="row">
          <form role="form"  action="${addAction}" commandName="cowRegistration" method="post">
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
            <div class="form-group">
                <label>Status</label>
                <input class="form-control" name="status" id="status">
            </div>

        </div>


        <div class="col-lg-6">

            <div class="form-group">
                <label>Related-To</label>
                <select class="form-control" name="relatedTo" id="relatedTo">
                    <option value="">Not Related</option>
                    <%  while(resultset.next()){ %>
                    <option value="<%= resultset.getString(1)%>"><%= resultset.getString(1)%></option>
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


            <button type="submit" class="btn btn-default" id="saveData">Submit Button</button>
            <button type="reset" class="btn btn-default" id="reset">Reset Button</button>



        </div>
          </form>

      </div>
      <!-- /.row -->

        <!-- /.display row -->

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default" id="w">
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

                                            <a href="#loginmodal" class="btn btn-sm btn-danger" id="modaltrigger">load</a>
                                    </td>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </c:if>
                </div>
            </div>+
        </div>

        <!-- /.display row -->


    </div>
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
    }
    catch(Exception e)
    {
        System.out.println("wrong entry"+e);
    }
%>
</body>

</html>






