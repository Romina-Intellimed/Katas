<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 19.02.2016
  Time: 12:01
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Create new ToDo Item</title>
</head>

<body>
<div class="fields">
    <g:form name="createNewToDoItem" url="[controller: 'toDoItem', action: 'addNew']">
        <h1>Enter details for the new Task</h1>
        <p>
        <label >Name</label><input type="text" value="" name="name"/>
        <br/>
        </p>
        <p>
        <label>Description</label><input type="text" value="" name="description"> </input>
        <br/>
        </p>
        <p>
        <label>Location</label><input type="text" value="" name="location"> </input>
        </p>
        <label>Start Date</label><g:datePicker name="startDate" value="${new Date()}"
                      precision="day" years="${2016..2070}"/>
        <p>
        <label>End Date</label><g:datePicker name="endDate" value="${new Date()}"
                                                       precision="day" years="${2016..2070}"/>
        </p>
        <p>
        <label>Repeat</label><g:checkBox name="repeat" value="${false}" />
        </p>

        <p>
            <label>Remind Date</label><g:datePicker name="remindDate" value="${new Date()}"
                                                 precision="day" years="${2016..2070}"/>
        </p>
        <p>
        <label>Priority</label>
        <g:select name="priority" id="itemPrioriy" from="${todolist.PriorityType.values()}" value="${todolist.PriorityType}"  optionValue="id"></g:select>
        <br/>
        </p>

        <br/>
        <g:actionSubmit value="Cancel" action="index"/>
        <input type="submit" value="Add new"> </input>
    </g:form>
</div>
</body>
</html>