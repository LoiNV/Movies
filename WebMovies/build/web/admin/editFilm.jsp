<%-- 
    Document   : editFilm
    Created on : Aug 21, 2015, 6:33:14 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>Edit Film</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="adminTemplate.jsp" %>
            <div id="page-wrapper">
                
                <form method="post" class="form-horizontal" action="CreateFilm?evt=doEdit&id=${film.id}">
                    <div class="form-group">
                        <label class="col-xs-2 control-label"><h2>Edit Film</h2></label>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Name</label>
                        <div class="col-xs-7">
                            <input value="${film.name}" class="form-control" name="name" maxlength="50" required/>
                        </div>
                    </div>                            

                    <div class="form-group">
                        <label class="col-xs-2 control-label">Image</label>
                        <div class="col-xs-6 ">                                    
                            <input value="${film.img}" class="form-control" name="imgPath" required/>                                    
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2 control-label">Trailer</label>
                        <div class="col-xs-5 ">                                    
                            <input value="${film.linkVideo}" class="form-control" name="linkTrailer" required/>                                    
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2 control-label">OpenDay</label>
                        <div class="col-xs-4">
                            <div class="input-group date" id='datetimepicker'>
                                <input value="${film.openning}" name="openDay" class="form-control" required/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <script type="text/javascript">
                            $(function () {
                                $('#datetimepicker').datetimepicker({
                                    format: 'DD/MM/YYYY - HH:mm'
                                });
                            });
                        </script>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2 control-label">Categories</label>
                        <div class="col-xs-3 selectContainer">
                            <select class="form-control" name="category" required>
                                <option value="${film.categoryId.id}">${film.categoryId.name}</option>
                                <c:forEach items="${listCategories}" var="ca">
                                    <c:if test="${film.categoryId.id != ca.id}">
                                        <option value="${ca.id}">${ca.name}</option>
                                    </c:if>                                    
                                </c:forEach>                                        
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2 control-label">Price</label>
                        <div class="col-xs-2 ">
                            <div class="input-group">
                                <input type="number" value="${film.price}" class="form-control" name="price" required/>
                                <span class="input-group-addon">$</span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2 control-label">Hot</label>
                        <div class="col-xs-1 ">
                            <c:if test="${film.isHot}">
                                <input type="checkbox" name="hot" checked value="true" style="margin-top: 10px;"/>
                            </c:if>
                            
                            <c:if test="${!film.isHot}" >
                                <input type="checkbox" name="hot" value="true" style="margin-top: 10px;"/>
                            </c:if>
                            
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-2 control-label">Description</label>
                        <div class="col-xs-8">
                            <textarea id="description" name="description" class="form-control" required>${film.descript}</textarea>
                            <script type="text/javascript">
                                CKEDITOR.replace('description')
                            </script>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-5 col-xs-offset-2">
                            <input type="submit" class="btn btn-default" value="Edit Film " />
                        </div>
                    </div>
                </form>
            </div>

        </div>

    </body>
</html>
