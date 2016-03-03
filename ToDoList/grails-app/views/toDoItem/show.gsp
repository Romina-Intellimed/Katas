<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 23.02.2016
  Time: 13:36
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Show and Item</title>
</head>

<body>
<div>
    <p>Task Name: ${toDoItemInstance?.name}</p>

    <p>Task Description: ${toDoItemInstance?.description}</p>

    <p>Location: ${toDoItemInstance?.location}</p>

    <p>Start Date: ${toDoItemInstance?.startDate}</p>

    <p>End Date: ${toDoItemInstance?.endDate}</p>

    <p>Repeat Task: ${toDoItemInstance?.repeat}</p>

    <p>Remind Date: ${toDoItemInstance?.remindDate}</p>

    <p>Task Priority: ${toDoItemInstance?.priority}</p>
</div>
<g:form controller="toDoItem">
    <g:actionSubmit value="Back" action="index"/>
</g:form>
</html>