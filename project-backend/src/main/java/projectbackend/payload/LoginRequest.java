package projectbackend.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginRequest {
    @NotBlank(message = "Vui lòng nhập tên đăng nhập")
    @Size(min = 4, max = 40)
    private String username;
    @NotBlank(message = "Vui lòng nhập mật khẩu")
    @Size(min = 6, max = 40)
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
