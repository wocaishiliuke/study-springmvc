<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>测试返回JSON数据</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/json2.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
           testResponseBody(); 
        });
        
        function testResponseBody() {
            $.post("${pageContext.request.contextPath}/book/getBooks", null, function (data) {
                $.each(data, function () {
                    var tr = $("<tr align=\"center\">");
                    $("<td/>").html(this.id).appendTo(tr);
                    $("<td/>").html(this.name).appendTo(tr);
                    $("<td/>").html(this.author).appendTo(tr);
                    $("#books").append(tr);
                })
            }, "json");
        }
    </script>
</head>
<body>
    <table id="books" border="1" style="border-collapse: collapse;">
        <tr align="center">
            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
        </tr>
    </table>
</body>
</html>
