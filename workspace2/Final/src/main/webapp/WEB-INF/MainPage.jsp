<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Final Main Page</title>
</head>
<body>
<h3>Attendance Tracker</h3>

<a href="">Add Student</a> | <a href="">Add Student</a>

<table border='1'>
	<thead>
	<tr>
		<th></th>
		<c:forEach var = "event" items="${events}">
			
				<th>${event.name}</th>
			
		</c:forEach>
		</tr>
	</thead>
	<tbody>
	
	<c:forEach var="Attend" items="${Attendances}">
	
		<tr>
				<td>${Attend.studentName}</td>
			
			<c:forEach var="choice" items="${Attend.didAttendList }">
				<c:choose>
	        		<c:when test='${choice == "Yes"}'>
	            		<td>Yes</td>
	            	</c:when>
	            	<c:when test='${choice == "No"}'>
	            		<td>No</td>
	            	</c:when>
	            	<c:otherwise>
	            		<td> <a href=''>Yes</a> | <a href="">NO</a></td>
	        		</c:otherwise>
	            </c:choose>
			</c:forEach>
		</tr>
		
		
	</c:forEach>
		
	</tbody>
</table>

</body>
</html>