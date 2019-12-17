<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Edit Order </title>
</head>


<body>
	
	<jsp:include page="main.jsp" />

	<h2>Edit Order</h2>
	
	
	<form:form modelAttribute="order" method="POST" >
	
	<!-- associate data with userId -->
	<form:hidden path="id"/>
	
	<table>
		<tbody>
		
			<tr>
			<th>Customer Name</th>
			<td><form:input type="text" path="customerName" required="true"/></td>
			</tr>
			
			<tr>
			<th>Phone Number</th>
			<td><form:input type="text" path="phoneNumber" required="true"/></td>
			</tr>
			
			<tr>
			<th>Products</th>
			<td>
            <form:select path="productsOrdered" name="products" id="123">
                        <c:forEach items="${products}" var="productTemp">
                               <form:option value="${productTemp.productName}">${productTemp.productName}</form:option>
                        </c:forEach>
            </form:select>
			
			</td>
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
			<th>Total</th>
			<td><form:input type="text" path="total" required="true"/></td>
			</tr>
			
			<tr>
			<th>Due Date</th>
			<td><form:input type="text" path="dueDate" required="true"/></td>
			</tr>
			
			<tr>
			<th>Status</th>
			<td><form:input type="text" path="status" required="true"/></td>
			</tr>
			
			<tr>
			<td><input type="submit" Value="Update"/></td>
			</tr>
			
		</tbody>
	</table>
	</form:form>

	<a href="${pageContext.request.contextPath}/orders">Cancel</a>
	
	
</body>

</html>