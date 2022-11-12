package projectbackend.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.customer.ICustomerDto;
import projectbackend.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Optional<ICustomerDto> findCustomerByUsername(String username);

    Optional<Customer> findById(int id);


        void saveCustomer(String username, String password, String name, String dayOfBirth, int gender,
                                                  String idCard, String email, String address, String phoneNumber, int customerType);


    Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);

}
