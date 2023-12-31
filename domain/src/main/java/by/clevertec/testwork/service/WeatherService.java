package by.clevertec.testwork.service;

import by.clevertec.testwork.apiclient.WeatherApiClient;
import by.clevertec.testwork.contract.serviceApi.WeatherServiceApi;
import by.clevertec.testwork.dto.weatherdata.CoordinateRequest;
import by.clevertec.testwork.dto.weatherdata.CurrentTemperatureResponse;
import by.clevertec.testwork.dto.weatherdata.FactResponse;
import by.clevertec.testwork.dto.weatherdata.ForecastResponse;
import by.clevertec.testwork.exception.WeatherDataException;
import by.clevertec.testwork.mapper.CurrentTemperatureMapper;
import by.clevertec.testwork.mapper.FactMapper;
import by.clevertec.testwork.mapper.ForecastMapper;
import by.clevertec.testwork.model.Coordinate;
import by.clevertec.testwork.model.CurrentTemperature;
import by.clevertec.testwork.model.weatherdata.Fact;
import by.clevertec.testwork.model.weatherdata.Forecast;
import by.clevertec.testwork.model.weatherdata.WeatherInfo;
import by.clevertec.testwork.properties.YandexProperties;
import by.clevertec.testwork.repository.WeatherRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class WeatherService implements WeatherServiceApi {
    private final WeatherRepository weatherRepository;
    private final CurrentTemperatureMapper currentTemperatureMapper;
    private final YandexProperties yandexProperties;
    private final WeatherApiClient weatherApiClient;
    private final FactMapper factMapper;
    private final ForecastMapper forecastMapper;
    /** кастомная метрика для данных, записываемых шедулером*/
    private AtomicInteger metricTemperature;

    public WeatherService(WeatherRepository weatherRepository, CurrentTemperatureMapper currentTemperatureMapper
                         , YandexProperties yandexProperties, WeatherApiClient weatherApiClient
                         , FactMapper factMapper, ForecastMapper forecastMapper, MeterRegistry meterRegistry) {
        this.weatherRepository = weatherRepository;
        this.currentTemperatureMapper = currentTemperatureMapper;
        this.yandexProperties = yandexProperties;
        this.weatherApiClient = weatherApiClient;
        this.factMapper = factMapper;
        this.forecastMapper = forecastMapper;
        metricTemperature = new AtomicInteger();

        meterRegistry.gauge("currentTemperature", metricTemperature);
    }
/** метод для получения данных из БД, сохранённых шедулером*/
    public List<CurrentTemperatureResponse> getAllTemperature() {
        List < CurrentTemperature> currentTemperatures = weatherRepository.findAll();
        return currentTemperatures.stream().map(currentTemperatureMapper::toResponse).collect(Collectors.toList());
    }
    /** метод для получения прогноза погоды на пять дней*/
    @Override
    public List<ForecastResponse> getForecastWeather(CoordinateRequest coordinateRequest) {
        Coordinate coordinate = new Coordinate(coordinateRequest.getLongitude(), coordinateRequest.getLatitude());
        WeatherInfo currentInfo = getYandexInfo(coordinate);
        List<Forecast> forecasts = currentInfo.getForecasts();
        return forecasts.stream().map(forecastMapper::toResponse).collect(Collectors.toList());
    }
    /** метод для получения фактического значения погоды*/
    @Override
    public FactResponse getFactWeather(CoordinateRequest coordinateRequest) {
        Coordinate coordinate = new Coordinate(coordinateRequest.getLongitude(), coordinateRequest.getLatitude());
        WeatherInfo currentInfo = getYandexInfo(coordinate);
        Fact factWeather = currentInfo.getFact();
        return factMapper.toResponse(factWeather);
    }
    /** метод для получения фактического значения погоды*/
    public void getWeatherInfo(Coordinate coordinate) {
        WeatherInfo currentInfo = getYandexInfo(coordinate);
        Integer temperature = currentInfo.getFact().getTemp();
        metricTemperature.set(temperature);
        CurrentTemperature currentTemperature = new CurrentTemperature(
                LocalDateTime.now(ZoneId.of("Europe/Minsk")),
                temperature);
        weatherRepository.save(currentTemperature);
    }
    /** метод для шедулера по получению значения погоды*/
    protected WeatherInfo getYandexInfo(Coordinate coordinate){
        String lat = coordinate.getLatitude();
        String lon = coordinate.getLongitude();
        String limit = yandexProperties.getLimit();
        String hours = yandexProperties.getHours();
        String lang = yandexProperties.getLang();
        String extra = yandexProperties.getExtra();
        String apiKey = yandexProperties.getApiKey();

        WeatherInfo currentInfo = weatherApiClient.getWeatherInfo(lat, lon, limit, hours, lang, extra, apiKey);
        if (currentInfo == null) {
            throw new WeatherDataException ("Weather info is empty");
        }
        return currentInfo;
    }
}
