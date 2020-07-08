<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Quantity</th>
			<th>Price</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${products}">
		<tr>
			<td><c:out value="${product.name }"/></td>
			<th><c:out value="${product.quantity }"/></th>
			<th><c:out value="${product.price }"/></th>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>