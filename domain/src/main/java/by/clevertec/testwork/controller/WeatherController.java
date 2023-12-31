package by.clevertec.testwork.controller;

import by.clevertec.testwork.contract.restApi.WeatherRestApi;
import by.clevertec.testwork.contract.serviceApi.WeatherServiceApi;
import by.clevertec.testwork.dto.weatherdata.CoordinateRequest;
import by.clevertec.testwork.dto.weatherdata.CurrentTemperatureResponse;
import by.clevertec.testwork.dto.weatherdata.FactResponse;
import by.clevertec.testwork.dto.weatherdata.ForecastResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WeatherController implements WeatherRestApi {
    private final WeatherServiceApi weatherService;
    @Override
    public List<CurrentTemperatureResponse> getAllTemperature() {
        return weatherService.getAllTemperature();
    }

    @Override
    public FactResponse getFactWeather(CoordinateRequest coordinateRequest) {
        return weatherService.getFactWeather(coordinateRequest);
    }

    @Override
    public List <ForecastResponse> getForecastWeather(CoordinateRequest coordinateRequest) {
        return weatherService.getForecastWeather(coordinateRequest);
    }
}
