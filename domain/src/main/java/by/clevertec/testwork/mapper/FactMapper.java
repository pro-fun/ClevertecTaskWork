package by.clevertec.testwork.mapper;

import by.clevertec.testwork.dto.weatherdata.FactResponse;
import by.clevertec.testwork.model.weatherdata.Fact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FactMapper {
    FactResponse toResponse(Fact fact);
}
