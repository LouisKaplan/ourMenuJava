package com.google;

import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.Assert.*;


public class MapsAPITest {

    @Test
    public void testGoogleApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://maps.googleapis.com/maps/api/geocode/json?address=Jimmy+Johns+Madison+WI&key=AIzaSyDz1O1acC_sddBXfr-eG08np8GrpG3ufeU");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("???", response);
    }
}