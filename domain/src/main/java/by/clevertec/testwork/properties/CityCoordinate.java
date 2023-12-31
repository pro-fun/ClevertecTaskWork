package by.clevertec.testwork.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/** Класс для получения координат из application.yml, которые используются шедулером*/
@Data
@Component
@ConfigurationProperties(prefix = "coordinate")
public class CityCoordinate {
    public String longitude;
    public String latitude;
}
