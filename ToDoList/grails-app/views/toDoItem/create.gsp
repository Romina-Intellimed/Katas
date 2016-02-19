<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 19.02.2016
  Time: 12:01
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create new ToDo Item</title>
</head>

<body>
<g:form name="createNewToDoItem" url="[controller: 'toDoItem', action: 'addNew']">
    <label>Enter name for new item</label><input type="text" value="" name="itemName"> </input>
    <input type="submit" value="Add new"> </input>
</g:form>
</body>
</html>