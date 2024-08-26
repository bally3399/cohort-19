package africa.semicolon.com.registerAndLoginApp.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUserRequest {
    private String username;
    private String password;
}