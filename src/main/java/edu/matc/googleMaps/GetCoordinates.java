package edu.matc.googleMaps;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by student on 5/6/17.
 */
public class GetCoordinates {

    private String apiURL; //The URL for all calls
    private String apiParameters; //The modifier to do a box search
    private String restaurantName; //This is the maximum functional zoom
    private String city;
    private String state;
    private String apiUserKey; //The query string that we'll modify with your API key
    private String apiKey; //This is the key from your properties file

    private final Logger log = Logger.getLogger(this.getClass());

    public GetCoordinates(String apiKey, String apiURL, String apiParameters, String apiUserKey){
        this.apiKey = apiKey;
        this.apiURL = apiURL;
        this.apiParameters = apiParameters;
        this.apiUserKey = apiUserKey;
    }

    public OWList MakeCall(double miniLon, double miniLat, double maxiLon, double maxiLat) throws Exception{
        //bbox bounding box [lon-left,lat-bottom,lon-right,lat-top,zoom]

        //Load properties file and assign your key to the apiKey variable

        //Append the call string with our input data
        apiUserKey += apiKey;
        this.minLon = miniLon;
        this.minLat = miniLat;
        this.maxLon = maxiLon;
        this.maxLat = maxiLat;

        apiParameters += (minLon + "," +
                minLat + "," +
                maxLon + "," +
                maxLat + "," +
                boxZoom);

        log.info("Calling " + apiURL + apiParameters + apiUserKey);

        https://maps.googleapis.com/maps/api/geocode/json?components=locality:santa+cruz|country:ES&key=YOUR_API_KEY

        //Make the call
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(apiURL + apiParameters + apiUserKey);

        //This is the response
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        log.info("Response message is " + response);
        ObjectMapper mapper = new ObjectMapper();
        OWList list = mapper.readValue(response, OWList.class);



        //Return all the JSON data
        return list;
    }
}
