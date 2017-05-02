<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />

<body>
<div id="container">
    <div id="mainContent">
        <div class="blogItem">
            <h1>GroupOrderResult</h1>

            <div id="groupOrderResult">
                <h1>Your Menus</h1>
                    <c:forEach var="user" items="${selectedUsers}">
                        ${user}
                         <c:forEach var="entry" items="${userMap}">

                             <c:choose>
                                 <c:when test="${entry.key == user}">
                                     ${entry.value}
                                 </c:when>
                                 <c:otherwise>
                                 </c:otherwise>
                             </c:choose>

                         </c:forEach>
                        </br></br>
                    </c:forEach>
                </select>
            </div>





        </div>
    </div>
    <div class="clearfloat"></div>
    <c:import url="template/footer.jsp" />
</div>

<c:import url="template/links.jsp" />
</body>
</html>
