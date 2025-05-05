package com.weather.Weather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weather.Weather.model.weather;

@Component
public class weatherService {

    @Autowired
    private RestTemplate restTemplate;
    
    private static final String apiKey="8f6d193931e15b985f140bcbd3a23004";
    //private static final String apiKey="201338a67b359afc61861f134fd89243";

    private static final String API="https://api.weatherstack.com/current?access_key=API_KEY&query=CITY";
    
    //private static final String API="https://api.openweathermap.org/data/2.5/weather?q=CITY&appid=API_KEY";
    
    public weather getWeather(String city){
        String finalApi=API.replace("API_KEY", apiKey).replace("CITY", city);
        ResponseEntity<weather> response= restTemplate.exchange(finalApi,HttpMethod.GET,null,weather.class);
        weather weatherResponse=response.getBody();
        //json to pojo is called deserialization
        //pojo to json is called serialization
        return weatherResponse;
    }
    
}

//
//
//package com.weather.Weather.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.weather.Weather.model.weather;
//
//@Component
//public class weatherService {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
////    private static final String apiKey = "201338a67b359afc61861f134fd89243";
//    private static final String apiKey = "21dba0be51ea4cdf9da741881216a1ec";
//    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
//
//    public weather getWeather(String city) {
//        // Construct the API URL safely
//        String finalApi = UriComponentsBuilder.fromHttpUrl(BASE_URL)
//                .queryParam("q", city)
//                .queryParam("appid", apiKey)
//                .queryParam("units", "metric")  // Optional: for temperature in Celsius
//                .build()
//                .toUriString();
//
//        // Debug: Print the final URL
//        System.out.println("Calling API: " + finalApi);
//
//        // Get raw JSON response first
//        ResponseEntity<String> rawResponse = restTemplate.exchange(finalApi, HttpMethod.GET, null, String.class);
//        System.out.println("API Response: " + rawResponse.getBody());
//
//        // Now deserialize into the weather class
//        ResponseEntity<weather> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, weather.class);
//        return response.getBody();
//    }
//}
//
//package com.weather.Weather.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.weather.Weather.model.weather;
//
//@Service
//public class weatherService {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    private static final String API_KEY = "21dba0be51ea4cdf9da741881216a1ec";
//    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
//
//    public weather getWeather(String city) {
//        String finalApi = UriComponentsBuilder.fromHttpUrl(BASE_URL)
//                .queryParam("q", city)
//                .queryParam("appid", API_KEY)
//                .queryParam("units", "metric")  // Fetch temperature in Celsius
//                .build()
//                .toUriString();
//
//        // Debugging: Log the API call
//        System.out.println("Calling API: " + finalApi);
//
//        try {
//            ResponseEntity<weather> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, weather.class);
//            return response.getBody();
//        } catch (Exception e) {
//            System.err.println("Error fetching weather data: " + e.getMessage());
//            return null;
//        }
//    }
//}
