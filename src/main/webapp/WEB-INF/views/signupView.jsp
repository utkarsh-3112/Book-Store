<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<br>
<div style="text-align: -webkit-center">
    <h3>Login Page</h3>
    <p style="color: red;">${errorString}</p>
    <form method="POST" action="./sign_up">
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName"/></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName"/></td>
            </tr>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="username"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="password" value="${user.password}"/></td>
            </tr>
            <tr>
                <td>confirm password</td>
                <td><input type="text" name="confirmPassword"/></td>
            </tr>
            <tr>
                <td>Mobile No.</td>
                <td><input type="text" name="mobileNo"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <select name="gender">
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Other</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                    <a href="./login">Login</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
