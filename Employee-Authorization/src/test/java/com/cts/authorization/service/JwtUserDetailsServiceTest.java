package com.cts.authorization.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.authorization.model.User;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class JwtUserDetailsServiceTest {
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserServiceFeignClient userServiceFeignClient;

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername() {

        jwtUserDetailsService.loadUserByUsername("janedoe");
    }

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername2() {
        when(userServiceFeignClient.loadUserByName(anyLong())).thenReturn(new User("janedoe", "iloveyou"));
        assertEquals("iloveyou", jwtUserDetailsService.loadUserByUsername("42").getPassword());
        verify(userServiceFeignClient).loadUserByName(anyLong());
    }

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername3() {

        when(userServiceFeignClient.loadUserByName(anyLong())).thenReturn(new User(null, "iloveyou"));
        jwtUserDetailsService.loadUserByUsername("42");
    }

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername4() {
        when(userServiceFeignClient.loadUserByName(anyLong())).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> jwtUserDetailsService.loadUserByUsername("42"));
        verify(userServiceFeignClient).loadUserByName(anyLong());
    }

    /**
     * Method under test: {@link JwtUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername5() {
        User user = mock(User.class);
        when(user.getPassword()).thenThrow(new UsernameNotFoundException("Msg"));
        when(user.getUserName()).thenThrow(new UsernameNotFoundException("Msg"));
        when(userServiceFeignClient.loadUserByName(anyLong())).thenReturn(user);
        assertThrows(UsernameNotFoundException.class, () -> jwtUserDetailsService.loadUserByUsername("42"));
        verify(userServiceFeignClient).loadUserByName(anyLong());
        verify(user).getUserName();
    }
}

