<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 18.02.2016
  Time: 17:05
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
${helloString}
<ul>
    <g:each in="${todoListItems}" var="item">
        <li>${item.name}</li>
    </g:each>
</ul>

Item with name "Learn Grails":
${learnGrailsItem}

</body>
</html>