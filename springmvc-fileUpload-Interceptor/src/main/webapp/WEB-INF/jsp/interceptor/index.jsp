<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <h3>欢迎${sessionScope.user.username}访问</h3>
    <br>
    <table border="1">
        <tr>
            <th>封面</th><th>书名</th><th>作者</th><th>价格</th>
        </tr>
        <c:forEach items="${requestScope.books}" var="book">
            <tr>
                <td><img src="image/${book.image}" height="60"></td>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
