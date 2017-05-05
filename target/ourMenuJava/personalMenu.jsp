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
            </br>
            <label for="restaurantRating">Rating for this restaurant (10 is best):</label>

<select name="restaurantRating" id="restaurantRating">
    <option value="none">none</option>
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>
    <option value="10">10</option>
</select>

            <input type="hidden" name="restaurantName" value ="${entry.key}">
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
