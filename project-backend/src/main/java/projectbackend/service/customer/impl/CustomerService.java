package projectbackend.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projectbackend.dto.customer.ICustomerDto;
import projectbackend.model.customer.Customer;
import projectbackend.model.decentralization.User;
import projectbackend.repository.customer.ICustomerRepository;
import projectbackend.service.customer.ICustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {


    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }


    @Override
    public Optional<ICustomerDto> findCustomerByUsername(String username) {
        return iCustomerRepository.findCustomerByUsername(username);
    }


    @Override
    public void saveCustomer(Customer customer) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        iCustomerRepository.setPassword(customer.getUser().getUsername(),
                passwordEncoder.encode(customer.getUser().getPassword()));
        iCustomerRepository.save(customer);
    }


    @Override
    public Optional<Customer> findByIdCustomer(Integer id) {
        return iCustomerRepository.findByIdCustomer(id);
    }

    @Override
    public void update(Customer customer, String username) {
        iCustomerRepository.updateCustomer(customer, username);
    }

    @Override
    public void saveCustomerByUser(Customer customer) {
        iCustomerRepository.saveCustomer(customer);
    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
        return iCustomerRepository.searchCustomer(nameSearch, addressSearch, phoneSearch, pageable);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        System.out.println(encodedPassword);
//        user.setPassword(encodedPassword);
//        icustomerRepository.saveNewPassword(encodedPassword, user.getUsername());

    }
}
