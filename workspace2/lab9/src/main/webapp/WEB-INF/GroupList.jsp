<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Group List</title>
</head>
<body>


<div><a href='./AddGroup'>New Group</a></div> <br>
<table border=1>
	<thead>
		<tr>
			<th><b>Group</b></th>
			<th><b>Members</b></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="entry" items="${map}">
			<tr>
				<td>
					${entry.key}
				</td>
				<td>
					<c:forEach var="name" items="${entry.value}">
						 <span>${name}  </span>    
					</c:forEach>
				</td>
			</tr>
			
		</c:forEach>
		
	</tbody>
</table>

</body>
</html>