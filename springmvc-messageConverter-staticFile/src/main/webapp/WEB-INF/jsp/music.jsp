<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试XML数据</title>
    <%-- ${pageContext.request.contextPath}/js/jquery-1.12.4.min.js也可以 --%>
    <script type="text/javascript" src="../../js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="../../js/json2.js"></script>
    <script type="text/javascript">
        /* 页面加载完成后执行 */
        $(document).ready(function () {
            sendXml();
        });

        function sendXml() {
            var xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><music><id>1</id><name>花田错</name><singer>Leehom</singer></music>"
            $.ajax(
                {
                    url : "${pageContext.request.contextPath}/music/sendXml",
                    type : "post",
                    contentType : "application/xml",    //请求体内容编码格式
                    data : xmlData,                     //发送的数据
                    async : true                        //默认值，异步请求
                }
            );
        }
    </script>
</head>
<body>
</body>
</html>
