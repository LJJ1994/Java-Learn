<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/10
  Time: 4:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file upload</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    文件名: <input type="text" name="picname">
    文件: <input type="file" name="uploadFile">
    <input type="submit" value="提交">
</form>
</body>
</html>
