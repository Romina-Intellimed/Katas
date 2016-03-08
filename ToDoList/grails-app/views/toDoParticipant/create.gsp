<%--
  Created by IntelliJ IDEA.
  User: romina
  Date: 07.03.2016
  Time: 17:45
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
</head>

<body>
<div>
    <g:form name="createNewToDoParticipant" url="[controller: 'toDoParticipant', action: 'addNew']">

        <p>
            <label>Name</label>
            <g:textField name="name" value="${toDoParticipantInstance?.name}"/>
        </p>
        <br/>

        <p>
            <label>Email Address</label>
            <g:textField name="description" value="${toDoParticipantInstance?.emailAddress}"/>
        </p>
        <br/>

        <p>
            <label>Age</label>
            <g:textField name="location" value="${toDoParticipantInstance?.age}"/>
        </p>
        <br/>
        %{--<g:actionSubmit value="Cancel"   action="index"/>--}%
        <input type="submit" value="Add new"> </input>
    </g:form>
</div>
</body>
</html>