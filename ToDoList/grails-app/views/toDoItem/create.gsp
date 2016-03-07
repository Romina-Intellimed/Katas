<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 19.02.2016
  Time: 12:01
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Create new ToDo Item</title>
</head>

<body>
<div class="fields">
    <g:form name="createNewToDoItem" url="[controller: 'toDoItem', action: 'addNew']">
        <h1>Enter details for the new Task</h1>
        <g:render template="/toDoItem/fieldList"/>

        <br/>
        <g:actionSubmit value="Cancel" action="index"/>
        <input type="submit" value="Add new"> </input>
    </g:form>
</div>
</body>
</html>