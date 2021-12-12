<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lessons List</title>
<!-- Bootstrap CSS -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" 
   rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" 
   crossorigin="anonymous">

   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" 
   integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" 
   crossorigin="anonymous" referrerpolicy="no-referrer" />
   
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   
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