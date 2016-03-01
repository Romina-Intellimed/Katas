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
        <label >Name</label><input type="text" value="" name="itemName"/>
        <br/>
        </p>
        <p>
        <label>Description</label><input type="text" value="" name="itemDescription"> </input>
        <br/>
        </p>
        <p>
        <label>Location</label><input type="text" value="" name="itemLocation"> </input>
        </p>
        <label>Start Date</label><g:datePicker name="itemStartDate" value="${new Date()}"
                      precision="day" years="${2016..2070}"/>
        <p>
        <label>End Date</label><g:datePicker name="itemEndDate" value="${new Date()}"
                                                       precision="day" years="${2016..2070}"/>
        </p>
        <p>
        <label>Repeat</label><g:checkBox name="itemRepeat" value="${false}" />
        </p>

        <p>
            <label>Remind Date</label><g:datePicker name="itemRemindDate" value="${new Date()}"
                                                 precision="day" years="${2016..2070}"/>
        </p>
        <p>
        <label>Priority</label>
        <g:select name="itemPriority" id="itemPrioriy" from="${todolist.PriorityType.values()}" value="${todolist.PriorityType}"  optionValue="id"></g:select>
        <br/>
        </p>

        <br/>

        <input type="submit" value="Add new"> </input>
    </g:form>
</div>
</body>
</html>