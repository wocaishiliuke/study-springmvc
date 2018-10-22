<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h3>注册页面</h3><br>
<!-- 项目内不加项目名，使用/param/testList（绝对）testList（相对）都可以 -->
<form action="testList" method="post">
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
            <td><label>婚否：</label></td>
            <td><input type="radio" id="isMarry" name="isMarry"/></td>
        </tr>
        <tr></注册"></td>
        </tr>
        <tr>
            <td><label>兴趣：</label></td>
            <td><input type="checkbox" name="hobby" value="football" />足球</td>
            <td><input type="checkbox" name="hobby" value="basketball" />篮球</td>
            <td><input type="checkbox" name="hobby" value="volleyball" />排球</td>
        </tr>
        <tr><td><input type="submit" id="submit" value="提交"></td></tr>
    </table>
</form>
</body>
</html>
