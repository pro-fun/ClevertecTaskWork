package by.clevertec.testwork.contract.serviceApi;


import by.clevertec.testwork.dto.user.UserRequest;
import by.clevertec.testwork.dto.user.UserResponse;
import jakarta.servlet.ServletException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserServiceApi {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    UserResponse addUser(UserRequest userRequest);
    UserResponse login(UserRequest userRequest) throws ServletException;
}
