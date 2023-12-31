package by.clevertec.testwork.contract.restApi;

import by.clevertec.testwork.dto.user.UserRequest;
import by.clevertec.testwork.dto.user.UserResponse;
import jakarta.servlet.ServletException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "registration")
public interface RegistrationRestApi {
    @PostMapping("/addUser")
    UserResponse addUser(@RequestBody @Validated UserRequest userRequest);

    @PostMapping("/login")
    UserResponse login(@RequestBody @Validated UserRequest userRequest) throws ServletException;
}