<%-- 
    Document   : newjsp
    Created on : Aug 31, 2015, 9:22:22 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!-- Font awesome - icon font -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
        
        <!-- Stylesheets -->

        <!-- Mobile menu -->
        <link href="css/gozha-nav.css" rel="stylesheet" />
        <!-- Select -->
        <link href="css/external/jquery.selectbox.css" rel="stylesheet" />
    
        <!-- Custom -->
        <link href="css/style.css?v=1" rel="stylesheet" />

        <!-- Modernizr --> 
        <script src="js/external/modernizr.custom.js"></script>
        <title>Login</title>
    </head>
    <body>
        <div class="wrapper">
            <%@include file="header.jsp" %>
        
            <!-- Main content -->
            <form class="login" method="post" action="Login?user=${param.user}" >
                <p class="login__title">sign in <br><span class="login-edition">welcome to A.Movie</span></p>

                <div class="social social--colored">
                    <a href='#' class="social__variant fa fa-facebook"></a>
                    <a href='#' class="social__variant fa fa-twitter"></a>
                    <a href='#' class="social__variant fa fa-tumblr"></a>
                </div>

                <p class="login__tracker">or</p>

                <div class="field-wrap">
                    <input placeholder='UserName' name="username" class="login__input">
                    <input type="password" placeholder='Password' name="pass" class="login__input">

                    <input type='checkbox' id='#informed' class='login__check styled'>
                    <label for='#informed' class='login__check-info'>remember me</label>
                </div>

                <div class="login__control">
                    <input type="submit" value="sign in" class="btn btn-md btn--warning btn--wider">
                    <a href="#" class="login__tracker form__tracker">Forgot password?</a>
                </div>
            </form>
        
            <div class="clearfix"></div>
        </div>
            <%@include file="footer.jsp" %>
        
        <!-- JavaScript-->
        <!-- jQuery 1.9.1--> 
        <script src="js/external/jquery-1.10.1.min.js"></script>
        <!-- Migrate --> 
        <script src="js/external/jquery-migrate-1.2.1.min.js"></script>
        <!-- Bootstrap 3--> 
        <script src="js/bootstrap.min.js"></script>

        <!-- Mobile menu -->
        <script src="js/jquery.mobile.menu.js"></script>
         <!-- Select -->
        <script src="js/external/jquery.selectbox-0.2.min.js"></script>
        <!-- Form element -->
        <script src="js/external/form-element.js"></script>
        <!-- Form validation -->
        <script src="js/form.js"></script>

        <!-- Custom -->
        <script src="js/custom.js"></script>
    </body>
</html>
