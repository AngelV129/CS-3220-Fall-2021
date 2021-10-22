<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
</head>
<body>
<h2>booty</h2>
<form action='EditStudent' method='post'>
	<table border=1>
		<tr>
			<td><span style=text-align: center; font-weight: bold>Name</span></td>
        	<td><input type='text' name='student-name'size='25' value="${currentstudent.m_name}"></td>
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Birth Year</span></td>
        	<td><input type='text' name='student-birth'size='25' value="${currentstudent.m_age}">
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Parent Name</span></td>
        	<td><input type='text' name='student-parent'size='25' value="${currentstudent.m_parent_name}">
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Parent Email</span></td>
        	<td><input type='text' name='student-pEmail'size='25' value="${currentstudent.m_eMail}">
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Group</span></td>
       	 	<td><select name='group' width=2em style='width: 50px;'>
        <option value='N/A'></option>
        
        <c:forEach var="entry" items="${map}">
        		
        		<c:if test="${entry.value.size() < 5}">
        		<%-- check to make the student's group as highlighted --%>
        			<c:choose>
        				<c:when test="${entry.key == currentGroup}">
        					<option value='${entry.key}' selected>${entry.key}</option>
        				</c:when>
        				<%-- add normally without using select --%>
        				<c:otherwise>
        					<option value='${entry.key}'>${entry.key}</option>
        				</c:otherwise>
        			</c:choose>
        			
        		</c:if>
        </c:forEach>
        </select>
        </td>
        </tr>
        <tr><td colspan="2"> <button> Add </button></td></tr>
        
	</table>
</form>

</body>
</html>