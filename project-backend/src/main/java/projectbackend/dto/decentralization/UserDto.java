package projectbackend.dto.decentralization;


public class UserDto {
    private String username;
    private String password;
    //    @Enumerated(EnumType.STRING)
//    private AuthenticationProvider authProvider;
    private boolean isDelete;

    public UserDto() {
    }


    public UserDto(String userName, String password, boolean isDelete) {
        this.username = userName;
        this.password = password;
        this.isDelete = isDelete;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
