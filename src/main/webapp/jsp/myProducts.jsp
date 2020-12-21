<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Please add new product!
    </div>

    <form method="post" action="${pageContext.request.contextPath}/saveProducts/">
        <label for="product">Product
            <input class="input-field" type="text" id="product" name="product">
        </label>
        <label for="description">Description
            <input class="input-field" type="text" id="description" name="description">
        </label>
        <input type="submit" value="Save">
    </form>
</div>

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
            <th>Description</th>
            <th>Price</th>
            <th>Currency</th>
            <th>Seller</th>
            <th>Change</th>
            <th>description</th>
            <th></th>
            <th>Change</th>
            <th>price</th>
        </tr>
        <c:forEach items="${products}" var="product">

            <tr>
                <td>${products.indexOf(product)+1}</td>
                <td>${product.product}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>$</td>
                <td>${product.seller.login}</td>

                <form method="post" action="${pageContext.request.contextPath}/changeDescription?id=${product.id}">
                    <td><label for="description">
                        <input class="input-field" type="text" id="description_1" name="description">
                    </label></td>
                    <td><input type="submit" value="Change"></td>
                </form>
                <form method="post" action="${pageContext.request.contextPath}/delete?id=${product.id}">
                <td> <input type="submit" value="Delete"></td>
                </form>
                <form method="post" action="${pageContext.request.contextPath}/changePrice?id=${product.id}">
                    <td><input type="submit" id="up" name="price" value="+" /></td>
                    <td><input type="submit" id="down" name="price" value="-" /></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</div>

</html>
