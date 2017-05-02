<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />

<body>

<h3>${updateMenuMessage}</h3>
<style>
    #accordion {
        width: 30%;
    }
</style>
<script>
    $( function() {
        $( "#accordion" ).accordion({heightStyle: "content", collapsible: true});
    } );
</script>
<div id="container">

    <div id="mainContent">

        <div class="blogItem">

            <h1>Update myMenu</h1>

        </div>
<div id="accordion">
    <c:forEach var="entry" items="${restMenuMap}">
        <h3>${entry.key} </h3>
        <div>
        <form action="personalMenuProcess" method="get">

            <c:forEach var="item" items="${entry.value}">
                <input type="checkbox" name="menuItem" value="${item}"> ${item}<br>
            </c:forEach>
            <input type="submit" value="Submit">
        </form>
        </div>
    </c:forEach>
</div>
    </div>

    <div class="clearfloat"></div>

    <c:import url="template/footer.jsp" />

</div>

<c:import url="template/links.jsp" />

</body>
</html>
