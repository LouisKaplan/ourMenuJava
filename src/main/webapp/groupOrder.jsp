<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />

<body>
<div id="groupOrderBody">

    <div class="blogItem">
        <h1>Group Order</h1>
    </div>

    <div id="selectDinersDiv">
        <h1>Select Diners:</h1>
        <ol class="selectable" id="selectDiners">
            <li class="ui-widget-content">Item 1</li>
            <li class="ui-widget-content">Item 2</li>
            <li class="ui-widget-content">Item 3</li>
            <li class="ui-widget-content">Item 4</li>
            <li class="ui-widget-content">Item 5</li>
            <li class="ui-widget-content">Item 6</li>
            <li class="ui-widget-content">Item 7</li>
        </ol>
    </div>

    <div id="selectRestaurantDiv">
        <h1>Select Restaurant</h1>
        <ol class="selectable" id="selectRestaurant">
            <li class="ui-widget-content">Item 1</li>
            <li class="ui-widget-content">Item 2</li>
            <li class="ui-widget-content">Item 3</li>
            <li class="ui-widget-content">Item 4</li>
            <li class="ui-widget-content">Item 5</li>
            <li class="ui-widget-content">Item 6</li>
            <li class="ui-widget-content">Item 7</li>
        </ol>
        <br/>
    </div>

</div>








<div id="pageLinks">
    <p><a href="homeDisplay">Home</a></p>
    <p><a href="personalMenuDisplay"> Update Your Personal Menu</a></p>
    <p><a href="pizzaDenominatorDisplay">Pizza Denominator</a></p>
    <p><a href="restaurantSelectorDisplay">Group Restaurant Selector</a></p>
    <p><a href="newRestaurantDisplay">Enter a New Restaurant</a></p>
    <p><a href="updateRestaurantDisplay">Update a Restaurant (admin only)</a></p>
</div>

<c:import url="template/footer.jsp" />
</body>

</html>
