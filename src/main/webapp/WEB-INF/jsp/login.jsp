
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <form action="login" method="post">
        ${map.msg}<br>
        账号：<input type="text" name="username"/><br/>
        密码：<input type="password" name="password"/><br/>
        <input type="submit">
    </form>
</body>
</html>
