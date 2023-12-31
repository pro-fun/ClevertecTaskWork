package by.clevertec.testwork.controller;


import by.clevertec.testwork.contract.restApi.RegistrationRestApi;
import by.clevertec.testwork.contract.serviceApi.UserServiceApi;
import by.clevertec.testwork.dto.user.UserRequest;
import by.clevertec.testwork.dto.user.UserResponse;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController implements RegistrationRestApi {
    private final UserServiceApi userService;
    @Override
    public UserResponse addUser(UserRequest userRequest) {
        return userService.addUser(userRequest);
    }

    @Override
    public UserResponse login(UserRequest userRequest) throws ServletException {
        return userService.login(userRequest);
    }
}
