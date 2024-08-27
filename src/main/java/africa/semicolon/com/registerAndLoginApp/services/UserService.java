package africa.semicolon.com.registerAndLoginApp.services;

import africa.semicolon.com.registerAndLoginApp.dtos.request.LoginUserRequest;
import africa.semicolon.com.registerAndLoginApp.dtos.request.RegisterUserRequest;
import africa.semicolon.com.registerAndLoginApp.dtos.response.LoginUserResponse;
import africa.semicolon.com.registerAndLoginApp.dtos.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);

    void deleteAll();
}
