<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Lesson</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<script>
    $(function(){
        var StudentsDefName = "dropdown"
        var NIL = "NIL"

        function printDropdownInformation() {
            
            console.log($("#group").attr("id"));
            console.log($("#group").attr("name"));
            console.log($("#student").attr("id"));
            console.log($("#student").attr("name"));   
            console.log($("#selectedType").val());   
        }

        if($("#group").is(":visible") && $("#student").is(":visible")){
            $("#group").show();
            $("#student").hide();

            $("#group").attr("name", StudentsDefName);
            $("#student").attr("name", NIL);

            $("#selectedType").val('selectedAGroup');
        
        }

        var currentType;
        $("#type").change(function () {
            currentType = $(this).val();
            // $("#type").val("ass");
            // console.log(currentType);

            if (currentType == "student") {
                $("#group").hide();
                $("#student").show();
                
                $("#student").attr("name", StudentsDefName);
                $("#group").attr("name", NIL);

                $("#selectedType").val('selectedAStudent');

                // flipDropDownName();
                // console.log($("#selectedType").val());  

            } else {
                $("#group").show();
                $("#student").hide();
                $("#group").attr("name", StudentsDefName);
                $("#student").attr("name", NIL);

                $("#selectedType").val('selectedAGroup');
                // flipDropDownName();
                // console.log($("#selectedType").val());  
            }
        });

    });
</script>
</head>
<body>
<table border="1">
<form action="" method="post">
    <thead></thead>
    <tbody>
        <tr>
            <td><h4>Time</h4></td>
            <td>
                <input type="datetime-local" id="date" name="date">
            </td>
        </tr>
        <tr>
            <td><h4>Length</h4></td>
            <td><input type="text" name="length" id="length"></td>
        </tr>

        <tr>
            <td><h4>Type</h4></td>
            <td>
                <select name="type" id="type">
                    <option value="group"> group</option>
                    <option value="student">Individual</option>
                    
                </select>
            </td>
        </tr>

        <tr>
            <td><h4>Student(s)</h4></td>
            <td>
                <select name="dropdown" id="group">
                    <c:forEach var="group" items="${groups}">
                    	<option value="${group.id}">${group.name}</option>
                    </c:forEach>
                </select>

                <select name="dropdown" id="student">
                    <c:forEach var="student" items="${ students}">
                    	<option value="${ student.id}">${student.m_name}</option>
                    </c:forEach>
                    
                </select>
                
            </td>

        </tr>
        <input type="hidden" name="selected" id="selectedType" value="NIL">

        <tr><td colspan="2"><button type="submit">Add</button></td></tr>

        
    </tbody>
    
</form>
</table>

</body>
</html>