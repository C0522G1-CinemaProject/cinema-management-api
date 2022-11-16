package projectbackend.dto.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.model.customer.Customer;

public class CustomerTypeDto {
    private Integer id;
    private String name;
    private boolean isDelete;

    public CustomerTypeDto() {
    }

    public CustomerTypeDto(Integer id, String name, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
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
}
//    @Query(value = "update customer as cus set" +
//            " cus.name  :#{#c.name}, cus.day_of_birth :#{#c.dayOfBirth}, cus.gender :#{#c.gender}, cus.id_card :#{#c.idCard}," +
//            " cus.email :#{#c.email}, cus.address :#{#c.address}, cus.phone_number :#{#c.phoneNumber} " +
//            "where cus.username =:username", nativeQuery = true)
//    void updateCustomer(@Param("c") Customer customer, @Param("username") String username);
