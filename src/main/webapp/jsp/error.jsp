<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Error: <c:out value="${error}" />!
    </div>
    <form method="get" action="${pageContext.request.contextPath}/">
        <input type="submit" value="Home">
    </form>
</div>
</html>
