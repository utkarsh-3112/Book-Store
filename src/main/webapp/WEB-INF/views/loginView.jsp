<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<br>
<div style="text-align: -webkit-center">
    <h3>Login Page</h3>
    <p style="color: red;">${errorString}</p>
    <form method="POST" action="./login">
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="username" value= "${user.userName}" /> </td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" value= "${user.password}" /> </td>
            </tr>
            <tr>
                <td>Remember me</td>
                <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
            </tr>
            <tr>
                <td colspan ="2">
                    <input type="submit" value= "Submit" />
                    <a href="./sign_up">Sign UP</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
