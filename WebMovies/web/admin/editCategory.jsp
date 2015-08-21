<%-- 
    Document   : editCategory
    Created on : Aug 21, 2015, 1:41:12 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>Edit Category</title>
    </head>
    <body>
        <div id="wrapper">
            <%@include file="adminTemplate.jsp" %>
            <div id="page-wrapper">
                
                <form method="post" class="form-horizontal" action="CreateCategory?evt=doEdit&id=${category.id}">
                    <div class="form-group">
                        <label class="col-xs-3 control-label"><h2>Edit Category</h2></label>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-2 control-label">Name</label>
                        <div class="col-xs-4">
                            <input value="${category}" class="form-control" name="editName" required/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="col-xs-5 col-xs-offset-2">
                            <input type="submit" class="btn btn-default" value="Edit" />
                        </div>
                    </div>
                </form>
            </div>

        </div>

    </body>
</html>
