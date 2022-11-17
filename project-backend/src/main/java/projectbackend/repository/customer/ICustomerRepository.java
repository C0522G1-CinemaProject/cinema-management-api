package projectbackend.repository.customer;



import org.springframework.stereotype.Repository;
import projectbackend.dto.customer.ICustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.model.customer.Customer;

import java.util.Optional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select customer.name as customerName,customer.day_of_birth as birthday ,customer.gender as customerGender," +
            "customer.id_card as customerIdCard,customer.email as customerEmail,customer.address as customerAddress,customer.phone_number as customerPhoneNumber," +
            "user.username as customerUserName,user.`password` as customerPassword,customer.customer_type_id as customerTypeId  " +
            "from customer " +
            "join user on customer.username = user.username " +
            " where user.username like %:username% and customer.is_delete=0",
            countQuery = " select  count(*)",
            nativeQuery = true)
    Optional<ICustomerDto> findCustomerByUsername(@Param("username") String username);


    @Query(value = "select user.username as customerUserName,user.password as customerPassword  " +
            "from customer " +
            "join user on customer.username = user.username " +
            " where user.username like %:username% and customer.is_delete=0",
            countQuery = " select  count(*)",
            nativeQuery = true)
    Optional<ICustomerDto> findUserByUsername(@Param("username") String username);


    @Query(value = "select id, name, is_delete, day_of_birth, username, gender, id_card, email, address, phone_number, customer_type_id" +
            " from customer " +
            "where name like %:nameSearch% and address like %:addressSearch% " +
            "and phone_number like %:phoneSearch% and is_delete = 0",
            countQuery = "select count(*) from customer  " +
                    "where name like %:nameSearch% and address like %:addressSearch% " +
                    "and phone_number like %:phoneSearch% and is_delete = 0 ",
            nativeQuery = true)
    Page<Customer> searchCustomer(@Param("nameSearch") String nameSearch, @Param("addressSearch") String addressSearch,
                                  @Param("phoneSearch") String phoneSearch, Pageable pageable);

    @Query(value = "select id, name, is_delete, day_of_birth, username, gender, id_card, email, address, phone_number, customer_type_id" +
            " from customer  where id =:id and is_delete = 0", nativeQuery = true)
    Optional<Customer> findByIdCustomer(@Param("id") int id);

}
