<%-- 
    Document   : editBooking
    Created on : Aug 31, 2015, 9:12:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>Edit Booking</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="adminTemplate.jsp" %>
            <div id="page-wrapper">
                <form method="post" class="form-horizontal" action="Booking?evt=doEdit">
                    <div class="form-group">
                        <label class="col-xs-2 control-label"><h2>EditBooking</h2></label>
                    </div>
                    <input type="hidden" name="id" value="${book.id}"/>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">UserName</label>
                        <div class="col-xs-4">
                            <input type="text" class="form-control" name="name" value="${book.name}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Email</label>
                        <div class="col-xs-5">
                            <input type="email" class="form-control" name="email" value="${book.email}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Phone</label>
                        <div class="col-xs-5">
                            <input type="tel" class="form-control" name="phone" value="${book.phone}" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Film</label>
                        <div class="col-xs-5 selectContainer">
                            <select class="form-control" name="filmId" required>
                                <option value="${book.movieId.id}">${book.movieId.name}</option>
                                <c:forEach items="${listFilms}" var="f">
                                    <c:if test="${book.movieId.id != f.id}">
                                        <option value="${f.id}">${f.name}</option>
                                    </c:if>                                    
                                </c:forEach>                                        
                            </select>
                        </div>
                    </div>
                                    
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Time</label>
                        <div class="col-xs-5 selectContainer">
                            <select class="form-control" name="time" required>
                                <option value="${book.openTime}">${book.openTime}</option>
                                <c:forEach items="09:00,11:00,13:00,15:00,17:00,19:00,21:00" var="t">
                                    <c:if test="${!(book.openTime eq t)}">
                                        <option value="${t}">${t}</option>
                                    </c:if>                                    
                                </c:forEach>                                        
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2 control-label">Quantity</label>
                        <div class="col-xs-1">
                            <input type="number" class="form-control" name="ql" value="${book.qualtity}" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-5 col-xs-offset-2">
                            <input type="submit" class="btn btn-default" value="Edit Booking" >
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
