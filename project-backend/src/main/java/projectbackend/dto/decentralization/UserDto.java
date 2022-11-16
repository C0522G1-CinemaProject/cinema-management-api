package projectbackend.dto.decentralization;


public class UserDto {

    private String username;

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

    public void setUsername(String userName) {
        this.username = username;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
