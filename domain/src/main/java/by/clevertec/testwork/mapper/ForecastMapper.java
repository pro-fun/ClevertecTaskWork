package by.clevertec.testwork.mapper;


import by.clevertec.testwork.dto.weatherdata.ForecastResponse;
import by.clevertec.testwork.model.weatherdata.Forecast;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ForecastMapper {
    ForecastResponse toResponse(Forecast forecast);
}
