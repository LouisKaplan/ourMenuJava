<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />
<style>
    #map {
        height: 400px;
        width: 100%;
    }
</style>
<body>
<div id="container">
    <div id="mainContent">
        <div class="blogItem">

            <div id="groupOrderResult">
                <h1>Your ${groupOrderRestaurantName} Menu</h1>
                    <c:forEach var="user" items="${selectedUsers}">
                       <h3>${user}</h3>
                         <c:forEach var="entry" items="${userMap}">
                             <c:choose>
                                 <c:when test="${entry.key == user}">
                                     <c:forEach var="value" items="${entry.value}">
                                        <h4>${value}</h4>

                                     </c:forEach>
                                 </c:when>
                                 <c:otherwise>
                                 </c:otherwise>
                             </c:choose>

                         </c:forEach>
                        </br>
                    </c:forEach>
                </select>
            </div>

            <div id="map">
            <script>
                function initMap() {
                    var uluru = {lat: -25.363, lng: 131.044};
                    var map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 4,
                        center: uluru
                    });
                    var marker = new google.maps.Marker({
                        position: uluru,
                        map: map
                    });
                }
            </script>
            <script async defer
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDz1O1acC_sddBXfr-eG08np8GrpG3ufeU&callback=initMap">
            </script>
            </div>

        </div>
    </div>
    <div class="clearfloat"></div>
    <c:import url="template/footer.jsp" />
</div>

<c:import url="template/links.jsp" />
</body>
</html>
