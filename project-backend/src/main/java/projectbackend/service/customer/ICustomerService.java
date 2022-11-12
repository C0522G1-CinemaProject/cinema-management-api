package projectbackend.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.customer.ICustomerDto;
import projectbackend.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();

    Optional<ICustomerDto> findCustomerByUsername(String username);

    Optional<Customer> findById(int id);


    void saveCustomer(String username, String password, String name, String dayOfBirth, int gender,
                      String idCard, String email, String address, String phoneNumber, int customerType);


    void save(Customer customer);

    Optional<Customer> findByIdCustomer(Integer id);

    void update(Customer customer);

    Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);

}
