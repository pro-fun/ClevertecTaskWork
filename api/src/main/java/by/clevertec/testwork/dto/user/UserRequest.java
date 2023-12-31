package by.clevertec.testwork.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message = "Пустой логин")
    private String login;
    @NotBlank(message = "Пустой пароль")
    private String password;
}
