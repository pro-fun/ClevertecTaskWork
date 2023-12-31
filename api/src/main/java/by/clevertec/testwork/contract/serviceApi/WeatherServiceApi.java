package by.clevertec.testwork.contract.serviceApi;

import by.clevertec.testwork.dto.weatherdata.CoordinateRequest;
import by.clevertec.testwork.dto.weatherdata.CurrentTemperatureResponse;
import by.clevertec.testwork.dto.weatherdata.FactResponse;
import by.clevertec.testwork.dto.weatherdata.ForecastResponse;

import java.util.List;

public interface WeatherServiceApi {
    List<CurrentTemperatureResponse> getAllTemperature();
    FactResponse getFactWeather(CoordinateRequest coordinateRequest);

    List<ForecastResponse> getForecastWeather(CoordinateRequest coordinateRequest);

}
