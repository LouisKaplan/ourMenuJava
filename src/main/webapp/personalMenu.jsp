<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />

<body>
<%= request.getUserPrincipal().getName() %>
A
${user}
B


<div id="container">

    <div id="mainContent">

        <div class="blogItem">

            <h1>myMenu</h1>


        </div><!-- end #blogItem -->

    </div><!-- end #mainContent -->

    <div class="clearfloat"></div>

    <c:import url="template/footer.jsp" />

</div><!-- end #container -->

<c:import url="template/links.jsp" />

</body>
</html>
