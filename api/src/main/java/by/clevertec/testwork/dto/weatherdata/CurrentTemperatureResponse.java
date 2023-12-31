package by.clevertec.testwork.dto.weatherdata;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CurrentTemperatureResponse {
    private LocalDateTime dateTime;
    private Integer temperature;
}
