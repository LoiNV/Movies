<%-- 
    Document   : bookfinal
    Created on : Aug 31, 2015, 8:10:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Font awesome - icon font -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- Mono font -->
        <link href='http://fonts.googleapis.com/css?family=PT+Mono' rel='stylesheet' type='text/css'>

        <!-- Stylesheets -->
        <!-- jQuery UI --> 
        <link href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="stylesheet">

        <!-- Mobile menu -->
        <link href="css/gozha-nav.css" rel="stylesheet" />
        <!-- Select -->
        <link href="css/external/jquery.selectbox.css" rel="stylesheet" />

        <!-- Custom -->
        <link href="css/style.css?v=1" rel="stylesheet" />

        <!-- Modernizr --> 
        <script src="js/external/modernizr.custom.js"></script>
        <title>Booking Final</title>
    </head>
    <body>
        <div class="wrapper place-wrapper">
            <%@include file="header.jsp" %>
            <%@include file="search.jsp" %>

            <section class="container">
                <div class="order-container">
                    <div class="order">
                        <img class="order__images" alt='' src="images/tickets.png">
                        <p class="order__title">Thank you <br><span class="order__descript">you have successfully purchased tickets</span></p>
                    </div>

                    <div class="ticket">
                        <div class="ticket-position">
                            <div class="ticket__indecator indecator--pre"><div class="indecator-text pre--text">online ticket</div> </div>
                            <div class="ticket__inner">

                                <div class="ticket-secondary">
                                    <span class="ticket__item">Ticket number <strong class="ticket__number">a126bym4</strong></span>
                                    <span class="ticket__item ticket__date">${book.movieId.openning}</span>
                                    <span class="ticket__item ticket__time">${book.openTime}</span>
                                    <span class="ticket__item">Quantity: <span class="ticket__cinema">${book.qualtity}</span></span>
                                    <span class="ticket__item ticket__price">price: <strong class="ticket__cost">$${book.movieId.price}</strong></span>
                                </div>

                                <div class="ticket-primery">
                                    <span class="ticket__item ticket__item--primery ticket__film">Film<br><strong class="ticket__movie">${book.movieId}</strong></span>
                                    <span class="ticket__item ticket__item--primery">Total: <span class="ticket__place">$${book.movieId.price*book.qualtity}</span></span>
                                </div>


                            </div>
                            <div class="ticket__indecator indecator--post"><div class="indecator-text post--text">online ticket</div></div>
                        </div>
                    </div>

                    <div class="ticket-control">
                        <a href="#" class="watchlist list--download">Download</a>
                        <a href="#" class="watchlist list--print">Print</a>
                    </div>

                </div>
            </section>

            <div class="clearfix"></div>
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

        <script type="text/javascript">
            $(document).ready(function () {
                $('.top-scroll').parent().find('.top-scroll').remove();
            });
        </script>
    </body>
</html>
