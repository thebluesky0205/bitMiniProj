package com.example.demo.repository;

import com.example.demo.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    public Weather findByWeatherNo(String weatherNo);
}

