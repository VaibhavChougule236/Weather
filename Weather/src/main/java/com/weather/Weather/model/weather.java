package com.weather.Weather.model;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class weather {
    private Current current;
    private Location location;

    @Getter
    @Setter
public class Current{
    public String observation_time;
    public int temperature;
    public ArrayList<String> weather_icons;
    public ArrayList<String> weather_descriptions;
    public int wind_speed;
    public int wind_degree;
    public int humidity;
    public int feelslike;
    public String is_day;
}

    @Getter
    @Setter
public class Location{
    public String name;
    public String country;
    public String region;
}
    
}


