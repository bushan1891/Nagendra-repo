<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html  ng-app ="BoxApp">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BoxApp</title>

<!-- Latest compiled and minified CSS -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/usertmpl.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">



</head>

<body>
	<!-- Nav bar -->

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">

			<ul class="nav nav-pills">
				<li><a class="navbar-brand " href="#"> <span
						class="glyphicon glyphicon-folder-close " aria-hidden="true">
					</span>
				</a></li>
				<li><a class="navbar-brand logoclass" " rel="home" href="#"
					title="Buy Sell Rent Everyting"> <img id="logo"
						src="http://logonoid.com/images/box-logo.png"></a></li>

            <ul class="nav navbar-nav navbar-right ">
				<li role="presentation"><a href="hello">Home</a></li>
				<li role="presentation"><a href="#/login">Login</a></li>
				<li role="presentation"><a href="#/user">UserScreen</a></li>
			</ul>

			</ul>
		</div>
	</div>
	</nav>

	<!-- ng-route goes here  --> 
  <section>
    <div class="container" ng-view>
    </div>
  </section>
	
	
	
	
	<p>{{eamil}} {{password}} </p>

<script src="https://code.angularjs.org/1.4.7/angular.js"></script>
<script src="https://code.angularjs.org/1.4.7/angular-route.js"></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/App.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/user.controller.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/user.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/service.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/agent.js" />" ></script>
<script type="text/javascript" src="<c:url value="/resources/scripts/adjustor.js" />" ></script>
</body>
</html>