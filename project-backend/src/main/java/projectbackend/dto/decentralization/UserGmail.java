package projectbackend.dto.decentralization;

public class UserGmail {
    private String username;
    private String name;

    public UserGmail(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public UserGmail() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
