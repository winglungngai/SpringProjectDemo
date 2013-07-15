<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC Demo</title>
</head>
<body>
<h1>Hello Guest! This is Spring MVC Demo</h1>
This site is built for the purpose of learning Spring MVC, which is extremely difficult to configure.
Anyway, the developer intends to integrate the knowledge from semantic web, information retrieval, and web data management into this site.
<br>
<br>
The current development can be found here below:
<br>
<br>
<c:if test="${not empty worklogs}">
    <table>
        <c:forEach var="w" items="${worklogs}">
            <tr>
                <td>${w.author}</td>
                <td>${w.content}</td>
                <td>${w.date}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<br>
Add new work:

<form action="about" method="post">
  Work Description: <input type="text" name="content">
  <input type="submit" value="Submit">
</form>

</body>
</html>
