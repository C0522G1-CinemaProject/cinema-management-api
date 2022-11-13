package projectbackend.dto.decentralization;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import projectbackend.model.customer.Customer;
import projectbackend.model.employee.Employee;

public class UserDto {

    @NotBlank(message = "không được để trống")
    private String username;

    @NotBlank(message = "Không được để trống")

    @Size(min = 6, max = 12)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "Tối thiểu 6 ký tự, ít nhất một chữ cái và một số")
    private String password;


    public UserDto() {
    }


    public UserDto(String userName, String password, boolean isDelete) {
        this.username = userName;
        this.password = password;

    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
