package com.meli.domain;

import org.springframework.data.repository.CrudRepository;

public interface WeatherPredictionRepository extends CrudRepository<WeatherPrediction, Long> {
	
	WeatherPrediction findByDay(int day);

}
