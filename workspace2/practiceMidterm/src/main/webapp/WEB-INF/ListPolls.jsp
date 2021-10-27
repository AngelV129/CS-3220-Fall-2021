<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Polls</title>
</head>
<p><a href='CreatePoll'>Create Poll</a></p>
<body>
<table border="1">
	<c:forEach var='poll' items="${polls}">
	<tr>
		<td><a href="DisplayPoll?id=${poll.id}">${poll.question}</a></td>
		<td><a href="AddAnswers?id=${poll.id}">Add Answers</a></td>
	</tr>
	</c:forEach >
</table>
</body>
</html>