<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Group List</title>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" 
rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
crossorigin="anonymous">
</head>
<body>

<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="./HomePage">Home</a></li>
    <li class="breadcrumb-item active" aria-current="page">Group List</li>
  </ol>
</nav>


<div><a class="btn btn-danger" role="button" href='./AddGroup'>New Group</a></div> <br>
<table class= 'table table-bordered table-primary'>
	<thead>
		<tr>
			<th><b>Group</b></th>
			<th><b>Members</b></th>
			<th><b>Edit</b></th>
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
				<td>
					<a class="btn btn-primary" href='EditGroup?key=${entry.key}' role="button">Edit</a>
				</td>
			</tr>
			
		</c:forEach>
		
	</tbody>
</table>

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