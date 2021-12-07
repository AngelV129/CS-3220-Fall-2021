<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<tr>
		<th></th>
		<th>Mon</th>
		<th>TUE</th>
		<th>WED</th>
		<th>THR</th>
		<th>Fri</th>
	</tr>
	<tbody>
	
		<!--<c:forTokens items="08:00-09:00,09:00-10:00,10:00-11:00,11:00-12:00,12:00-13:00,14:00-15:00,15:00-16:00,16:00-17:00" delims="," var = "stamp">
			<tr>
				<td><c:out value="${stamp}"></c:out></td>
				
			</tr>
		</c:forTokens>--->
		
		<c:forEach var = "time" items="${times }">
		<tr>
			<td><c:out value="${time}"></c:out></td>
			<c:forEach var="day" items="${days}">
				<td>
					<c:forEach var="res" items="${reserves}">
							<c:if test="${ res.day == day && res.time == time}">
								<a href="RemoveReservation?targetID=${res.id}">${res.customerName }  </a>
							</c:if>
					</c:forEach>
				</td>
			</c:forEach>
		</tr>	
		</c:forEach>
		
	</tbody>
	
</table>
<form method="post">
	    <select name="day">
	        <c:forEach var="days" items="${days }">
	            <option value="${days}"> ${days} </option>
	        </c:forEach>
	    </select>
	    <select name="time">
	        <c:forEach var="times" items="${times}">
	            <option value="${times}"> ${times} </option>
	        </c:forEach>
	    </select>
	    <input type="text" name="name" />
	    <input type="submit" name="reserve" value="Reserve" /> 
</form>

</body>
</html>