<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试JSON数据</title>
    <%-- ${pageContext.request.contextPath}/js/jquery-1.12.4.min.js也可以 --%>
    <script type="text/javascript" src="../../js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="../../js/json2.js"></script>
    <script type="text/javascript">
        /* 页面加载完成后执行 */
        $(document).ready(function () {
            testRequestBody();
        });

        function testRequestBody() {
            $.ajax(
                {
                    url : "${pageContext.request.contextPath}/book/testRequestBody",
                    type : "post",
                    dataType : "json",  //预期服务器返回的数据类型
                    contentType : "application/json",  //请求体内容编码格式
                    data : JSON.stringify({id : 1, name : "西游记"}),  //发送的数据
                    async : true,   //默认值，异步请求
                    success : function (data) {
                        console.log(data);
                        $("#id").html(data.id);
                        $("#name").html(data.name);
                        $("#author").html(data.author);
                    },
                    error : function () {
                        alert("发送失败");
                    }
                }
            );
        }
    </script>
</head>
<body>
    编号：<span id="id"></span><br>
    书名：<span id="name"></span><br>
    作者：<span id="author"></span><br>
</body>
</html>
