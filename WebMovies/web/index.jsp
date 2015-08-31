<%-- 
    Document   : index
    Created on : Aug 22, 2015, 9:54:21 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Basic Page Needs -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Fonts -->
        <!-- Font awesome - icon font -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <!-- Stylesheets --> 

        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <!-- Mobile menu -->
        <link href="css/gozha-nav.css" rel="stylesheet" />
        <!-- Select -->
        <link href="css/external/jquery.selectbox.css" rel="stylesheet" />
        <!-- Magnific-popup -->
        <link href="css/external/magnific-popup.css" rel="stylesheet" />
        <!-- Select -->
        <link href="css/external/jquery.selectbox.css" rel="stylesheet" />
        <!-- Custom -->
        <link href="css/style.css?v=1" rel="stylesheet" />

        <!-- Modernizr --> 
        <script src="js/external/modernizr.custom.js"></script>

        <title>Home Page</title>

    </head>
    <body>

        <div class="wrapper">
            <%@include file="header.jsp" %>
            <%@include file="slider.jsp" %>

            <!-- Main content -->
            <section class="container">
                <!--Movie Best-->
                <div class="movie-best">
                    <div class="col-sm-10 col-sm-offset-1 movie-best__rating">Today Best choice</div>
                    <div class="col-sm-12 change--col">
                        <c:forEach begin="0" end="5" var="f" items="${listHot}">
                            <div class="movie-beta__item ">

                                <img alt='' src="${f.img}">
                                <span class="best-rate">5.0</span>

                                <ul class="movie-beta__info">
                                    <li><span class="best-voted">71 people voted today</span></li>
                                    <li>
                                        <p class="movie__time">169 min</p>
                                        <p>${f.categoryId} </p>
                                        <p>38 comments</p>
                                    </li>
                                    <li class="last-block">
                                        <a href="SinglePage?id=${f.id}&&price=${f.price}" class="slide__link">more</a>
                                    </li>
                                </ul>
                            </div>
                        </c:forEach>

                    </div>
                    <div class="col-sm-10 col-sm-offset-1 movie-best__check">check all movies now playing</div>
                </div>

                <div class="clearfix"></div>

                <h2 id='target' class="page-heading heading--outcontainer">Now in the cinema</h2>
                <!--Now Cinema-->
                <div class="col-sm-12">
                    <div class="row">
                        <!--Cinema-->
                        <div class="col-sm-8 col-md-9">
                            <c:forEach begin="3" end="10" var="f2" items="${listFilm}">
                                <div class="movie movie--test movie--test--dark movie--test--left">
                                    <div class="movie__images">
                                        <a href="SinglePage?id=${f2.id}&&price=${f2.price}" class="movie-beta__link">
                                            <img alt='' src="${f2.img}">
                                        </a>
                                    </div>

                                    <div class="movie__info">
                                        <a href='SinglePage?id=${f2.id}&&price=${f2.price}' class="movie__title">${f2.name}  </a>

                                        <p class="movie__time">91 min</p>

                                        <p class="movie__option"><a href="#">${f2.categoryId}</a></p>

                                        <div class="movie__rate">
                                            <div class="score"></div>
                                            <span class="movie__rating">4.1</span>
                                        </div>               
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <!--Ad-->
                        <aside class="col-sm-4 col-md-3">
                            <div class="sitebar first-banner--left">
                                <div class="banner-wrap first-banner--left">
                                    <img alt='banner' src="images/banners/sale.jpg">
                                </div>

                                <div class="banner-wrap">
                                    <img alt='banner' src="images/banners/sport.jpg">
                                </div>

                                <div class="banner-wrap banner-wrap--last">
                                    <img alt='banner' src="images/banners/boots.jpg">
                                </div>

                            </div>
                        </aside>
                    </div>
                </div>
                <!--Latest News-->
                <div class="col-sm-12">
                    <h2 class="page-heading">Latest news</h2>

                    <div class="col-sm-4 similar-wrap col--remove">
                        <div class="post post--preview post--preview--wide">
                            <div class="post__image">
                                <img alt='' src="images/client-photo/post-thor.jpg">
                                <div class="social social--position social--hide">
                                    <span class="social__name">Share:</span>
                                    <a href='#' class="social__variant social--first fa fa-facebook"></a>
                                    <a href='#' class="social__variant social--second fa fa-twitter"></a>
                                    <a href='#' class="social__variant social--third fa fa-vk"></a>
                                </div>
                            </div>
                            <p class="post__date">22 October 2013 </p>
                            <a href="#" class="post__title">"Thor: The Dark World" - World Premiere</a>
                            <a href="#" class="btn read-more post--btn">read more</a>
                        </div>
                    </div>
                    <div class="col-sm-4 similar-wrap col--remove">
                        <div class="post post--preview post--preview--wide">
                            <div class="post__image">
                                <img alt='' src="images/client-photo/post-annual.jpg">
                                <div class="social social--position social--hide">
                                    <span class="social__name">Share:</span>
                                    <a href='#' class="social__variant social--first fa fa-facebook"></a>
                                    <a href='#' class="social__variant social--second fa fa-twitter"></a>
                                    <a href='#' class="social__variant social--third fa fa-vk"></a>
                                </div>
                            </div>
                            <p class="post__date">22 October 2013 </p>
                            <a href="#" class="post__title">30th Annual Night Of Stars Presented By The Fashion Group International</a>
                            <a href="#" class="btn read-more post--btn">read more</a>
                        </div>
                    </div>
                    <div class="col-sm-4 similar-wrap col--remove">
                        <div class="post post--preview post--preview--wide">
                            <div class="post__image">
                                <img alt='' src="images/client-photo/post-awards.jpg">
                                <div class="social social--position social--hide">
                                    <span class="social__name">Share:</span>
                                    <a href='#' class="social__variant social--first fa fa-facebook"></a>
                                    <a href='#' class="social__variant social--second fa fa-twitter"></a>
                                    <a href='#' class="social__variant social--third fa fa-vk"></a>
                                </div>
                            </div>
                            <p class="post__date">22 October 2013 </p>
                            <a href="#" class="post__title">Hollywood Film Awards 2013</a>
                            <a href="#" class="btn read-more post--btn">read more</a>
                        </div>
                    </div>
                </div>
            </section>
            <%@include file="footer.jsp" %>
        </div>       
        
        <!-- jQuery 1.9.1--> 
        <script src="js/external/jquery-1.10.1.min.js"></script>
        <!-- Migrate --> 
        <script src="js/external/jquery-migrate-1.2.1.min.js"></script>
        <!-- Bootstrap 3--> 
        <script src="js/bootstrap.min.js"></script>

        <!-- jQuery REVOLUTION Slider -->
        <script type="text/javascript" src="rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
        <script type="text/javascript" src="rs-plugin/js/jquery.themepunch.revolution.min.js"></script>

        <!-- Mobile menu -->
        <script src="js/jquery.mobile.menu.js"></script>
        <!-- Select -->
        <script src="js/external/jquery.selectbox-0.2.min.js"></script>
        <!-- Stars rate -->
        <script src="js/external/jquery.raty.js"></script>
        <!-- Form element -->
        <script src="js/external/form-element.js"></script>
        <!-- Form validation -->
        <script src="js/form.js"></script>

        <script src="js/custom.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                init_Home();
            });
        </script>
    </body>
</html>
