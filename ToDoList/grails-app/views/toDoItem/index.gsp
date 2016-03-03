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

<p>
    <a href="<g:createLink action="create"/>"><g:img dir="images" file="add.png" width="25" height="25" /></a>
   <span class="newTaskField"> New Task</span>
</p>
</br>
<div>
<p>
<g:form name="searchItem" url="[controller: 'toDoItem', action: 'search']">
    <input type="submit" class="search" value="" />
    <g:textField name="entry" value="Type the searched entry" var="searchedItem"></g:textField>
    %{--<g:select name="orderBy" from="${todoList}" value="${todoList}"/>--}%
</g:form>
</p>
</div>
</br>
<table>
    <tr>
        <th><a href="<g:createLink action="sort_byName" id=""/>">Name</a></th>
        <th>Description</th>
        <th><a href="<g:createLink action="sort_byStartDate" id=""/>">Start Date</a></th>
        <th><a href="<g:createLink action="sort_byEndDate" id=""/>">End Date</a></th>
        <th>Repeat</th>
        <th><a href="<g:createLink action="sort_byRemindDate" id=""/>">Remind Date</a></th>
        <th>Priority</th>
        <th>More Actions</th>
    </tr>
    <g:each in="${todoListItems}" var="item">
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

</div>

<br/>
<br/>

<p>

</p>
</body>
</html>