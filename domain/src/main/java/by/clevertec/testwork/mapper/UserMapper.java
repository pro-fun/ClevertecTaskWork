package by.clevertec.testwork.mapper;

import by.clevertec.testwork.dto.user.UserRequest;
import by.clevertec.testwork.dto.user.UserResponse;
import by.clevertec.testwork.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toResponse(User user);
    User toEntity(UserRequest userRequest);


}
