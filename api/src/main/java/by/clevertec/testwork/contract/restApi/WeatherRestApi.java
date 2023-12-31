package by.clevertec.testwork.contract.restApi;

import by.clevertec.testwork.dto.weatherdata.CoordinateRequest;
import by.clevertec.testwork.dto.weatherdata.CurrentTemperatureResponse;
import by.clevertec.testwork.dto.weatherdata.FactResponse;
import by.clevertec.testwork.dto.weatherdata.ForecastResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping
public interface WeatherRestApi {
    @GetMapping("/temperature")
    List<CurrentTemperatureResponse> getAllTemperature();

    @PostMapping("/factByCoordinate")
    FactResponse getFactWeather(@RequestBody CoordinateRequest coordinateRequest);
    @PostMapping("/forecastByCoordinate")
    List<ForecastResponse> getForecastWeather(@RequestBody CoordinateRequest coordinateRequest);

}
