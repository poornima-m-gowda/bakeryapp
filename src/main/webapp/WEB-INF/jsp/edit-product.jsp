<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Edit Product </title>
</head>


<body>

	<jsp:include page="main.jsp" />
	
	<h2>Edit Product</h2>
	
	<form:form modelAttribute="product" method="POST" >
	
	<!-- associate data with userId -->
	<form:hidden path="id"/>
	
	<table>
		<tbody>
			<tr>
			<th>Product Name</th>
			<td><form:input type="text" path="productName" required="true"/></td>
			</tr>	
						
			<tr>
			<th>Price</th>
			<td><form:input type="text" path="price" required="true"/></td>
			</tr>
			
			<tr>
			<th>Quantity</th>
			<td><form:input type="text" path="quantity" required="true"/></td>
			</tr>			
			
			<tr>
			<td><input type="submit" Value="Update"/></td>
			</tr>
			
		</tbody>
	</table>
	</form:form>

	<a href="${pageContext.request.contextPath}/productDetails/0">Cancel</a>
	
	
</body>

</html>