package by.clevertec.testwork.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
@Document
@Data
@NoArgsConstructor
public class CurrentTemperature {
    @MongoId
    private String id;
    private LocalDateTime dateTime;
    private Integer temperature;

    public CurrentTemperature(LocalDateTime dateTime, Integer temperature) {
        this.dateTime = dateTime;
        this.temperature = temperature;
    }
}
