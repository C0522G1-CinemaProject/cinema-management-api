package projectbackend.payload.reponse;

import projectbackend.model.customer.Customer;
import projectbackend.model.decentralization.User;

import java.util.List;


public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private List<String> roles;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public JwtResponse(String token, String type, Integer id, String username, List<String> roles, Customer customer) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.customer = customer;
    }

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken) {
        this.token = jwtToken;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
