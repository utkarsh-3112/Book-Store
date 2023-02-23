<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix="c" uri="jakarta.tags.core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Home</title>
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <div>
        <br>
        <h2>Get Your Favorite Books</h2>
        <p>You can buy/ rent books</p>
    </div>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Edition</th>
                <th>Author</th>
                <th>Publication</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td><c:out value="${book.bookId}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.edition}"/></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.publication}"/></td>
                    <td><c:out value="${book.price}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${book.bookId}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${book.bookId}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
