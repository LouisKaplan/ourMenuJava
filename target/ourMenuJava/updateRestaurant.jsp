<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />

<body>

<h3>${updateRestaurantMessage}</h3>
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

            <h1>Update Restaurants</h1>

        </div>
        <div id="accordion">
            <c:forEach var="entry" items="${restMenuMap}">
                <h3>${entry.key} </h3>
                <div>
                    <h2>Select Menu Items To Remove:</h2>
                    <form action="updateRestaurantProcess" method="get">

                        <c:forEach var="item" items="${entry.value}">
                            <input type="checkbox" name="deleteMenuItem" value="${item}"> ${item}<br>
                        </c:forEach>

                        <h2>Enter Any New Menu Items:</h2>
                        <table id="newMenuItemsTable" class="display" cellspacing="0" cellpadding="0" width="30%">
                            <tr>
                                <td>
                                    <label for="newMenuItem1">Restaurant Menu:</label>
                                    <input type="text" class="newMenuItem" id="newMenuItem1"
                                           name="newMenuItem"
                                           placeholder="New Menu Item">
                                </td>
                                <td>
                                    <label for="newItemCategory1">Menu Item Category:</label>
                                    <input type="text" class="newItemCategory" id="newItemCategory1"
                                           name="newItemCategory"
                                           placeholder="Item Category">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="newMenuItem" id="newMenuItem2"
                                           name="newMenuItem"
                                           placeholder="New Menu Item">
                                </td>
                                <td>
                                    <input type="text" class="newItemCategory" id="newItemCategory2"
                                           name="newItemCategory"
                                           placeholder="Item Category">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="newMenuItem" id="newMenuItem3"
                                           name="newMenuItem"
                                           placeholder="New Menu Item">
                                </td>
                                <td>
                                    <input type="text" class="newItemCategory" id="newItemCategory3"
                                           name="newItemCategory"
                                           placeholder="Item Category">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="newMenuItem" id="newMenuItem4"
                                           name="newMenuItem"
                                           placeholder="New Menu Item">
                                </td>
                                <td>
                                    <input type="text" class="newItemCategory" id="newItemCategory4"
                                           name="newItemCategory"
                                           placeholder="Item Category">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="newMenuItem" id="newMenuItem5"
                                           name="newMenuItem"
                                           placeholder="New Menu Item" >
                                </td>
                                <td>
                                    <input type="text" class="newItemCategory" id="newItemCategory5"
                                           name="newItemCategory"
                                           placeholder="Item Category" >
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="newMenuItem" id="newMenuItem6"
                                           name="newMenuItem"
                                           placeholder="New Menu Item" >
                                </td>
                                <td>
                                    <input type="text" class="newItemCategory" id="newItemCategory6"
                                           name="newItemCategory"
                                           placeholder="Item Category" >
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="newMenuItem" id="newMenuItem7"
                                           name="newMenuItem"
                                           placeholder="New Menu Item" >
                                </td>
                                <td>
                                    <input type="text" class="newItemCategory" id="newItemCategory7"
                                           name="newItemCategory"
                                           placeholder="Item Category" >
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="newMenuItem" id="newMenuItem8"
                                           name="newMenuItem"
                                           placeholder="New Menu Item" >
                                </td>
                                <td>
                                    <input type="text" class="newItemCategory" id="newItemCategory8"
                                           name="newItemCategory"
                                           placeholder="Item Category" >
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="newMenuItem" id="newMenuItem9"
                                           name="newMenuItem"
                                           placeholder="New Menu Item" >
                                </td>
                                <td>
                                    <input type="text" class="newItemCategory" id="newItemCategory9"
                                           name="newItemCategory"
                                           placeholder="Item Category" >
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="newMenuItem" id="newMenuItem10"
                                           name="newMenuItem"
                                           placeholder="New Menu Item" >
                                </td>
                                <td>
                                    <input type="text" class="newItemCategory" id="newItemCategory10"
                                           name="newItemCategory"
                                           placeholder="Item Category" >
                                </td>
                            </tr>
                        </table>

                        <input type="hidden" name="restaurantName" value = ${entry.key}>
                        <input type="submit" value="Submit">
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>
    <br><br>
    <div class="clearfloat"></div>

    <c:import url="template/footer.jsp" />

</div>

<c:import url="template/links.jsp" />

</body>
</html>
