<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录 </title>
</head>
<body>
    <h2>登录</h2>
    <form action="login" method="POST">
        <%-- 提示信息 --%>
        <p style="color: red">${requestScope.message}</p>
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登陆"></td>
            </tr>
        </table>
    </form>
</body>
</html>
