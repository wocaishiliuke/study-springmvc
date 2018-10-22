<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <h3>注册页面</h3><br>
    <!-- 项目内不加项目名，这里使用/param/register（绝对）或register（相对）都可以 -->
    <form action="register" method="post">
        <table>
            <tr>
                <td><label>登录名：</label></td>
                <td><input type="text" id="username" name="username"></td>
            </tr>
            <tr>
                <td><label>密码：</label></td>
                <td><input type="password" id="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" id="submit" value="注册"></td>
            </tr>
        </table>

    </form>
</body>
</html>
