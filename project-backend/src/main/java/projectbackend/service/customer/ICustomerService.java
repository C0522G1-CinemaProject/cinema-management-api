package projectbackend.service.customer;

import projectbackend.dto.customer.ICustomerDto;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.model.customer.Customer;
import projectbackend.model.decentralization.User;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();

    Optional<ICustomerDto> findCustomerByUsername(String username);


    Optional<Customer> findByIdCustomer(Integer id);

    void update(Customer customer, String username);

    void saveCustomerByUser(Customer customer);

    void saveCustomer(Customer customer);

    Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);

    void updatePassword(User user, String newPassword);
}
