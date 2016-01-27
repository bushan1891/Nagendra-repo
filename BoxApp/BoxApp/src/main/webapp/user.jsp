<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html >
        <html ng-app="BoxApp">

        <head>

            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>BoxApp</title>
            <spring:url value="/resources/scripts/App.js" var="crunchifyJS" />
            <!-- Latest compiled and minified CSS -->
            <link href="<c:url value=" /resources/css/main.css " />" rel="stylesheet">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
            <!-- Loading angular CDN -->
            <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
            <script type="text/javascript" src="<c:url value=" /resources/scripts/App.js " />"></script>
            <scripttype="text/javascript" src="${crunchifyJS}">
                </script>
        </head>


        <!--  adding my controller here  -->

        <body ng-controller="ControllerFn as indexvm">
            <!-- Nav bar -->

            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">

                        <ul class="nav nav-pills">
                            <li>
                                <a class="navbar-brand " href="#"> <span class="glyphicon glyphicon-folder-close " aria-hidden="true">
					</span>
                                </a>
                            </li>
                            <li>
                                <a class="navbar-brand logoclass" " rel="home " href="# "
					title="Buy Sell Rent Everyting "> <img id="logo "
						src="http://logonoid.com/images/box-logo.png "></a></li>

            <ul class="nav navbar-nav navbar-right ">
				<li role="presentation "><a href="hello ">Home</a></li>
				<li role="presentation "><a href="upload ">Upload File</a></li>
				<li role="presentation "><a href="download ">Download File</a></li>
			</ul>

			</ul>
		</div>
	</div>
	</nav>

	<!--  Login template -->

	<div class="container ">
		<div class="card card-container ">

			<img id="profile-img " class="profile-img-card "
				src="//ssl.gstatic.com/accounts/ui/avatar_2x.png " />
			<p id="profile-name " class="profile-name-card "></p>
			<form class="form-signin ">
				<span id="reauth-email " class="reauth-email "></span> 
				<input
					type="email " id="inputEmail " class="form-control " ng-model ="indexvm.email "
					placeholder="Email address " required autofocus> 
					<input
					type="password " id="inputPassword " class="form-control " ng-model="indexvm.password "
					placeholder="Password " required>
				<div id="remember " class="checkbox ">
					<label> <input type="checkbox " value="remember-me ">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block btn-signin "
					type="submit ">Sign in</button>
			</form>
			<!-- /form -->
			<a href="# " class="forgot-password "> Forgot the password? </a>
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->
	
	<p> {{indexvm.email}} {{indexvm.password}} </p>


</body>
</html>