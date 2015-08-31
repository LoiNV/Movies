<%-- 
    Document   : viewbookings
    Created on : Aug 22, 2015, 8:19:14 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>

        <title>Film Admin - Bookings</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="adminTemplate.jsp" %>
            <div id="page-wrapper">
                <div class="container-fluid" style="width: 95%">
                    <h1>Categories</h1>
                    <table cellpadding="0" cellspacing="0" border="0" 
                           class="table table-striped table-bordered" id="datatable">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>E-mail</th>
                                <th>Film</th>
                                <th>Time</th>
                                <th style="width: 6%; text-align: center">Quantity</th>
                                <th style="width: 10%; text-align: center">Editor</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${listBookings}" var="b">
                                <tr>
                                    <td>${b.id}</td>
                                    <td>${b.name}</td>
                                    <td>${b.phone}</td>
                                    <td>${b.email}</td>
                                    <td>${b.movieId}</td>
                                    <td>${b.openTime}</td>
                                    <td style="text-align: center">${b.qualtity}</td>
                                    <td style="text-align: center">
                                        <a  onclick="return confirm('Are you sure?')" href="Booking?id=${b.id}&evt=delete"><div class="fa fa-remove"> </div></a> | 
                                        <a href="Booking?id=${b.id}&evt=edit" > <div class="fa fa-edit"> </div></a>                                        
                                    </td>                                    
                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
