package by.clevertec.testwork.mapper;

import by.clevertec.testwork.dto.weatherdata.CoordinateRequest;
import by.clevertec.testwork.model.Coordinate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoordinateMapper {
    Coordinate toEntity(CoordinateRequest coordinateRequest);
}
