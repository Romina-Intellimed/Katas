<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 18.02.2016
  Time: 17:05
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<div id="page-body">
    <p>
        <a href="<g:createLink action="create"/>"> <g:img dir="images" file="add.png" width="30" height="30" /></a>
        New Task
    </p>
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
        <g:each in="${todoListItems}" var="item">
            <tr onclick='document.location = "<g:createLink action='edit' id='${item.id}'/>" '>
                <td>${item?.name}</td>
                <td>${item?.description}</td>
                <td>${item?.startDate} </td>
                <td>${item?.endDate}</td>
                <td>${item?.repeat}</td>
                <td>${item?.remindDate}</td>
                <td>${item?.priority}</td>
                <td>
                    <a href="<g:createLink action="edit"  id='${item.id}'/>"> <g:img dir="images" file="edit.jpg" width="30" height="30" /></a>
                    <a href="<g:createLink action="delete" id='${item.id}'/>"> <g:img dir="images" file="delete.jpg" width="30" height="30" /></a>
                </td>
            </tr>
        </g:each>
    </table>

</div>

<br/>
<br/>

<p>

<g:form name="searchItems" url="[controller: 'toDoItem', action: 'search']">
    Search by task name <input type="text" value="" name="entry"> </input>
    <input type="submit" value="Search Items"> </input>
</g:form>
</p>
</body>
</html>