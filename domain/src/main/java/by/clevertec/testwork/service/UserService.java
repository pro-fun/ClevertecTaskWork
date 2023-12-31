package by.clevertec.testwork.service;


import by.clevertec.testwork.contract.serviceApi.UserServiceApi;
import by.clevertec.testwork.dto.user.UserRequest;
import by.clevertec.testwork.dto.user.UserResponse;
import by.clevertec.testwork.exception.UserAccountException;
import by.clevertec.testwork.mapper.UserMapper;
import by.clevertec.testwork.model.User;
import by.clevertec.testwork.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
@RequiredArgsConstructor
public class UserService implements UserServiceApi {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final HttpServletRequest servletRequest;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    /** метод для регистрации нового пользователя*/
    @Override
    public UserResponse addUser(UserRequest userRequest) {
        if(userRepository.findByLogin(userRequest.getLogin()) != null) {
            throw new UserAccountException("Данный логин уже используется");
        }
        var user = userMapper.toEntity(userRequest);
        String encodingString = passwordEncoder.encode(userRequest.getPassword());
        user.setPassword(encodingString);
        user.setRole("USER");
        return userMapper.toResponse(userRepository.save(user));
    }
    /** метод для авторизации*/
    @Override
    public UserResponse login(UserRequest userRequest) throws ServletException {
        servletRequest.logout();
        servletRequest.login(userRequest.getLogin(), userRequest.getPassword());
        User user = userRepository.findByLogin(userRequest.getLogin());
        return userMapper.toResponse(user);
    }
}
