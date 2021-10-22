<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddStudent</title>
</head>
<body>

<form action='AddStudent' method='post'>
	<table border=1>
		<tr>
			<td><span style=text-align: center; font-weight: bold>Name</span></td>
        	<td><input type='text' name='student-name'size='25'></td>
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Birth Year</span></td>
        	<td><input type='text' name='student-birth'size='25'>
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Parent Name</span></td>
        	<td><input type='text' name='student-parent'size='25'>
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Parent Email</span></td>
        	<td><input type='text' name='student-pEmail'size='25'>
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Group</span></td>
       	 	<td><select name='group' width=2em style='width: 50px;'>
        <option value='N/A'></option>
        
        <c:forEach var="entry" items="${map}">
        		
        		<c:if test="${entry.value.size() < 5}">
        			<option value='${entry.key}'>${entry.key}</option>
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