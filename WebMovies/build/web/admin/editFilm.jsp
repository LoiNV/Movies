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
                
                <form method="post" class="form-horizontal" enctype="multipart/form-data" action="DoEdit">
                    <div class="form-group">
                        <label class="col-xs-2 control-label"><h2>Edit Film</h2></label>
                    </div>
                    <input type="hidden" name="id" value="${film.id}"/>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Name</label>
                        <div class="col-xs-6">
                            <input value="${film.name}" class="form-control" name="name" maxlength="50" required/>
                        </div>
                    </div>                            

                    <div class="form-group">
                        <label class="col-xs-2 control-label">Image</label>
                        <div class="col-xs-6 ">
                            <div id="img"><img  src="${film.img}"/></div>
                            <input type="hidden" name="img" id="img" value=""/>
                            <input type="file" class="form-control" name="file" onchange="document.getElementById('img').value = 'changed'"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Trailer</label>
                        <div class="col-xs-6 ">      
                            <div id="trailer">${film.linkVideo}</div>
                            <input value="" onchange="document.getElementById('trailer').innerHTML = this.value;" placeholder="New Trailer" class="form-control" name="linkVideo"/>                                    
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
                                    format: 'DD/MM/YYYY'
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
                        <div class="col-xs-7">
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
