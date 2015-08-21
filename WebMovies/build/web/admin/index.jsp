<%-- 
    Document   : index
    Created on : Aug 19, 2015, 7:59:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>

        <title>Film Admin - Films</title>        

    </head>
    <body>
        <div id="wrapper">
            <%@include file="adminTemplate.jsp" %>
            <div id="page-wrapper">
                <div class="container-fluid" style="width: 95%">
                    <h1>Films</h1>
                    <a href="#" onclick="$('#createModal').modal('show')">Create</a>
                    <table cellpadding="0" cellspacing="0" border="0" 
                           class="table table-striped table-bordered" id="datatable">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Open</th>
                                <th>Category</th>
                                <th>Price</th>
                                <th>Hot</th>
                                <th style="width: 10%; text-align: center">Editor</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${listFilm}" var="f">
                                <tr>
                                    <td>${f.id}</td>
                                    <td>${f.name}</td>
                                    <td>${f.openning}</td>
                                    <td>${f.categoryId}</td>
                                    <td>${f.price}</td>
                                    <td>${f.isHot}</td>
                                    <td style="text-align: center">
                                        <a onclick="return confirm('Are you sure?')" href="CreateFilm?id=${f.id}&evt=delete"><div class="fa fa-remove"> </div></a> | 
                                        <a href="CreateFilm?id=${f.id}&evt=edit"> <div class="fa fa-edit"> </div></a> | 
                                        <a href="#"><div class="fa fa-search"> </div></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>

        <!-- Modal Create -->
        <div id="createModal" class="modal fade">
            <div class="modal-dialog" style="width: 75%">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Create</h4>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="CreateFilm?evt=create" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-xs-2 control-label">FilmName</label>
                                <div class="col-xs-7">
                                    <input type="text" class="form-control" name="name" maxlength="50" required/>

                                </div>
                            </div>                            
                            
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Image</label>
                                <div class="col-xs-6 ">                                    
                                    <input class="form-control" name="imgPath" required/>                                    
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Trailer</label>
                                <div class="col-xs-5 ">                                    
                                    <input class="form-control" name="linkTrailer" required/>                                    
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-2 control-label">OpenDay</label>
                                <div class="col-xs-4">
                                    <div class="input-group date" id='datetimepicker'>
                                        <input type='text' name="openDay" class="form-control" required/>
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
                                        <option value="">Choose Category</option>
                                        <c:forEach items="${listCategories}" var="ca">
                                            <option value="${ca.id}">${ca.name}</option>
                                        </c:forEach>                                        
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-2 control-label">Price</label>
                                <div class="col-xs-2 ">
                                    <div class="input-group">
                                        <input type="number" class="form-control" name="price" required/>
                                        <span class="input-group-addon">$</span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-2 control-label">Hot</label>
                                <div class="col-xs-1 ">
                                    <input type="checkbox" name="hot" value="true" style="margin-top: 10px;"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-xs-2 control-label">Description</label>
                                <div class="col-xs-8">
                                    <textarea id="description" name="description" class="form-control" required></textarea>
                                    <script type="text/javascript">
                                        CKEDITOR.replace('description')
                                    </script>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-5 col-xs-offset-2">
                                    <input type="submit" class="btn btn-default" value="Add Film " />
                                </div>
                            </div>
                        </form> 
                    </div>

                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>
