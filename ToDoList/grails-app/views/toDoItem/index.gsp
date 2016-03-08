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
<p>
    <a href="<g:createLink controller="toDoParticipant" action="create"/>"><g:img dir="images" file="add.png" width="25" height="25" /></a>
    <span class="newTaskField"> New Participant</span>
</p>
</br>
<div>
<p>
<g:form name="searchItem" url="[controller: 'toDoItem', action: 'search']">
    <input type="submit" class="search" value="" />
    <g:textField name="entry" placeholder="Type the searched entry" var="searchedItem"></g:textField>
</g:form>
</p>
</div>
</br>
<table>
    <tr>
        <th><a href="<g:createLink action="sort_byName"  />">Name</a></th>
        <th>Description</th>
        <th><a href="<g:createLink action="sort_byStartDate" id="startDate"/>">Start Date</a></th>
        <th><a href="<g:createLink action="sort_byEndDate" id="endDate"/>">End Date</a></th>
        <th>Repeat</th>
        <th>Participants</th>
        <th><a href="<g:createLink action="sort_byRemindDate" id=""/>">Remind Date</a></th>
        <th>Priority</th>
        <th>More Actions</th>
    </tr>
    <g:render template="/toDoItem/toDoItemsTable" model="[toDoListItems: toDoListItems]"/>

</table>

</div>

<br/>
<br/>

<p>

</p>
</body>
</html>