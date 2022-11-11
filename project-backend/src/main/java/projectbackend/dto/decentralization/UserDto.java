package projectbackend.dto.decentralization;

import projectbackend.model.customer.Customer;
import projectbackend.model.employee.Employee;

public class UserDto {
    private String username;
    private String password;
    private boolean isDelete;

    public UserDto() {
    }

    public UserDto(String userName, String password, boolean isDelete) {
        this.username = userName;
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
