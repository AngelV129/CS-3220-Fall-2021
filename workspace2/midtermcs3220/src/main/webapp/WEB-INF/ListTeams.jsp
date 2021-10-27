<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Teams</title>
</head>
<p><a href='AddTeam'>Add Team</a> | <a href='AddGameScore'>Add Game Score</a></p>
<body>
<table border="1">
<c:forEach var='team' items="${teams}">
	<tr>
		<td><a href="Scores">${team.name}</a></td>
		<td>${team.wins } - ${team.losses}</td>
	</tr>
	</c:forEach >

</table>
</body>
</html>