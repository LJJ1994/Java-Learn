<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/10
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../static/css/index.css">
</head>
<body>
    <p2>hello world!</p2>

<%--    <form action="/account/saveAccount" method="post">--%>
<%--        账户名称： <input type="text" name="name" ><br/>--%>
<%--        账户金额： <input type="text" name="money" ><br/>--%>
<%--        账户省份： <input type="text" name="address.provinceName" ><br/>--%>
<%--        账户城市： <input type="text" name="address.cityName" ><br/>--%>
<%--        <input type="submit" value="保存">--%>
<%--    </form>--%>

    <form action="/account/updateAccount" method="post">
        用户名称： <input type="text" name="username" ><br/>
        用户密码： <input type="password" name="password" ><br/>
        用户年龄： <input type="text" name="age" ><br/>
        账户1名称: <input type="text" name="accounts[0].name">
        账户1金额：<input type="text" name="accounts[0].money">
        账户 2 名称： <input type="text" name="accounts[1].name" ><br/>
        账户 2 金额： <input type="text" name="accounts[1].money" ><br/>

        账户3名称：<input type="text" name="accountMap['one'].name">
        账户3金额: <input type="text" name="accountMap['two'].money">
        账户 4 名称： <input type="text" name="accountMap['two'].name" ><br/>
        账户 4 金额： <input type="text" name="accountMap['two'].money" ><br/>
        <input type="submit" value="保存">
    </form>

    <h2>删除账户</h2>
    <a href="/account/deleteAccount?date=2020-05-10">根据日期删除账户</a>
</body>
</html>
