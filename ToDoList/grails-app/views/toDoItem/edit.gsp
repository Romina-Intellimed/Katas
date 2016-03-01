<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 23.02.2016
  Time: 14:17
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Edit item</title>
</head>

<body>
<g:form controller="toDoItem" action="save">
    <g:hiddenField name="id" value="${toDoItemInstance.id}" />
    <label>Name</label>
    <g:textField name="name" value="${toDoItemInstance.name}"/>
    <br/>
    <label>Description</label>
    <g:textField name="description" value="${toDoItemInstance.description}"/>
    <br/>
    <label>Location</label>
    <g:textField name="location" value="${toDoItemInstance.location}"/>
    <br/>
    <label>Start Date</label>
    <g:datePicker name="startDate" value="${toDoItemInstance.startDate}"/>
    <br/>
    <label>End Date</label>
    <g:datePicker name="endDate" value="${toDoItemInstance.endDate}"/>
    <br/>
    <label>Repeat</label>
    <g:checkBox name="repeat" value="${toDoItemInstance.repeat}"/>
    <br/>
    <label>Remind Date</label>
    <g:datePicker name="remindDate" value="${toDoItemInstance.remindDate}"/>
    <br/>
    <label>Prioriy</label>
    <g:select name="itemPriority" id="itemPrioriy" from="${todolist.PriorityType.values()}" value="${toDoItemInstance.priority}"  optionValue="id"></g:select>
    <br/>




    <input type="submit" name="_action_save" value="save">
</g:form>
</body>
</html>