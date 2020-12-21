<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Search!
    </div>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        <form method="post" action="${pageContext.request.contextPath}/findProduct/">
            <label for="product">Product
                <input class="input-field" type="text" id="product" name="product">
            </label>
            <input type="submit" value="Search a product">
        </form>
    </div>
</div>

<div style="position:absolute;bottom:65%;right:0;" class="form-style-2">
    <div class="form-style-2-heading">
        Hello <c:out value="${user}" />!
    </div>

    <form method="get" action="${pageContext.request.contextPath}/exit/">
        <input type="submit" value="Exit">
    </form>
    <form method="get" action="${pageContext.request.contextPath}/allProducts/">
        <input type="submit" value="All Products">
    </form>
    <form method="get" action="${pageContext.request.contextPath}/myProducts/">
        <input type="submit" value="My Products">
    </form>
</div>


<div class="form-style-2">
    <div class="form-style-2-heading">
        Top 10!
    </div>
    <table>
        <tr>
            <th>Top</th>
            <th>Product</th>
            <th>Description</th>
            <th>Price</th>
            <th>Currency</th>
            <th>Seller</th>
        </tr>
        <c:forEach items="${products}" var="product">

            <tr>
                <td>${products.indexOf(product)+1}</td>
                <td>${product.product}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>$</td>
                <td>${product.seller.login}</td>

            </tr>
        </c:forEach>
    </table>
</div>
</html>
