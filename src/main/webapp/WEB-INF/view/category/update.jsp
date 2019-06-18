<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<%@include file="../head.jsp" %>
<body>
<header>
    <h2>YourFounds</h2>
</header>

<section>
    <%@include file="../navigation.jsp" %>

    <article>
        <h1>Edit category</h1>
        <form:form action="updateprocess" modelAttribute="category" method="post">
            <form:hidden path="categoryId"/>
            <table>
                <tbody>
                    <tr>
                        <td><label>Name:</label></td>
                        <td><form:input path="name"/></td>
                    </tr>
                    <tr>
                        <td><label>Description:</label></td>
                        <td><form:input path="description"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Update"/>
        </form:form>
    </article>
</section>

<footer>
    <p></p>
</footer>

</body>
</html>