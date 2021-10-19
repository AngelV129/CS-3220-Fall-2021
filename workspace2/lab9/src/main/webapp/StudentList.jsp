<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>
<h2>STUDENT LIST</h2>
<div><a href='./AddStudent'>New Student</a></div> <br>
<table border=1>
	<thead>
		<tr>
			<th><b>Name</b></th>
			<th><b>Age</b></th>
			<th><b>Parent</b></th>
			<th><b>Email</b></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="student" items="${entries}">
			<td>${student.m_name}</td>
			<td>${student.m_age}</td>
			<td>${student.m_parent_name}</td>
			<td>${student.m_eMail}</td>
		</c:forEach>
	</tbody>
</table>

</body>
</html>