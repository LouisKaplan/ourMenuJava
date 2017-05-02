<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />

<body>
<div id="container">
    <div id="mainContent">
        <div class="blogItem">
            <h1>${newRestaurantSuccessMessage}</h1>
            <h1>${newMenuItemsSuccessMessage}</h1>

            <h1>New Restaurant</h1>
            <form action="newRestaurant" method="get">
                <table id="newRestaurantTable" class="display" cellspacing="0" cellpadding="0" width="30%">
                    <tr>
                        <td>
                            <label for="newRestaurantName">New Restaurant Name:</label>
                            <input type="text" class="newRestaurant" id="newRestaurantName"
                            name="newRestaurantName"
                            placeholder="New Restaurant Name">
                        </td>
                        <td>
                            <label for="newRestaurantCategory">Restaurant Category:</label>
                            <input type="text" class="newRestaurant" id="newRestaurantCategory"
                            name="newRestaurantCategory"
                            placeholder="New Restaurant Category">
                        </td>
                    </tr>
                </table>
                </br>
                <table id="newMenuItemsTable" class="display" cellspacing="0" cellpadding="0" width="30%">
                    <tr>
                        <td>
                            <label for="newMenuItem1">Restaurant Menu:</label>
                            <input type="text" class="newMenuItem" id="newMenuItem1"
                                   name="newMenuItem1"
                                   placeholder="New Menu Item">
                        </td>
                        <td>
                            <label for="newItemCategory1">Menu Item Category:</label>
                        <input type="text" class="newItemCategory" id="newItemCategory1"
                               name="newItemCategory1"
                               placeholder="Item Category">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem2"
                                   name="newMenuItem2"
                                   placeholder="New Menu Item">
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory2"
                                   name="newItemCategory2"
                                   placeholder="Item Category">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem3"
                                   name="newMenuItem3"
                                   placeholder="New Menu Item">
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory3"
                                   name="newItemCategory3"
                                   placeholder="Item Category">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem4"
                                   name="newMenuItem4"
                                   placeholder="New Menu Item">
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory4"
                                   name="newItemCategory4"
                                   placeholder="Item Category">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem5"
                                   name="newMenuItem5"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory5"
                                   name="newItemCategory5"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem6"
                                   name="newMenuItem6"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory6"
                                   name="newItemCategory6"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem7"
                                   name="newMenuItem7"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory7"
                                   name="newItemCategory7"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem8"
                                   name="newMenuItem8"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory8"
                                   name="newItemCategory8"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem9"
                                   name="newMenuItem9"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory9"
                                   name="newItemCategory9"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem10"
                                   name="newMenuItem10"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory10"
                                   name="newItemCategory10"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem11"
                                   name="newMenuItem11"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory11"
                                   name="newItemCategory11"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem12"
                                   name="newMenuItem12"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory12"
                                   name="newItemCategory12"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem13"
                                   name="newMenuItem13"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory13"
                                   name="newItemCategory13"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem14"
                                   name="newMenuItem14"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory14"
                                   name="newItemCategory14"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem15"
                                   name="newMenuItem15"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory15"
                                   name="newItemCategory15"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem16"
                                   name="newMenuItem16"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory16"
                                   name="newItemCategory16"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem17"
                                   name="newMenuItem17"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory17"
                                   name="newItemCategory17"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem18"
                                   name="newMenuItem18"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory18"
                                   name="newItemCategory18"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem19"
                                   name="newMenuItem19"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory19"
                                   name="newItemCategory19"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem20"
                                   name="newMenuItem20"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory20"
                                   name="newItemCategory20"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem21"
                                   name="newMenuItem21"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory21"
                                   name="newItemCategory1"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem22"
                                   name="newMenuItem22"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory22"
                                   name="newItemCategory22"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem23"
                                   name="newMenuItem23"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory23"
                                   name="newItemCategory23"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="text" class="newMenuItem" id="newMenuItem24"
                                   name="newMenuItem24"
                                   placeholder="New Menu Item" >
                        </td>
                        <td>
                            <input type="text" class="newItemCategory" id="newItemCategory24"
                                   name="newItemCategory24"
                                   placeholder="Item Category" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit" name="submit" value="Enter"
                            class="btn btn-primary">Add Restaurant</button>
                        </td>
                    </tr>
                </table>


            </form>


        </div>
    </div>
    <div class="clearfloat"></div>

</div>
</br></br></br></br>
<c:import url="template/links.jsp" />
<c:import url="template/footer.jsp" />

</body>
</html>
