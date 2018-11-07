<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传(用于自定义uploadServlet的测试)</title>
</head>
<body>
    <h2>文件上传</h2>
    <%-- 这里要用绝对路径，相对路径会变成file/uploadServlet，被DispatcherServlet拦截 --%>
    <form action="${pageContext.request.contextPath}/uploadServlet" method="POST" enctype="multipart/form-data">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>头像：</td>
                <td><input type="file" name="avatar"></td>
            </tr>
            <tr>
                <td><input type="submit" value="上传"></td>
            </tr>
        </table>
    </form>
</body>
</html>
