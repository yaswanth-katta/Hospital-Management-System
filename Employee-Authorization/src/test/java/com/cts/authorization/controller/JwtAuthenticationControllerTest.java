package com.cts.authorization.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.cts.authorization.model.MyUserDetails;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import com.cts.authorization.config.JwtTokenUtil;
import com.cts.authorization.model.JwtRequest;
import com.cts.authorization.model.User;
import com.cts.authorization.service.JwtUserDetailsService;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JwtAuthenticationControllerTest {

    @Autowired
    private JwtAuthenticationController jwtAuthenticationController;

    @MockBean
    private JwtUserDetailsService jwtUserDetailsService;

    @SuppressWarnings("deprecation")
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtTokenUtil jwtTokenUtil;

    @MockBean
    private JwtUserDetailsService userDetailsService;

    @InjectMocks
    private JwtAuthenticationController controller;

//    @Test
//    void testGenerateToken() throws Exception {
//        JwtRequest req = new JwtRequest("admin","pass");
//        User user = new User("admin", "pass");
//        UserDetails details = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
//                new ArrayList<>());
//        when(userDetailsService.loadUserByUsername("admin")).thenReturn(details);
//        when(jwtTokenUtil.generateToken(details)).thenReturn("token");
//        String entity = controller.createAuthenticationToken(req);
//        //assertThat(Integer.valueOf(entity.getStatusCodeValue()).equals(Integer.valueOf(200))).isTrue();
//
//    }

    @Test
     void testAuthorization() throws Exception {
        when(jwtTokenUtil.getUsernameFromToken("Bearer token")).thenReturn(null);
        assertThat(controller.authorizeTheRequest("Bearer token")).isFalse();
    }

    @Test
     void testAuthorizationInvalid() throws Exception {
        User user = new User("admin", "pass");
        UserDetails details = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                new ArrayList<>());
        when(userDetailsService.loadUserByUsername("admin")).thenReturn(details);
        when(jwtTokenUtil.getUsernameFromToken("token")).thenReturn("admin");
        assertThat(controller.authorizeTheRequest("token")).isFalse();

    }

    @Test
     void testAuthorizationNullUser() throws Exception {

        User user = new User("admin", "pass");
        UserDetails details = new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                new ArrayList<>());
        when(userDetailsService.loadUserByUsername("admin")).thenReturn(details);
        when(jwtTokenUtil.getUsernameFromToken("token")).thenReturn("admin");

        assertThat(controller.authorizeTheRequest("WrongToken")).isFalse();

    }

    /**
     * Method under test: {@link JwtAuthenticationController#createAuthenticationToken(JwtRequest)}
     */
    @Test
    void testCreateAuthenticationToken() throws Exception {
        when(jwtTokenUtil.generateToken((UserDetails) any())).thenReturn("ABC123");
        when(jwtUserDetailsService.loadUserByUsername((String) any()))
                .thenReturn(new MyUserDetails(new User("janedoe", "iloveyou")));
        when(authenticationManager.authenticate((Authentication) any()))
                .thenReturn(new TestingAuthenticationToken("Principal", "Credentials"));

        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setPassword("iloveyou");
        jwtRequest.setUserName("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(jwtRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(jwtAuthenticationController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("ABC123"));
    }
}
