<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />

<body>

<div id="pageTitle">
    <h2>ourMenu</h2>
</div>
<!-- Create Login-->

<div id="login">
<FORM ACTION="j_security_check" METHOD="POST">
    <TABLE>
        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
    </TABLE>
</FORM>
</div>

<div id="newUser">
    <p>First time here?</p>
    <p><a href="newUserDisplay">Create an account now</a></p>
    <br/>
</div>

<!-- Page Links-->
<div id="pageLinks">
<p><a href="personalMenuDisplay"> Update Your Personal Menu</a></p>
<p><a href="groupOrderDisplay">Create A Group Order</a></p>
<p><a href="pizzaDenominatorDisplay">Pizza Denominator</a></p>
<p><a href="restaurantSelectorDisplay">Group Restaurant Selector</a></p>
<p><a href="newRestaurantDisplay">Enter a New Restaurant</a></p>
<p><a href="updateRestaurantDisplay">Update a Restaurant (admin only)</a></p>
</div>

<c:import url="template/footer.jsp" />

</body>
</html>