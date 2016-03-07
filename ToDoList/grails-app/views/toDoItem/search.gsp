<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 23.02.2016
  Time: 17:42
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Search Results</title>
</head>

<body>


<table>
    <tr>
        <th>Name</th>
        <th>Decription</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Repeat</th>
        <th>Remind Date</th>
        <th>Priority</th>
        <th>More Actions</th>
    </tr>

       <g:render template="/toDoItem/toDoItemsTable" model="[toDoListItems: itemsContainingWord]"/>
</table>
<g:form controller="toDoItem">
    <g:actionSubmit value="Back" action="index"/>
</g:form>
</body>

</html>