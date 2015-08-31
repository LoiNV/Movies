<%-- 
    Document   : moviePage
    Created on : Aug 31, 2015, 2:22:49 PM
    Author     : Admin
--%>

<%@page import="entities.Film"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Fonts -->
        <!-- Font awesome - icon font -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <!-- Stylesheets -->
        <!-- jQuery UI --> 
        <link href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="stylesheet">

        <!-- Mobile menu -->
        <link href="css/gozha-nav.css" rel="stylesheet" />
        <!-- Select -->
        <link href="css/external/jquery.selectbox.css" rel="stylesheet" />
        <!-- Swiper slider -->
        <link href="css/external/idangerous.swiper.css" rel="stylesheet" />
        <!-- Magnific-popup -->
        <link href="css/external/magnific-popup.css" rel="stylesheet" />


        <!-- Custom -->
        <link href="css/style.css?v=1" rel="stylesheet" />

        <!-- Modernizr --> 
        <script src="js/external/modernizr.custom.js"></script>  
        <title>Movie</title>
    </head>
    <body>
        <%            
            session.setAttribute("filmId", request.getParameter("id"));
            session.setAttribute("price", request.getParameter("price"));
        %>
        <div class="wrapper">
            <%@include file="header.jsp" %>
            <%@include file="search.jsp" %>

            <section class="container">
                <div class="col-sm-8 col-md-9">
                    <div class="movie">
                        <h2 class="page-heading">${film.name}</h2>

                        <div class="movie__info">
                            <div class="col-sm-6 col-md-4 movie-mobile">
                                <div class="movie__images">
                                    <span class="movie__rating">5.0</span>
                                    <img alt='' src="${film.img}">
                                </div>
                                <!--<div class="movie__rate">Your vote: <div id='score' class="score"></div></div>-->
                            </div>

                            <div class="col-sm-6 col-md-8">
                                <p class="movie__time">169 min</p>
                                <p class="movie__option"><strong>Year: </strong><a href="#">2012</a></p>
                                <p class="movie__option"><strong>Category: </strong><a href="#">${film.categoryId}</a>,</p>
                                <p class="movie__option"><strong>Release date: </strong>${film.openning}</p>
                                <p class="movie__option"><strong>Director: </strong><a href="#">LoiNV</a></p>

                                <a href="#" class="comment-link">Price:  ${film.price} $</a>

                                <div class="movie__btns">
                                    <a href="booking.jsp" class="btn btn-md btn--warning">book a ticket for this movie</a>
                                    <a href="#" class="watchlist">Add to watchlist</a>
                                </div>

                            </div>
                        </div>

                        <div class="clearfix"></div>

                        <h2 class="page-heading">The plot</h2>

                        <p class="movie__describe">${film.descript}... </p>
                        
                        <h2 class="page-heading">The trailer</h2>
                        
                        <div class="trailer" style="width: 555px;" >${film.linkVideo}</div>
                        
                        <div class="clearfix"></div>
                        
                        <h2 class="page-heading">photos &amp; videos</h2>

                        <div class="movie__media">
                            <div class="movie__media-switch">
                                <a href="#" class="watchlist list--photo" data-filter='media-photo'>234 photos</a>
                                <a href="#" class="watchlist list--video" data-filter='media-video'>10 videos</a>
                            </div>

                            <div class="swiper-container">
                                <div class="swiper-wrapper">
                                    <!--First Slide-->
                                    <div class="swiper-slide media-video">
                                        <a href='https://www.youtube.com/watch?v=Y5AehBA3IsE' class="movie__media-item ">
                                            <img alt='' src="images/movie/movie-video1.jpg">
                                        </a>
                                    </div>

                                    <!--Second Slide-->
                                    <div class="swiper-slide media-video">
                                        <a href='https://www.youtube.com/watch?v=Kb3ykVYvT4U' class="movie__media-item">
                                            <img alt='' src="images/movie/movie-video2.jpg">
                                        </a>
                                    </div>

                                    <!--Third Slide-->
                                    <div class="swiper-slide media-photo"> 
                                        <a href='images/movie/movie-img1-lg.jpg' class="movie__media-item">
                                            <img alt='' src="images/movie/movie-img1.jpg">
                                        </a>
                                    </div>

                                    <!--Four Slide-->
                                    <div class="swiper-slide media-photo"> 
                                        <a href='images/movie/movie-img2-lg.jpg' class="movie__media-item">
                                            <img alt='' src="images/movie/movie-img2.jpg">
                                        </a>
                                    </div>

                                    <!--Slide-->
                                    <div class="swiper-slide media-photo"> 
                                        <a href='images/gallery/large/item-7.jpg' class="movie__media-item">
                                            <img alt='' src="images/movie/movie-img3.jpg">
                                        </a>
                                    </div>

                                    <!--Slide-->
                                    <div class="swiper-slide media-photo"> 
                                        <a href='images/gallery/large/item-11.jpg' class="movie__media-item">
                                            <img alt='' src="images/movie/movie-img4.jpg">
                                        </a>
                                    </div>

                                    <!--First Slide-->
                                    <div class="swiper-slide media-video">
                                        <a href='https://www.youtube.com/watch?v=Y5AehBA3IsE' class="movie__media-item ">
                                            <img alt='' src="images/movie/movie-video1.jpg">
                                        </a>
                                    </div>

                                    <!--Second Slide-->
                                    <div class="swiper-slide media-video">
                                        <a href='https://www.youtube.com/watch?v=Kb3ykVYvT4U' class="movie__media-item">
                                            <img alt='' src="images/movie/movie-video2.jpg">
                                        </a>
                                    </div>

                                    <!--Slide-->
                                    <div class="swiper-slide media-photo"> 
                                        <a href='images/gallery/large/item-15.jpg' class="movie__media-item">
                                            <img alt='' src="images/movie/movie-img5.jpg">
                                        </a>
                                    </div>

                                    <!--Slide-->
                                    <div class="swiper-slide media-photo"> 
                                        <a href='images/gallery/large/item-16.jpg' class="movie__media-item">
                                            <img alt='' src="images/movie/movie-img6.jpg">
                                        </a>
                                    </div>

                                </div>
                            </div>

                        </div>

                    </div>
                    <div class="clearfix"><p/></div>

                    <div class="comment-wrapper">
                        <form id="comment-form" class="comment-form" method='post'>
                            <textarea class="comment-form__text" placeholder='Add you comment here'></textarea>
                            <label class="comment-form__info">250 characters left</label>
                            <button type='submit' class="btn btn-md btn--danger comment-form__btn">add comment</button>
                        </form>
                        <div class="comment-sets">

                            <div class="comment">
                                <div class="comment__images">
                                    <img alt='' src="images/comment/avatar.jpg">
                                </div>

                                <a href='#' class="comment__author"><span class="social-used fa fa-facebook"></span>Roberta Inetti</a>
                                <p class="comment__date">today | 03:04</p>
                                <p class="comment__message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae enim sollicitudin, euismod erat id, fringilla lacus. Cras ut rutrum lectus. Etiam ante justo, volutpat at viverra a, mattis in velit. Morbi molestie rhoncus enim, vitae sagittis dolor tristique et.</p>
                                <a href='#' class="comment__reply">Reply</a>
                            </div>

                            <div class="comment">
                                <div class="comment__images">
                                    <img alt='' src="images/comment/avatar-olia.jpg">
                                </div>

                                <a href='#' class="comment__author"><span class="social-used fa fa-vk"></span>Olia Gozha</a>
                                <p class="comment__date">22.10.2013 | 14:40</p>
                                <p class="comment__message">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut vitae enim sollicitudin, euismod erat id, fringilla lacus. Cras ut rutrum lectus. Etiam ante justo, volutpat at viverra a, mattis in velit. Morbi molestie rhoncus enim, vitae sagittis dolor tristique et.</p>
                                <a href='#' class="comment__reply">Reply</a>
                            </div>
                        </div>
                    </div>
                </div>

                <aside class="col-sm-4 col-md-3">
                    <div class="sitebar">
                        <div class="banner-wrap">
                            <img alt='banner' src="images/banners/sale.jpg">
                        </div>

                        <div class="banner-wrap">
                            <img alt='banner' src="images/banners/sport.jpg">
                        </div>

                        <div class="banner-wrap banner-wrap--last">
                            <img alt='banner' src="images/banners/boots.jpg">
                        </div>

                        <div class="promo marginb-sm">
                            <div class="promo__head">A.Movie app</div>
                            <div class="promo__describe">for all smartphones<br> and tablets</div>
                            <div class="promo__content">
                                <ul>
                                    <li class="store-variant"><a href="#"><img alt='' src="images/apple-store.svg"></a></li>
                                    <li class="store-variant"><a href="#"><img alt='' src="images/google-play.svg"></a></li>
                                    <li class="store-variant"><a href="#"><img alt='' src="images/windows-store.svg"></a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </aside>
            </section>
            <%@include file="footer.jsp" %>
        </div>

        <!-- JavaScript-->
        <!-- jQuery 1.9.1--> 
        <script src="js/external/jquery-1.10.1.min.js"></script>

        <script src="js/external/jquery-migrate-1.2.1.min.js"></script>
        <!-- jQuery UI -->
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <!-- Bootstrap 3--> 
        <script src="js/bootstrap.min.js"></script>

        <!-- Select -->
        <script src="js/external/jquery.selectbox-0.2.min.js"></script>

        <!-- Stars rate -->
        <script src="js/external/jquery.raty.js"></script>
        <!-- Mobile menu -->
        <script src="js/jquery.mobile.menu.js"></script>
        <!-- Swiper slider -->
        <script src="js/external/idangerous.swiper.min.js"></script>

        <!-- Form element -->
        <script src="js/external/form-element.js"></script>
        <!-- Form validation -->
        <script src="js/form.js"></script>

        <!-- Custom -->
        <script src="js/custom.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                init_MoviePage();
            });
        </script>
    </body>
</html>
