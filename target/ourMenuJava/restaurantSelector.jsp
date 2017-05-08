<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" class="init">

</script>
<c:import url="template/head.jsp" />

<body>
<div id="restaurantSelectorBody">

    <div class="blogItem">
        <h1>Find Your Group's Favorite Restaurants</h1>
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

    <form action="restaurantSelectorProcess" method="get">

        <div id="selectDinersDiv">
            <h1>For Which People Are We Finding A Restaurant?</h1>
            <select name="selectDiners" id='selectDiners' size="6" multiple='multiple'>
                <c:forEach var="user" items="${allUserList}">
                    <option value='${user}'>${user}</option>
                </c:forEach>
            </select>
        </div>


        <input type="text" id="selectCity" name="selectCity" placeholder="Enter City For Search">
        <input type="text" id="selectState" name="selectState" placeholder="Enter State For Search">


        <button type="submit" name="submit" value="Enter"
                class="btn btn-primary">Find Us A Restaurant!</button>
    </form>
</div>

${restaurantSelectorMessage}
</br>
${restaurantList}

<br/>
<br/>
<br/>
<c:import url="template/links.jsp" />

<c:import url="template/footer.jsp" />
</body>

</html>