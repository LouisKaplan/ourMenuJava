package edu.matc.googleMaps;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import edu.matc.googleMaps.Results;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by student on 5/6/17.
 */
public class GetCoordinates {

    private Properties ourMenuProperties = new Properties();

    private String apiURL; //The URL for all calls
    private String apiParameters; //The modifier to do a box search
    private String restaurantName; //This is the maximum functional zoom
    private String cityName;
    private String stateName;
    private String apiUserKey; //The query string that we'll modify with your API key
    private String apiKey; //This is the key from your properties file

    private final Logger log = Logger.getLogger(this.getClass());

    public GetCoordinates(){
//        String apiKey, String apiURL, String apiParameters, String apiUserKey
//        this.apiKey = apiKey;
//        this.apiURL = apiURL;
//        this.apiParameters = apiParameters;
//        this.apiUserKey = apiUserKey;
    }

    public Results MakeCall(String restaurant, String city, String state) throws Exception{

        loadAllProperties();

        this.restaurantName = restaurant;
        this.cityName = city;
        this.stateName = state;

        apiParameters += (restaurantName + "," +
                cityName + "," +
                stateName);

        apiUserKey += apiKey;

        log.info("Calling " + apiURL + apiParameters + apiUserKey);

//        https://maps.googleapis.com/maps/api/geocode/json?components=locality:santa+cruz|country:ES&key=YOUR_API_KEY

        //Make the call
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(apiURL + apiParameters + apiUserKey);

        //This is the response
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        log.info("Response message is " + response);
        ObjectMapper mapper = new ObjectMapper();
        Results results = mapper.readValue(response, Results.class);

        //Return all the JSON data
        return results;
    }

    public void loadAllProperties(){
        InputStream inputStream = null;

        try{
            ourMenuProperties.load(this.getClass().getResourceAsStream("/ourMenu.properties"));
            this.apiURL = ourMenuProperties.getProperty("apiURL");
            this.apiParameters = ourMenuProperties.getProperty("apiParameters");
            this.apiUserKey = ourMenuProperties.getProperty("apiUserKey");
            this.apiKey = ourMenuProperties.getProperty("GoogleMapsAPI");

        } catch (IOException ex) {
            log.error("$$$$$$$$$$$$$$$$$ERROR ONE " + ex);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("$$$$$$$$$$$$$$$$$ERROR TWO " + e);
                }
            }
        }
    }
}
