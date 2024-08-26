package africa.semicolon.com.registerAndLoginApp.services;

import africa.semicolon.com.registerAndLoginApp.dtos.request.RegisterUserRequest;
import africa.semicolon.com.registerAndLoginApp.dtos.response.RegisterUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void registerUserTest() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("Baliqis");
        registerUserRequest.setLastName("Bimbim");
        registerUserRequest.setEmail("bimbim@gmail.com");
        registerUserRequest.setPassword("1254");
        RegisterUserResponse response = userService.registerUser(registerUserRequest);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Registration successfully");
    }
    public void loginUserTest(){
        registerUserTest();
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("bimbim@gmail.com");
        loginUserRequest.setPassword("1254");
        LoginUserResponse loginUserResponse = userService.loginUser(loginUserRequest);
        assertThat(loginUserResponse).isNotNull();
        assertThat(loginUserResponse.getMessage()).contains("Successful");
    }


}