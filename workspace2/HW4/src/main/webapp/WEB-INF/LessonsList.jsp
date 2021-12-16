<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lessons List</title>
</head>
<body>
<p><a href="AddLesson">Add Lesson</a></p>

<table border="1">
	<thead>
		<tr>
			<th>Time</th>
			<th>Length</th>
			<th>Student(s)</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="lesson" items="${lessons}">
		<tr>
			<td><fmt:formatDate value="${lesson.date}" pattern="MM/dd/yyyy hh:mm a"/></td>
			<td>${lesson.length }</td>
			<c:choose>
	        <c:when test="${lesson.studentID > 0}">
	            <td> ${lesson.studentName}</td>
	        </c:when>
	        <c:otherwise>
	            <td><a href="">${lesson.groupName}</a></td>
	        </c:otherwise>
	    </c:choose>
	    </tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>