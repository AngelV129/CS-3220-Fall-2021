<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Group jsp</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
crossorigin="anonymous">
</head>

<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="./HomePage">Home</a></li>
    <li class="breadcrumb-item"><a href="./GroupList">Group List</a></li>
    <li class="breadcrumb-item active" aria-current="page">Editing Group: ${currentGroup}</li>
  </ol>
</nav>
<body>
<form method='post' action='./EditGroup'>
	<table class= 'table table-bordered table-primary'>
	<tbody>
		<tr>
			<%--row for name and current groupname prefiiled --%>
			<td>Name</td>
			<%--Saves the current group name as hidden in case user changes in order to be used by post methhod --%>
			<input type="hidden" name="oldKey" value="${currentGroup}">
			<td><input class="form-control" type='text' name='key' value="${currentGroup}"></td>
		</tr>
		<%--All the names of the group with a remove link nex to the group --%>
		<tr>
			<td colspan="2">
			<ul>
			<%--iterate through the araylist of names --%>
			<c:forEach var="name" items="${map[currentGroup]}">
					 <li><span>${name}  <a class="btn btn-outline-info btn-sm" role="button" href='/RemoveGroupMember?targetRemoval=${name}&key=${currentGroup}'>[Remove]</a></span></li><br>  
					 <%--c:url var="targetStudent" value="RemoveGroupMember">
					 
            <c:param name="targetRemoval" value="${name}"/>
            <c:param name="key" value="${currentGroup}"/></c:url> --%>  
			</c:forEach>
			</ul>
			</td>

		</tr>
		
		<%--save button --%>
		<tr><td colspan="2"><button class="btn btn-primary">Save</button></td></tr>
		</tbody>
	</table>
</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
        integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
        crossorigin="anonymous"></script>
</body>
</html>