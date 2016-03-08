<g:each in="${toDoListItems}" var="item">
    <tr onclick='document.location = "<g:createLink action='show' id='${item.id}'/>" '>
        <td>${item?.name}</td>
        <td>${item?.description}</td>
        <td><g:formatDate date="${item?.startDate}" format="yyyy-MM-dd"/></td>
        <td><g:formatDate date="${item?.endDate}" format="yyyy-MM-dd"/></td>
        <td>${item?.repeat ? "Yes" : "No"}</td>
        <td>${item?.participant.name}</td>
        <td><g:formatDate date="${item?.remindDate}" format="yyyy-MM-dd"/></td>
        <td>${item?.priority}</td>
        <td>
            <a href="<g:createLink action="edit" id='${item.id}'/>"><g:img dir="images" file="edit.jpg"
                                                                           width="30" height="30"/></a>
            <a href="<g:createLink action="delete" id='${item.id}'/>"><g:img dir="images" file="delete.jpg"
                                                                             width="30" height="30"/></a>
        </td>
    </tr>
</g:each>