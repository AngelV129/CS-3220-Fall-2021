<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Polls</title>
</head>
<body>
<table border="1">
	<c:forEach var='poll' items="${polls}">
		<td><a href="DisplayPoll?id=${poll.id}">${poll.question}</a></td>
		<td>Add Answers</td>
	</c:forEach >
</table>
</body>
</html>