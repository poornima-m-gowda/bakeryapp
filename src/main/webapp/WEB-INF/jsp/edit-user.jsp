<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Edit User </title>
</head>


<body>

	<jsp:include page="main.jsp" /> 
	
	<h2>Edit User</h2>
	
	<form:form modelAttribute="user" method="POST" >
	
	<!-- associate data with userId -->
	<form:hidden path="id"/>
	
	<table>
		<tbody>
			<tr>
			<th>First Name</th>
			<td><form:input type="text" path="firstName" required="true"/></td>
			</tr>	
		
			<tr>
			<th>Last Name</th>
			<td><form:input type="text" path="lastName" required="true"/></td>
			</tr>
			
			<tr>
			<th>Email</th>
			<td><form:input type="text" path="email" required="true"/></td>
			</tr>
			
			<tr>
			<th>Password</th>
			<td><form:input type="password" path="password" id="password" onkeyup='check();' required="true"/></td>
			</tr>
			
			<tr>
			<th>Confirm Password</th>
			<td><form:input type="password" path="confirmPassword"  
				id="confirm_password" onkeyup='check();' required="true" />
			<span id='message'></span></td> 	
			</tr>
						
			<tr>
			<th>Role</th>
			<td><form:input type="text" path="role" required="true"/></td>
			</tr>
			
			<tr>
			<td><input type="submit" Value="Update"/></td>
			</tr>
			
		</tbody>
	</table>
	</form:form>

	<a href="${pageContext.request.contextPath}/users">Cancel</a>
	
	
	<!-- java scripts -->

	<script type="text/javascript">
	var check = function() {
		  if (document.getElementById('password').value ==
		    document.getElementById('confirm_password').value) {
		    document.getElementById('message').style.color = 'green';
		    document.getElementById('message').innerHTML = 'matching';
		  } else {
		    document.getElementById('message').style.color = 'red';
		    document.getElementById('message').innerHTML = 'not matching';
		  }
		}
	
	function validate(){
		if(document.getElementById('password').value ==
		    document.getElementById('confirm_password').value){
			return false;
		}
		return true;
	}
   </script>
	
	
</body>

</html>