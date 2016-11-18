package com.meli;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.meli.domain.WeatherPrediction;
import com.meli.domain.Planet;
import com.meli.domain.SolarSystem;
import com.meli.domain.WeatherCondition;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*List<Planet> planets = new ArrayList<>(3);
		planets.add(new Planet("Ferengi", 0, -1, 500));
		planets.add(new Planet("Betasoide", 0, -3, 2000));
		planets.add(new Planet("Vulcano", 0, 5, 1000));
		SolarSystem solarSystem = new SolarSystem(planets);
		List<WeatherPrediction> weatherPredictions = solarSystem.predictWeather(10 * 365);
		for (int i = 0; i <= 720; i++) {
			if (weatherPredictions.get(i).getWeatherCondition().equals(WeatherCondition.DRY)) {
				System.out.println("DRY: " + i);
			} else if (weatherPredictions.get(i).getWeatherCondition().equals(WeatherCondition.OPTIMAL)) {
				System.out.println("OPTIMAL: " + i);
			}  else if (weatherPredictions.get(i).getWeatherCondition().equals(WeatherCondition.RAIN)) {
				System.out.println("RAIN: " + i);
			}  else if (weatherPredictions.get(i).getWeatherCondition().equals(WeatherCondition.MAX_RAIN)) {
				System.out.println("MAX_RAIN: " + i);
			}
		}*/
		
	}

}
