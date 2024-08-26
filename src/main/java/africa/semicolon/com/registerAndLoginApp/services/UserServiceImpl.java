package africa.semicolon.com.registerAndLoginApp.services;

import africa.semicolon.com.registerAndLoginApp.data.models.User;
import africa.semicolon.com.registerAndLoginApp.data.repository.UserRepository;
import africa.semicolon.com.registerAndLoginApp.dtos.request.RegisterUserRequest;
import africa.semicolon.com.registerAndLoginApp.dtos.response.RegisterUserResponse;
import africa.semicolon.com.registerAndLoginApp.exceptions.IncorrectPasswordException;
import africa.semicolon.com.registerAndLoginApp.exceptions.UserAlreadyExistException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
//        String email = registerUserRequest.getEmail();
//        validate(email);
//        validateRegistration(registerUserRequest);
        User user = modelMapper.map(registerUserRequest, User.class);
        var savedUser = userRepository.save(user);
        var response = modelMapper.map(savedUser, RegisterUserResponse.class);
        response.setMessage("Registration successfully");
        return response;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest loginUserRequest) {
        validateLogin(loginUserRequest);
        User user = userRepository.findByEmail(loginUserRequest.getUsername());
        modelMapper.map(loginUserRequest, User.class);
        if(user.getEmail() != null) {
            user.setLoggedIn(true);
        }
        LoginUserResponse response = new LoginUserResponse();
        response.setMessage("User logged in Successful");
        return response;
    }

    private void validate (String email){
        for (User user : userRepository.findAll()) {
            if (user.getEmail().equals(email)) {
                throw new UserAlreadyExistException("email already exist");
            }
        }
    }
    private static void validateRegistration (RegisterUserRequest request){
        if (!request.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
            throw new UserAlreadyExistException("Invalid Input");
        if (request.getPassword().isEmpty())
            throw new IncorrectPasswordException("Invalid Password provide a Password");
    }
    private static void validateLogin(LoginUserRequest loginUserRequest) {
        if (loginUserRequest.getPassword().isEmpty())
            throw new IncorrectPasswordException("Invalid Password provide a Password");
    }
}
