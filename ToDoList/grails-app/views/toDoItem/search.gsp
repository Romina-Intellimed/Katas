<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 23.02.2016
  Time: 17:42
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Results</title>
</head>

<body>
<ul>
    <g:each in="${itemsContainingWord}" var="item">
        <li>${item.name}</li>
    </g:each>
</ul>
</body>
</html>