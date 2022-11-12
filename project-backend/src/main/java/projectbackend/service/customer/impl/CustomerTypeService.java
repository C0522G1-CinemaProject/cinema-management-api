package projectbackend.service.customer.impl;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.customer.CustomerType;
import projectbackend.repository.customer.ICustomerTypeRepository;
import projectbackend.service.customer.ICustomerTypeService;

=======
import projectbackend.service.customer.ICustomerTypeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.model.customer.CustomerType;
import projectbackend.repository.customer.ICustomerTypeRepository;
import projectbackend.service.customer.ICustomerTypeService;

>>>>>>> 70bc45875321c3b97279b42424e5c2797a79c900
import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
<<<<<<< HEAD
    private ICustomerTypeRepository icustomerTypeRepository;

    @Override
    public List<CustomerType> findAllCustomerType() {
        return icustomerTypeRepository.findAll();
=======
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
>>>>>>> 70bc45875321c3b97279b42424e5c2797a79c900
    }
}
