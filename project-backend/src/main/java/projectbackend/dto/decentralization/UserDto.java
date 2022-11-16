package projectbackend.dto.decentralization;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    @NotBlank
    @Size(min = 6, max = 15)
    private String username;

    @NotBlank
    @Size(min = 6, max = 15)
    private String password;

    //    @Enumerated(EnumType.STRING)
//    private AuthenticationProvider authProvider;
    private boolean isDelete;

    public UserDto() {
    }

    public UserDto(String username, String password, boolean isDelete) {
        this.username = username;
        this.password = password;
        this.isDelete = isDelete;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = username;

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
