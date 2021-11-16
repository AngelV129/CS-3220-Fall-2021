<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="./HomePage">Home Page</a></li>
    <li class="breadcrumb-item"><a href="./StudentLIst">Student List</a></li>
    <li class="breadcrumb-item active" aria-current="page">Editing Student: ${currentstudent.m_name}</li>
  </ol>
</nav>

<form action='EditStudent' method='post'>
	<table class="table table-bordered table-primary">
		<tr>
			<td><span style=text-align: center; font-weight: bold>Name</span></td>
        	<td><input class="form-control" type='text' name='student-name'size='25' value="${currentstudent.m_name}"></td>
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Birth Year</span></td>
        	<td><input class="form-control" type='text' name='student-birth'size='25' value="${2021 - currentstudent.m_age}">
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Parent Name</span></td>
        	<td><input class="form-control" type='text' name='student-parent'size='25' value="${currentstudent.m_parent_name}">
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Parent Email</span></td>
        	<td><input type="email"  class="form-control" type='text' name='student-pEmail'size='25' value="${currentstudent.m_eMail}">
        </tr>
        
        <tr>
        	<td><span style=text-align: center; font-weight: bold>Group</span></td>
       	 	<td><select class="form-select" aria-label="Default select example" name='group'>
        <option value=""></option>
        
        <c:forEach var="entry" items="${map}">
        		
        		<c:if test="${entry.value.size() < 5}">
        		<%-- check to make the student's group as highlighted --%>
        			<c:choose>
        				<c:when test="${entry.key == currentGroup}">
        					<option value='${entry.key}' selected>${entry.key}</option>
        				</c:when>
        				<%-- add normally without using select --%>
        				<c:otherwise>
        					<option value='${entry.key}'>${entry.key}</option>
        				</c:otherwise>
        			</c:choose>
        			
        		</c:if>
        </c:forEach>
        </select>
        </td>
        </tr>
        <tr><td colspan="2"> <button class="btn btn-primary"> Save </button></td></tr>
        <input type="hidden" name="id" value=${param.id }>
        
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