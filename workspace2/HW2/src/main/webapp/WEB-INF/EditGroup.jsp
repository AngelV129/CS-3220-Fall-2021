<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Group jsp</title>
</head>
<body>
<form method='post' action='./EditGroup'>
	<table border=1>
	<tbody>
		<tr>
			<%--row for name and current groupname prefiiled --%>
			<td>Name</td>
			<%--Saves the current group name as hidden in case user changes in order to be used by post methhod --%>
			<input type="hidden" name="oldKey" value="${currentGroup}">
			<td><input type='text' name='key' value="${currentGroup}"></td>
		</tr>
		<%--All the names of the group with a remove link nex to the group --%>
		<tr>
			<td colspan="2">
			<ul>
			<%--iterate through the araylist of names --%>
			<c:forEach var="name" items="${map[currentGroup]}">
					 <li><span>${name}  <a href='RemoveGroupMember?targetRemoval=${name}&key=${currentGroup}'>[Remove]</a></span></li>  
					 <%--c:url var="targetStudent" value="RemoveGroupMember">
            <c:param name="targetRemoval" value="${name}"/>
            <c:param name="key" value="${currentGroup}"/></c:url> --%>  
			</c:forEach>
			</ul>
			</td>

		</tr>
		
		<%--save button --%>
		<tr><td colspan="2"><button>Save</button></td></tr>
		</tbody>
	</table>
</form>

</body>
</html>