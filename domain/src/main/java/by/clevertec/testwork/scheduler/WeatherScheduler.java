package by.clevertec.testwork.scheduler;

import by.clevertec.testwork.model.Coordinate;
import by.clevertec.testwork.properties.CityCoordinate;
import by.clevertec.testwork.service.WeatherService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WeatherScheduler {
    private final CityCoordinate cityCoordinate;
    private final WeatherService weatherService;

    @Timed("schedulerWeather")
    @Scheduled(fixedDelay = 600_000)
    public void checkWeather(){
        Coordinate coordinate = new Coordinate(cityCoordinate.getLongitude(), cityCoordinate.getLatitude());
        weatherService.getWeatherInfo(coordinate);

    }
}
