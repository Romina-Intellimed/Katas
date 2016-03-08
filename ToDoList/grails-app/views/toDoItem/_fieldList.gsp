<p>
    <label>Name</label>
    <g:textField name="name" value="${toDoItemInstance?.name}"/>
</p>
<br/>

<p>
    <label>Description</label>
    <g:textField name="description" value="${toDoItemInstance?.description}"/>
</p>
<br/>

<p>
    <label>Location</label>
    <g:textField name="location" value="${toDoItemInstance?.location}"/>

</p>
<br/>

<p>
    <label>Start Date</label>
    <g:datePicker precision="day" name="startDate" value="${toDoItemInstance?.startDate}"/>

</p>
<br/>

<p>
    <label>End Date</label>
    <g:datePicker precision="day" name="endDate" value="${toDoItemInstance?.endDate}"/>

</p>
<br/>

<p>
    <label>Repeat</label>
    <g:checkBox name="repeat" value="${toDoItemInstance?.repeat? true: false}"/>

</p>
<br/>


<p>
    <label>Participant</label>
    <g:select name="participant" id ="itemParticipant" from="${todolist.ToDoParticipant.list()}" value="${toDoItemInstance?.participant?.name}"/>

</p>
<br/>


<p>
    <label>Participants</label>
    <g:select name="participants" id ="itemParticipant" from="${todolist.ToDoParticipant.list()}" multiple="multiple" optionKey="id" size="5" value="${toDoItemInstance?.participants*.name}"/>

</p>
<br/>


<p>
    <label>Remind Date</label>
    <g:datePicker precision="day" name="remindDate" value="${toDoItemInstance?.remindDate}"/>

</p>
<br/>

<p>
    <label>Prioriy</label>
    <g:select name="priority" id="itemPrioriy" from="${todolist.PriorityType.values()}"
              value="${toDoItemInstance?.priority}"></g:select>
</p>