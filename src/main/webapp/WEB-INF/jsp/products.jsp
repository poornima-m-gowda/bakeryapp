<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>

<head>
	<title>Product List</title>
	
</head>

<body>

	<jsp:include page="main.jsp" /> 

	<h3>Product List</h3>
	
	<security:authorize access="hasRole('admin')">
	<input type="button" value="New Product"
			onclick="window.location.href='/products/register'">
	</security:authorize>

	<p>
	<table>
	<tbody>
		<tr>
			<th>Product Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<security:authorize access="hasRole('admin')">
			<th>Action</th>
			</security:authorize>
		</tr>
		
		<!-- loop for displaying each user -->
		<c:forEach var="tempProduct" items="${product}">
		
		<!-- link "update" user using user id -->
		<c:url var="updateProduct" value="/products/update" >
			<c:param name="productId" value="${tempProduct.id }"></c:param>
		</c:url>		
		
		<!-- link "delete" user using user id -->
		<c:url var="deleteProduct" value="/products/delete" >
			<c:param name="productId" value="${tempProduct.id }"></c:param>
		</c:url>
		
		<tr>
			<td>${tempProduct.productName}</td>
			<td>${tempProduct.price}</td>
			<td>${tempProduct.quantity}</td>
			
			<security:authorize access="hasRole('admin')">
			<td><a href="${updateProduct}">Edit</a>
				<a href="${deleteProduct}"
				onclick="if(!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a></td>
			</security:authorize>
			
		</tr>
		
		</c:forEach>	
	</tbody>
	</table>

	<c:if test="${page >0}">
	<a href="/productDetails/${page-1}" >Previous</a>
	</c:if>
	<a href="/productDetails/${page+1}">Next</a>
	
	
</body>

</html>