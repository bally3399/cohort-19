package africa.semicolon.com.registerAndLoginApp.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
