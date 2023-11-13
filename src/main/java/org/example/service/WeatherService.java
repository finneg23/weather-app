package org.example.service;

import org.example.model.LatLong;
import org.example.model.WeatherObject;
import org.springframework.web.client.RestTemplate;

public class WeatherService {
    private RestTemplate template = new RestTemplate();
    private final String API_URL = "http://api.openweathermap.org/geo/1.0/zip";
    private final String API_KEY = "5e9612ca580fb7b69e0e620c2ac46401";

    public LatLong getLatLong(String zipcode) {
        return template.getForObject(API_URL + "?zip=" + zipcode + "&appid=" + API_KEY, LatLong.class);

    }

    public WeatherObject getWeather(LatLong latLong) {
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latLong.getLat() +
                "&lon=" + latLong.getLon() + "&units=imperial&appid=" + API_KEY;
        return template.getForObject(url, WeatherObject.class);
    }
}
