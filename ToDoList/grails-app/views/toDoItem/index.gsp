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
<div>
    <p>
        <a href="<g:createLink action="create"/>"> <g:img dir="images" file="add.png" width="30" height="30"/></a>
        New Task
    </p>
%{--<g:form name="searchItems" url="[controller: 'toDoItem', action: 'search']">--}%
    <g:form action="search" method="GET">
        <g:img dir="images" file="search.png" width="30" height="30"/>
        <g:textField name="entry" value="Type the searched entry"></g:textField>
    </g:form>

%{-- </g:form>
 <a href="<g:createLink action="search" method="GET"/>"> <g:img dir="images" file="search.png" width="30" height="30" /></a> <input type="text" value="" name="entry"> </input>
 <input type="submit" value="Search Items"> </input>--}%

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