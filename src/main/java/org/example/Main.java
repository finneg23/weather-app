package org.example;

import org.example.model.LatLong;
import org.example.model.WeatherObject;
import org.example.service.WeatherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a zipcode!");
        String zippycodey = input.nextLine();

        WeatherService service = new WeatherService();
        LatLong latLong = service.getLatLong(zippycodey);
        System.out.println("You are in " + latLong.getName());
        System.out.println("You are at " + latLong.getLat() + " & " + latLong.getLon());

        WeatherObject weather = service.getWeather(latLong);
        System.out.println("Current temp is: " + weather.getMain().getTemp());
        System.out.println(" and the weather is going to be: " + weather.getWeather()[0].getDescription());
    }
}