<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 23.02.2016
  Time: 14:17
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Edit item</title>
</head>

<body>
<g:form controller="toDoItem" action="save" >
    <g:hiddenField name="id" value="${toDoItemInstance.id}"/>
    <g:render template="/toDoItem/fieldList"/>
    <br/>
    <g:actionSubmit value="Cancel" action="index"/>
    <input type="submit" name="_action_save" value="save">
</g:form>

</body>
</html>