package by.clevertec.testwork.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/** Класс для получения данных запроса в yandex.api из application.yml*/
@Data
@Component
@ConfigurationProperties(prefix = "yandex")
public class YandexProperties {
    private String url;
    private String apiKey;
    private String lang;
    private String limit;
    private String hours;
    private String extra;
}
