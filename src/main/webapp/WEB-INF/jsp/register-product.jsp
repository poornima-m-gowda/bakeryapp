<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>New Product </title>
</head>


<body>

	<jsp:include page="main.jsp" />
	
	<h2>New Product</h2>
	
	<font color="red">${error}</font>
	<form:form modelAttribute="product" method="POST" >
	

	
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
			<td><input type="submit" Value="Submit"/></td>
			</tr>
			
		</tbody>
	</table>
	</form:form>

	<a href="${pageContext.request.contextPath}/productDetails/0">Cancel</a>
	
</body>

</html>