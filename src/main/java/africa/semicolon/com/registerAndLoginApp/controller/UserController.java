package africa.semicolon.com.registerAndLoginApp.controller;

import africa.semicolon.com.registerAndLoginApp.dtos.request.RegisterUserRequest;
import africa.semicolon.com.registerAndLoginApp.dtos.response.ApiResponse;
import africa.semicolon.com.registerAndLoginApp.dtos.response.RegisterUserResponse;
import africa.semicolon.com.registerAndLoginApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createAdmin(@RequestBody RegisterUserRequest request){
        try{
            RegisterUserResponse response = userService.registerUser(request);
            return new ResponseEntity<>(new ApiResponse(true, response), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),  HttpStatus.BAD_REQUEST);
        }
    }

}
