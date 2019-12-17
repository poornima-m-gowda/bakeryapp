<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>New User </title>
</head>


<body>

	<jsp:include page="main.jsp" />
	
	<h2>New User</h2>
	
	<font color="red">${error}</font>
	<form:form modelAttribute="user" method="POST" >
	

	
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
			
			<!--  Front end -->
			<tr>
			<th>Email</th>
			<td><form:input type="email" path="email" 
				pattern="^([a-zA-Z0-9_]+.*-*[a-zA-Z0-9_]*)@[a-z]+\\.([a-zA-Z]{2,5})$"   required="true" /></td>
			</tr>
				
			<!-- back end 	-->
			<!-- 
			<tr>
			<th>Email</th>
			<td><form:input type="text" path="email"  required="true" />
			<form:errors path="email" /></td>
			</tr>
			 -->
			
				
			<tr>
			<th>Password</th>
			<td><form:input type="password" path="password" id="password" onkeyup='check();' required="true"/></td>
			</tr>
			
			<tr>
			<th>Confirm Password</th>
			<td><form:input type="password" path="confirmPassword"  id="confirm_password" onkeyup='check();' required="true" />
			<font color="red">${passworderror}</font>
			<span id='message'></span></td> 	
			</tr>
			
			<tr>
			<th>Role</th>
			<td><form:input type="text" path="role" required="true"/></td>
			</tr>
			
			<tr>
			<td><input type="submit" Value="Submit"  onclick="return validate()" /></td>
			</tr>
			
		</tbody>
	</table>
	</form:form>

	<a href="${pageContext.request.contextPath}/users">Cancel</a>
	
	
	<!-- java scripts -->
<!--  
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
   -->
	
</body>

</html>