package by.clevertec.testwork.mapper;

import by.clevertec.testwork.dto.weatherdata.CurrentTemperatureResponse;
import by.clevertec.testwork.model.CurrentTemperature;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrentTemperatureMapper {
    CurrentTemperatureResponse toResponse(CurrentTemperature currentTemperature);
}
