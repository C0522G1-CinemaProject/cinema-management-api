package projectbackend.dto.decentralization;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
    @NotBlank(message = "không được để trống")
    private String username;

    @NotBlank(message = "Không được để trống")
    @Size(min = 6, max = 12)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "Tối thiểu 6 ký tự, ít nhất một chữ cái và một số")
    private String password;


    public UserDto() {
    }

    public UserDto(String username, String password, boolean isDelete) {
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
