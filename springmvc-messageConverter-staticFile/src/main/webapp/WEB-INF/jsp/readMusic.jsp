<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试返回XML数据</title>
    <%-- ${pageContext.request.contextPath}/js/jquery-1.12.4.min.js也可以 --%>
    <script type="text/javascript" src="../../js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="../../js/json2.js"></script>
    <script type="text/javascript">
        /* 页面加载完成后执行 */
        $(document).ready(function () {
            readXml();
        });

        function readXml() {
            $.ajax(
                {
                    url : "${pageContext.request.contextPath}/music/readXml",
                    type : "GET",
                    async : true,                       //默认值，异步请求
                    success : function (xmlData) {
                        var id = $("id", xmlData).text();
                        var name = $("name", xmlData).text();
                        var singer = $("singer", xmlData).text();
                        var tr = $("<tr align='center'/>");
                        $("<td/>").html(id).appendTo(tr);
                        $("<td/>").html(name).appendTo(tr);
                        $("<td/>").html(singer).appendTo(tr);
                        $("#musics").append(tr);
                    },
                    error : function () {
                        alert("接收数据失败");
                    }
                }
            );
        }
    </script>
</head>
<body>
    <table id="musics" border="1" style="border-collapse: collapse;">
        <tr align="center">
            <th>编号</th>
            <th>歌名</th>
            <th>歌手</th>
        </tr>
    </table>
</body>
</html>
