<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="template/head.jsp" />
<style>
    #map {
        height: 400px;
        width: 25%;
    }
</style>
<body>
<div id="container">
    <div id="mainContent">
        <div class="blogItem">
            <h1>Restaurant Selection Countdown: </h1>

            <div id="RestaurantSelectionResult">
                    <c:forEach var="entry" items="${sortedMap}">
                        ${entry.key} ${entry.value} <br>
                    </c:forEach>
                    </br></br>
            </div>
        </div>
    </div>

    <div id="map">
        <script>
            function initMap() {
                var uluru = {lat: ${mapLat}, lng: ${mapLon}};
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 16,
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
    <div class="clearfloat"></div>
    <c:import url="template/footer.jsp" />
</div>

<c:import url="template/links.jsp" />
</body>
</html>