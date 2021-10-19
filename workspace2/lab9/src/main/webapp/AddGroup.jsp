<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Group</title>
</head>
<body>
<p><h1>Add group</h1></p>

<form action='AddGroup' method='post'>
	<table border=1>
		<tr>	
			<td><span style="font-weight:bold">Name</span></td>
			<td><input type='text' name='group-name'size='25'>
			
		</tr>
		<tr><td><button>Add</button></td></tr> 
	</table>
	
</form>

</body>
</html>