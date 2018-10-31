<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息页</title>
</head>
<body>
    <h3>${requestScope.user.username}：头像下载</h3>
    <a href="download?avatarName=${requestScope.user.avatar.originalFilename}">
        ${requestScope.user.avatar.originalFilename}
    </a>
</body>
</html>
