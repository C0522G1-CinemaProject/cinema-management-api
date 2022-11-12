package projectbackend.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.customer.ICustomerDto;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.model.customer.Customer;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();

    Optional<ICustomerDto> findCustomerByUsername(String username);

<<<<<<< HEAD
    Optional<Customer> findById(int id);


        void saveCustomer(String username, String password, String name, String dayOfBirth, int gender,
                                                  String idCard, String email, String address, String phoneNumber, int customerType);


    Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);
=======
    Optional<ICustomerDto> findUserByUsername(String username);
>>>>>>> 70bc45875321c3b97279b42424e5c2797a79c900

    void save(Customer customer);

    Optional<Customer> findByIdCustomer(Integer id);

    void update(Customer customer);

    Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable);

}
