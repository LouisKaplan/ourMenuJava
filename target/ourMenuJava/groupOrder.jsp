<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" class="init">

</script>
<c:import url="template/head.jsp" />

<body>
<div id="groupOrderBody">

    <div class="blogItem">
        <h1>Group Order</h1>
        <h3>${user.displayName}</h3>
    </div>

    <style>
        .selectable .ui-selecting { background: #FECA40; }
        .selectable .ui-selected { background: #F39814; color: white; }
        .selectable { list-style-type: none; margin: 0; padding: 0; width: 16%; }
        .selectable li { margin: 3px; padding: 0.4em; font-size: 1.4em; height: 2em; }
    </style>

    <script>
        $( function() {
            $( "input" ).checkboxradio();
            $( "fieldset" ).controlgroup();
        } );
    </script>

<form action="groupOrderProcess" method="get">

    <div id="selectDinersDiv">
        <h1>Select Diners:</h1>
        <select name="selectDiners" id='selectDiners' size="6" multiple='multiple'>
            <c:forEach var="user" items="${allUserList}">
                <option value='${user}'>${user}</option>
            </c:forEach>
        </select>
    </div>

    <div id="selectRestaurantDiv">
        <h1>Select Restaurant:</h1>
        <select name="restaurantNameSelect" id='restaurantNameSelect' size="6">
            <c:forEach var="restaurant" items="${allRestaurantList}">
                <option value='${restaurant}'>${restaurant}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit" name="submit" value="Enter"
    class="btn btn-primary">Find Orders</button>
</form>
</div>
<br/>
<br/>
<br/>
<c:import url="template/links.jsp" />

<c:import url="template/footer.jsp" />
</body>

</html>
<%--<ol class="selectable" id="selectDiners">--%>
<%--<c:forEach var="user" items="${allUserList}">--%>
<%--<li class="ui-widget-content">${user}</li>--%>
<%--</c:forEach>--%>
<%--</ol>--%>