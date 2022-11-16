package projectbackend.dto.decentralization;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5})| *$",
            message = "không chứa ký tự đặc biệt")
    private String username;

    @NotBlank(message = "Không được để trống")
    @Size(min = 6, max = 12)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", message = "Tối thiểu 6 ký tự, ít nhất một chữ cái và một số")
    private String password;
    //    @Enumerated(EnumType.STRING)
//    private AuthenticationProvider authProvider;
    private boolean isDelete;

    public UserDto() {
    }




    public UserDto(String username, String password, boolean isDelete){
            this.username = username;
            this.password = password;
            this.isDelete = isDelete;
        }


        public String getUsername () {
            return username;
        }

        public void setUsername (String userName){
            this.username = username;
        }

        public String getPassword () {
            return password;
        }

        public void setPassword (String password){
            this.password = password;
        }

        public boolean isDelete () {
            return isDelete;
        }

        public void setDelete ( boolean delete){
            isDelete = delete;
        }
    }
