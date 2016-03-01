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
    <g:hiddenField name="id" value="${toDoItemInstance.id}"/>
    <p>
        <label>Name</label>
        <g:textField name="name" value="${toDoItemInstance.name}"/>
    </p>
    <br/>

    <p>
        <label>Description</label>
        <g:textField name="description" value="${toDoItemInstance.description}"/>
    </p>
    <br/>

    <p>
        <label>Location</label>
        <g:textField name="location" value="${toDoItemInstance.location}"/>

    </p>
    <br/>

    <p>
        <label>Start Date</label>
        <g:datePicker precision="day" name="startDate" value="${toDoItemInstance.startDate}"/>

    </p>
    <br/>

    <p>
        <label>End Date</label>
        <g:datePicker precision="day" name="endDate" value="${toDoItemInstance.endDate}"/>

    </p>
    <br/>

    <p>
        <label>Repeat</label>
        <g:checkBox name="repeat" value="${toDoItemInstance.repeat}"/>

    </p>
    <br/>

    <p>
        <label>Remind Date</label>
        <g:datePicker precision="day" name="remindDate" value="${toDoItemInstance.remindDate}"/>

    </p>
    <br/>

    <p>
        <label>Prioriy</label>
        <g:select name="priority" id="itemPrioriy" from="${todolist.PriorityType.values()}"
                  value="${toDoItemInstance.priority}" optionValue="id"></g:select>
    </p>
    <br/>
    <input type="submit" name="_action_save" value="save">
</g:form>
</body>
</html>