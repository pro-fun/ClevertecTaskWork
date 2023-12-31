package by.clevertec.testwork.service;

import by.clevertec.testwork.contract.serviceApi.UserServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserCheckDetailsService implements UserDetailsService {
    private final UserServiceApi userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userService.loadUserByUsername(username);
        return userDetails;
    }
}
