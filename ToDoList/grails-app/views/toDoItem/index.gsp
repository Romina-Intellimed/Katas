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
    <ul>
        <g:each in="${todoListItems}" var="item">
            <li>${item.name}</li>
        </g:each>
    </ul>

    Item with name "Learn Grails":
    ${learnGrailsItem}
</div>

<br/>
Search entries by name
<g:form name="searchItems" url="[controller: 'toDoItem', action: 'search']">
    <label>Enter name for the searched item</label><input type="text" value="" name="entry"> </input>
    <input type="submit" value="Search Items"> </input>
</g:form>

</body>
</html>