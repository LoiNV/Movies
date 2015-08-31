<%-- 
    Document   : viewAll
    Created on : Aug 17, 2015, 8:04:20 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>

        <title>Film Admin - Categories</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="adminTemplate.jsp" %>
            <div id="page-wrapper">
                <div class="container-fluid" style="width: 60%">
                    <h1>Categories</h1>
                    <a href="#" onclick="$('#createModal').modal('show');">Create</a>
                    <table cellpadding="0" cellspacing="0" border="0" 
                           class="table table-striped table-bordered" id="datatable">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th style="width: 30%; text-align: center">Editor</th>
                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${listCategory}" var="ca">
                                <tr>
                                    <td>${ca.id}</td>
                                    <td>${ca.name}</td>
                                    <td style="text-align: center">
                                        <a  onclick="return confirm('Are you sure?')" href="CreateCategory?id=${ca.id}&evt=delete"><div class="fa fa-remove"> </div></a> | 
                                        <a href="CreateCategory?id=${ca.id}&evt=edit"> <div class="fa fa-edit"> </div></a>
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
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">Create</h4>
                    </div>
                    <div class="modal-body">
                        <form method="post" class="form-horizontal" action="CreateCategory?evt=create">
                            <div class="form-group">
                                <label class="col-xs-2 control-label">Category</label>
                                <div class="col-xs-4">
                                    <input type="text" class="form-control" name="createName" required/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-xs-5 col-xs-offset-2">
                                    <input type="submit" class="btn btn-default" value="Create" />
                                </div>
                            </div>
                        </form>
                    </div>

                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->        

    </body>
</html>
