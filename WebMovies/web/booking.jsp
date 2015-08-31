<%-- 
    Document   : booking1
    Created on : Aug 29, 2015, 8:48:23 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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

        <!-- Custom -->
        <link href="css/style.css?v=1" rel="stylesheet" />

        <!-- Modernizr --> 
        <script src="js/external/modernizr.custom.js"></script>

        <title>Booking</title>

    </head>
    <body>
        <div class="wrapper">
            <%@include file="header.jsp" %>
            <%@include file="search.jsp" %>

            <!-- Main content -->

            <section class="container">
                <div class="order-container">
                    <div class="order">
                        <img class="order__images" alt='' src="images/tickets.png">
                        <p class="order__title">Book a ticket <br><span class="order__descript">and have fun movie time</span></p>

                    </div>
                </div>

            </section>
            <section class="container">
                <form method="post" action="Booking?evt=create" class="form contact-info">
                    <input type="hidden" name="name" value="<%= session.getAttribute("name") %>"/>
                    <input type="hidden" name="filmId" value="<%= session.getAttribute("filmId") %>"/>
                    
                    <div class="col-sm-12"> 

                        <h2 class="page-heading">Pick time</h2>

                        <div class="time-select time-select--wide">

                            <div class="time-select__group">
                                <div class="col-sm-2">
                                    <p class="time-select__place">Cinema</p>
                                </div>
                                <div class="col-sm-7 items-wrap">
                                    <label class="time-select__item">
                                        <input type="radio" name="time" value="09:00"/>09:00
                                    </label>
                                    <label class="time-select__item">
                                        <input type="radio" name="time" value="11:00"/>11:00
                                    </label>
                                    <label class="time-select__item">
                                        <input type="radio" name="time" value="13:00"/>13:00
                                    </label>
                                    <label class="time-select__item">
                                        <input type="radio" name="time" value="15:00"/>15:00
                                    </label>
                                    <label class="time-select__item">
                                        <input type="radio" name="time" value="17:00"/>17:00
                                    </label>
                                    <label class="time-select__item">
                                        <input type="radio" name="time" value="19:00"/>19:00
                                    </label>
                                    <label class="time-select__item">
                                        <input type="radio" name="time" value="21:00"/>21:00
                                    </label>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="col-sm-12">
                        <div class="checkout-wrapper">
                            <h2 class="page-heading">price</h2>
                            <div class="book-result">
                                <div class="book-result__item">
                                    Tickets: <span class="book-result__count booking-ticket">
                                        <input type="number" name="ql" value="1" style="width: 50px" onchange="changeValue(this.value)"/>
                                            </span>
                                </div>
                                <div class="book-result__item">One item price:<span id="price" class="book-result__count booking-price"><%= session.getAttribute("price") %></span>$</div>
                                <div class="book-result__item">Total:<span id="totalShow" class="book-result__count booking-cost"><%= session.getAttribute("price") %></span>$</div>
                                
                                <script>
                                    function changeValue(ticket){                                        
                                        var price = document.getElementById('price').innerHTML;
                                        $('#totalShow').text(ticket*price);
                                    }
                                </script>
                            </div>

                            <h2 class="page-heading">Contact information</h2>

                            <div class="contact-info__field contact-info__field-mail">
                                <input type='email' name='email' placeholder='Your email' class="form__mail">
                            </div>
                            <div class="contact-info__field contact-info__field-tel">
                                <input type='tel' name='phone' placeholder='Phone number' class="form__mail">
                            </div>

                            <p class="reservation-message">Fill your contact information to recieve your reservation code. Reserved tickets are removed 20 minutes befor the session is due to start</p>

                        </div>

                        <div class="order">
                            <input type="submit" value="Reserve" class="btn btn-md btn--warning btn--wide">
                        </div>

                    </div>
                </form>
            </section>


            <div class="clearfix"></div>


            <%@include file="footer.jsp" %>
        </div>
        <!-- JavaScript-->
        <!-- jQuery 1.9.1--> 
        <script src="js/external/jquery-1.10.1.min.js"></script>
        <!-- Migrate --> 
        <script src="js/external/jquery-migrate-1.2.1.min.js"></script>
        <!-- jQuery UI -->
        <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
        <!-- Bootstrap 3--> 
        <script src="js/bootstrap.min.js"></script>

        <!-- Mobile menu -->
        <script src="js/jquery.mobile.menu.js"></script>
        <!-- Select -->
        <script src="js/external/jquery.selectbox-0.2.min.js"></script>
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
                init_BookingOne();
            });
        </script>
    </body>
</html>
