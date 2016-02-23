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
        <g:if test="${toDoItemInstance?.id}">
            <span><g:fieldValue bean="${toDoItemInstance}" field="name"></g:fieldValue></span>
        </g:if>
    </div>

</body>
</html>