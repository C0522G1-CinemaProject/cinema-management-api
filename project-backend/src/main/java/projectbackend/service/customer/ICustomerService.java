package projectbackend.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.customer.ICustomerDto;
import projectbackend.model.customer.Customer;
import projectbackend.model.decentralization.User;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Optional<ICustomerDto> findCustomerByUsername(String username);

    Optional<Customer> findById(int id);


    void saveCustomer(Customer customer);


    Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);

    void updatePassword(User user, String newPassword);
}
