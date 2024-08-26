package africa.semicolon.com.registerAndLoginApp.services;

import africa.semicolon.com.registerAndLoginApp.dtos.request.RegisterUserRequest;
import africa.semicolon.com.registerAndLoginApp.dtos.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
}
