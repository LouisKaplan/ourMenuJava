<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />

<body>

<div id="ourMenuTitle">
    <h2>Create a New Account</h2>
</div>
<div id="newAccount">
    <form action="newUser" method="post">
        <p>
            <label for="userName">Enter a username. This will not be shown to other users.</label>
            <input type="text" class="form-control" id="userName" name="userName"
                   placeholder="Username">
        </p>
        <p>
            <label for="displayName">Enter your name, or a name that will easily identify you.</label>
            <input type="text" class="form-control" id="displayName" name="displayName"
                   placeholder="Display Name">
        </p>
        <p>
            <label for = "password">Password (there is zero security here. Don't use a password that you use for anything important)</label>
            <input type="password" class="form-control" id="password" name="password"
                   placeholder="Password">
        </p>
        <p>
            <label for ="confirmPassword">Enter your password again</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword"
                   placeholder="Confirm your password">
        </p>

        <tr><th><button type="submit" name="submit" value="Enter"
                        class="btn btn-primary">Submit</button>
        </th>
        </tr>
    </form>

</div>

<c:import url="template/footer.jsp" />

</body>
</html>