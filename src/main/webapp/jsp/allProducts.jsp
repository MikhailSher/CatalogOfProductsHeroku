<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<div class="form-style-2">
    <div class="form-style-2-heading">
        <form method="get" action="${pageContext.request.contextPath}/">
            <input type="submit" value="Home">
        </form>
    </div>
</div>


<div class="form-style-2">
    <div class="form-style-2-heading">
        All products!
    </div>
    <table>
        <tr>
            <th>Top</th>
            <th>Product</th>
            <th>Price</th>
            <th>Currency</th>
            <th>Seller</th>
        </tr>
        <c:forEach items="${products}" var="product">

            <tr>
                <td>${products.indexOf(product)+1}</td>
                <td>${product.product}</td>
                <td>${product.price}</td>
                <td>$</td>
                <td>${product.seller.login}</td>

            </tr>
        </c:forEach>
    </table>
</div>

</html>
