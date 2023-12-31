package by.clevertec.testwork.service;

import by.clevertec.testwork.apiclient.WeatherApiClient;
import by.clevertec.testwork.dto.weatherdata.CurrentTemperatureResponse;
import by.clevertec.testwork.exception.WeatherDataException;
import by.clevertec.testwork.mapper.CurrentTemperatureMapper;
import by.clevertec.testwork.mapper.FactMapper;
import by.clevertec.testwork.mapper.ForecastMapper;
import by.clevertec.testwork.model.Coordinate;
import by.clevertec.testwork.model.CurrentTemperature;
import by.clevertec.testwork.model.weatherdata.WeatherInfo;
import by.clevertec.testwork.properties.YandexProperties;
import by.clevertec.testwork.repository.WeatherRepository;
import io.micrometer.core.instrument.MeterRegistry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {
    @Mock
    private WeatherRepository weatherRepository;
    @Mock
    private CurrentTemperatureMapper currentTemperatureMapper;
    @Mock
    private YandexProperties yandexProperties;
    @Mock
    private WeatherApiClient weatherApiClient;
    @Mock
    private FactMapper factMapper;
    @Mock
    private ForecastMapper forecastMapper;
    @Mock
    private MeterRegistry meterRegistry;


    @InjectMocks
    private WeatherService weatherService;

    @Test
    public void getTemperature_when_temperature_received() {
        List<CurrentTemperature> currentTemperatures = new ArrayList<>();
        List<CurrentTemperatureResponse> expectedTemperature = new ArrayList<>();
        CurrentTemperatureResponse currentTemperatureResponse = new CurrentTemperatureResponse();

        when(weatherRepository.findAll()).thenReturn(currentTemperatures);
        lenient().when(currentTemperatureMapper.toResponse(any())).thenReturn(currentTemperatureResponse);

        List<CurrentTemperatureResponse> actualTemperature = weatherService.getAllTemperature();
        assertEquals(expectedTemperature, actualTemperature);
        verify(weatherRepository, times(1)).findAll();
    }

    @Test
    public void getYandexDataWeather_when_infoReceived() {
        Coordinate coordinate = new Coordinate("1", "2");
        String lat = "1";
        String lon = "2";
        String limit = "3";
        String hours = "4";
        String lang = "5";
        String extra = "6";
        String apiKey = "7";
        WeatherInfo weatherInfo = new WeatherInfo();

        when(yandexProperties.getLimit()).thenReturn(limit);
        when(yandexProperties.getHours()).thenReturn(hours);
        when(yandexProperties.getLang()).thenReturn(lang);
        when(yandexProperties.getExtra()).thenReturn(extra);
        when(yandexProperties.getApiKey()).thenReturn(apiKey);
        when(weatherApiClient.getWeatherInfo(any(),any(),any(),any(),any(),any(),any())).thenReturn(weatherInfo);
        WeatherInfo weatherInfo1 = weatherService.getYandexInfo(coordinate);

        verify(weatherApiClient, times(1)).getWeatherInfo(any(),any(),any(),any(),any(),any(),any());
    }


    @Test
    public void getYandexDataWeather_when_infoNotReceived() {
        Coordinate coordinate = new Coordinate("1", "2");
        lenient().when(weatherApiClient.getWeatherInfo(any(),any(),any(),any(),any(),any(),any())).thenReturn(null);

        Exception exception = assertThrows(WeatherDataException.class,()->weatherService.getWeatherInfo(coordinate));
    }




}
