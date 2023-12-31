package by.clevertec.testwork.apiclient;

import by.clevertec.testwork.model.weatherdata.WeatherInfo;
import io.micrometer.core.annotation.Timed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(name = "yandexclient", url = "${yandex.url}")
public interface WeatherApiClient {
    @Timed("gettingWeatherFromYandex")
    @GetMapping
    WeatherInfo getWeatherInfo(@RequestParam String lat, @RequestParam String lon,
                               @RequestParam String limit, @RequestParam String hours,
                               @RequestParam String lang, @RequestParam String extra,
                               @RequestHeader(name = "X-Yandex-API-Key") String apiKey);
}
