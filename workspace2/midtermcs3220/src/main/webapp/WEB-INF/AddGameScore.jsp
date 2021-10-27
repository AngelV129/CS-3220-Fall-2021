<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Game Score</title>
</head>
<body>
<form method='post'>
<select name="leftid">
<c:forEach var="team" items="${teams}">
	
	<option value='${team.id}'>${team.name}</option>
	
</c:forEach> 
</select>

: <input type="text" name='leftscore'>

<select name="rightid">
<c:forEach var="team" items="${teams}">
	
	<option value='${team.id}'>${team.name}</option>
	
</c:forEach> 
</select>

: <input type="text" name='rightscore'>
<button>Add</button>
</form>

</body>
</html>