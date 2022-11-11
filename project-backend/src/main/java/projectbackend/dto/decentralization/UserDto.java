package projectbackend.dto.decentralization;

import projectbackend.model.customer.Customer;
import projectbackend.model.employee.Employee;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {
    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(min = 3, max = 15)
    private String password;
    private boolean isDelete;

    public UserDto() {
    }

    public UserDto(String username, String password, boolean isDelete) {
        this.username = username;
        this.password = password;
        this.isDelete = isDelete;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
