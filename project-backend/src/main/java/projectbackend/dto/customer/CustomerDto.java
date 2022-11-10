package projectbackend.dto.customer;

import projectbackend.model.customer.CustomerType;
import projectbackend.model.decentralization.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDto {
    private Integer id;
    @NotBlank(message = "không được để trống")
    @Size(min = 3, max = 32)
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5})| *$", message = "tên phải đúng định dạng, không chứa kí tự đặc biệt")
    private String name;
    private boolean isDelete;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[0-1])| *$",
            message = "Ngày sinh phải đúng định dạng DD/MM/YYYY.")
    private String dayOfBirth;
    @NotNull(message = "Không được để trống")
    private Integer gender;

    @NotBlank(message = "không được trống")
    @Size(min = 9, max = 12)
    @Pattern(regexp = "^(\\d{9}|\\d{12})| *$", message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;

    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}| *$", message = " Email phải đúng định dạng xxxx@.xxx")
    private String email;

    @NotBlank(message = "không được trống")
    private String address;

    @NotBlank(message = "không được trống")
    @Pattern(regexp = "^((\\(\\+84\\-\\))|0)(90|91)[0-9]{7}| *$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx.")
    private String phoneNumber;
    private CustomerType customerType;
    private User user;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String name, boolean isDelete, String dayOfBirth, Integer gender, String idCard,
                       String email, String address, String phoneNumber, CustomerType customerType, User user) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.customerType = customerType;
        this.user = user;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
