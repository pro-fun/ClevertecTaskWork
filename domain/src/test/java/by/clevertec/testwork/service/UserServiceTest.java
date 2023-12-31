//package by.clevertec.testwork.service;
//
//import by.clevertec.testwork.dto.user.UserRequest;
//import by.clevertec.testwork.dto.user.UserResponse;
//import by.clevertec.testwork.exception.UserAccountException;
//import by.clevertec.testwork.mapper.UserMapper;
//import by.clevertec.testwork.model.User;
//import by.clevertec.testwork.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//    @Mock
//    private UserRepository userRepository;
//    @Mock
//    private UserMapper userMapper;
//    @Mock
//    private PasswordEncoder passwordEncoder;
//    @InjectMocks
//    private UserService userService;
//
//    @Test
//    public void addUser_when_userIsNew() {
//        String login = "userTest";
//        String encodedPassword = "encoded";
//        UserRequest userRequest = getUserRequest(login);
//        when(userRepository.findByLogin(any())).thenReturn(null);
//        when(userMapper.toEntity(any())).thenReturn(getUser(login));
//        when(passwordEncoder.encode(any())).thenReturn(encodedPassword);
//        when(userRepository.save(any())).thenReturn(getUser(login));
//        given(userMapper.toResponse(any())).willReturn(getUserResponse());
//
//        UserResponse actualUser = userService.addUser(userRequest);
//        UserResponse expectedUser = new UserResponse();
//        expectedUser.setLogin(login);
//        assertEquals(expectedUser, actualUser);
//        assertEquals(login,actualUser.getLogin());
//        verify(userRepository,times(1)).findByLogin(any());
//        verify(passwordEncoder,times(1)).encode(any());
//        verify(userMapper,times(1)).toResponse(any());
//        verify(userMapper,times(1)).toEntity(any());
//    }
//    @Test
//    public void addUser_when_userIsPresent(){
//        String login = "userTest";
//        User user = getUser(login);
//        UserRequest userRequest = getUserRequest(login);
//        lenient().when(userRepository.findByLogin(any())).thenReturn(user);
//
//        Exception exception = assertThrows(UserAccountException.class,()->userService.addUser(userRequest));
//
//    }
//
//    private UserRequest getUserRequest(String login) {
//        UserRequest userRequest = new UserRequest();
//        userRequest.setLogin(login);
//        userRequest.setPassword("password");
//        return userRequest;
//    }
//    private UserResponse getUserResponse(){
//        UserResponse userResponse = new UserResponse();
//        userResponse.setLogin("userTest");
//        return userResponse;
//    }
//
//    private User getUser(String login) {
//        User user = new User();
//        user.setLogin(login);
//        return user;
//    }
//}
