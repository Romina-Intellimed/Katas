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
    ${helloString}

    <table>
        <tr>
            <th>Name</th>
            <th>Decription</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Repeat</th>
            <th>Remind Date</th>
            <th>Priority</th>
        </tr>
    <g:each in="${todoListItems}" var="item">
        <tr>

                <td>${item?.name}</td>
                <td>${item?.description}</td>
                <td>${item?.startDate}</td>
                <td>${item?.endDate}</td>
                <td>${item?.repeat}</td>
                <td>${item?.remind}</td>
                <td>${item?.priority}</td>

        </tr>
    </g:each>
    </table>


</div>

<br/>
Search entries by name
<g:form name="searchItems" url="[controller: 'toDoItem', action: 'search']">
    <label>Enter name for the searched item</label><input type="text" value="" name="entry"> </input>
    <input type="submit" value="Search Items"> </input>
</g:form>

</body>
</html>