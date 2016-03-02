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
    <g:each in="${itemsContainingWord}" var="item">
        <tr onclick='document.location = "<g:createLink action='show' id='${item.id}'/>" '>
            <td>${item?.name}</td>
            <td>${item?.description}</td>
            <td><g:formatDate date="${item?.startDate}" format="yyyy-MM-dd"/></td>
            <td><g:formatDate date="${item?.endDate}" format="yyyy-MM-dd"/></td>
            <td>${item?.repeat ? "Yes" : "No"}</td>
            <td><g:formatDate date="${item?.remindDate}" format="yyyy-MM-dd"/></td>
            <td>${item?.priority}</td>
            <td>
                <a href="<g:createLink action="edit" id='${item.id}'/>"><g:img dir="images" file="edit.jpg"
                                                                               width="30" height="30"/></a>
                <a href="<g:createLink action="delete" id='${item.id}'/>"><g:img dir="images" file="delete.jpg"
                                                                                 width="30" height="30"/></a>
            </td>
        </tr>
    </g:each>
</table>
<g:form controller="toDoItem">
    <g:actionSubmit value="Cancel" action="index"/>
</g:form>
</body>

</html>