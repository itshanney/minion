<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav nav-sidebar">
    <c:forEach var="navbarItem" items="${nimdaNavbarItems}">
    <c:choose>
        <c:when test="${navbarItem eq currentNavbarItem}">
        <li class="active"><a href="${navbarItem.itemLink}">${navbarItem.itemName}</a></li>
        </c:when>
        <c:otherwise>
        <li><a href="${navbarItem.itemLink}">${navbarItem.itemName}</a></li>
        </c:otherwise>
    </c:choose>
    </c:forEach>
</ul>