package projectbackend.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
=======

>>>>>>> 70bc45875321c3b97279b42424e5c2797a79c900
import projectbackend.dto.customer.ICustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import projectbackend.model.customer.Customer;
import projectbackend.repository.customer.ICustomerRepository;
import projectbackend.service.customer.ICustomerService;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
<<<<<<< HEAD
    private ICustomerRepository icustomerRepository;
=======
    private ICustomerRepository iCustomerRepository;
>>>>>>> 70bc45875321c3b97279b42424e5c2797a79c900

    @Override
    public List<Customer> findAll() {
        return icustomerRepository.findAll();
    }

<<<<<<< HEAD
    @Override
    public void save(Customer customer) {
        icustomerRepository.save(customer);
    }
=======
>>>>>>> 70bc45875321c3b97279b42424e5c2797a79c900

    @Override
    public Optional<ICustomerDto> findCustomerByUsername(String username) {
        return icustomerRepository.findCustomerByUsername(username);
    }


    @Override
<<<<<<< HEAD
    public Optional<Customer> findById(int id) {
        return icustomerRepository.findById(id);
    }


    @Override
    public void saveCustomer(String username, String password, String name, String dayOfBirth, int gender,
                                                     String idCard, String email, String address, String phoneNumber, int customerType) {
         icustomerRepository.saveCustomer(username, password,name,dayOfBirth,gender,idCard,email,address,phoneNumber,customerType );
    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
        return icustomerRepository.searchCustomer(nameSearch, addressSearch, phoneSearch, pageable);
    }


=======
    public Optional<ICustomerDto> findUserByUsername(String username) {
        return customerRepository.findUserByUsername(username);
    }


    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByIdCustomer(Integer id) {
        return iCustomerRepository.findByIdCustomer(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String addressSearch, String phoneSearch, Pageable pageable) {
        return iCustomerRepository.searchCustomer(nameSearch, addressSearch, phoneSearch, pageable);
    }

>>>>>>> 70bc45875321c3b97279b42424e5c2797a79c900
}
