<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
	<title>Orders List</title>
</head>

  

<body>
	
	<jsp:include page="main.jsp" />

	<h3>Orders List</h3>
	
	<security:authorize access="hasRole('barista')">
	<input type="button" value="New Order"
			onclick="window.location.href='/orders/register'">
	</security:authorize>


	<table>
	<tbody>
		<tr>
			<th>Order Number</th>
			<th>Customer Name</th>
			<th>Phone Number</th>
			<th>Products</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Total</th>
			<th>Due Date</th>
			<th>Status</th>
		</tr>
		
		<!-- loop for displaying each user -->
		<c:forEach var="tempOrder" items="${orders}">
		
		<!-- link "update" user using user id -->
		<c:url var="updateOrder" value="/orders/update" >
			<c:param name="orderId" value="${tempOrder.id }"></c:param>
		</c:url>		
		
		<!-- link "delete" user using user id -->
		<c:url var="deleteOrder" value="/orders/delete" >
			<c:param name="orderId" value="${tempOrder.id }"></c:param>
		</c:url>
		
		<tr>
			<td>${tempOrder.id}</td>
			<td>${tempOrder.customerName}</td>
			<td>${tempOrder.phoneNumber}</td>
			<td>${tempOrder.productsOrdered}</td>
			<td>${tempOrder.price}</td>
			<td>${tempOrder.quantity}</td>
			<td>${tempOrder.total}</td>
			<td>${tempOrder.dueDate}</td>
			<td>${tempOrder.status}</td>
			
			<security:authorize access="hasRole('barista')">
			<td><a href="${updateOrder}">Edit</a>
				<a href="${deleteOrder}"
				onclick="if(!(confirm('Are you sure you want to delete this order?'))) return false">Delete</a></td>
			</security:authorize>
			
		</tr>
		
		</c:forEach>	
	</tbody>
	</table>
	
	
</body>

</html>