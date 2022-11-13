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
    private ICustomerRepository icustomerRepository;


    @Override
    public List<Customer> findAll() {
        return icustomerRepository.findAll();
    }

    @Override
    public Optional<ICustomerDto> findCustomerByUsername(String username) {
        return icustomerRepository.findCustomerByUsername(username);
    }


    @Override
    public Optional<Customer> findByIdCustomer(Integer id) {
        return Optional.empty();
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void saveCustomer(Customer customer) {
        icustomerRepository.saveCustomer(customer);
    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
        return null;
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedPassword);
        icustomerRepository.saveNewPassword(encodedPassword, user.getUsername());

    }
}
