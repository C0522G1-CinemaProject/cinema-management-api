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
    public void save(Customer customer) {
        icustomerRepository.save(customer);
    }

    @Override
    public Optional<ICustomerDto> findCustomerByUsername(String username) {
        return icustomerRepository.findCustomerByUsername(username);
    }


    @Override
    public Optional<Customer> findById(int id) {
        return icustomerRepository.findById(id);
    }


    @Override
    public void saveCustomer(Customer customer) {
        icustomerRepository.saveCustomer(customer);
    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
        return icustomerRepository.searchCustomer(nameSearch, addressSearch, phoneSearch, pageable);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newPassword);
        System.out.println(encodedPassword);
//        customer.setPassword(encodedPassword);
//        icustomerRepository.saveNewPassword(encodedPassword,customer.getUsername());
    }
}
