<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scoresjsp</title>
</head>
<body>

<ul>
<div>outside for loop</div>
<c:forEach items="${games}" var="game">
<div>fsafdfdsf</div>

	
		<div>
	
		<c:if test="${game.leftID == id} ">
			
			<li>${game.leftTeam } ${game.leftScore } - ${game.rightTeam } ${game.rightScore }</li>
		</c:if>
		
		<c:if test="${game.rightID == id}">
			<li>${game.rightTeam } ${game.rightScore } - ${game.leftTeam } ${game.leftScore }</li>
		</c:if>
		
		</div>
	
	
</c:forEach> 
</ul>

</body>
</html>