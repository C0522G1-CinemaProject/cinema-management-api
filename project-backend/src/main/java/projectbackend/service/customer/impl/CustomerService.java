package projectbackend.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectbackend.dto.customer.ICustomerStatementDto;
import projectbackend.repository.customer.ICustomerRepository;
import projectbackend.service.customer.ICustomerService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;



    /**
     * creator: Phan Phước Đại
     * date:11/11/2022
     * method use statistical top customer positive
     */
    @Override
    public List<ICustomerStatementDto> getCustomerTop(int numberMonth) {
        if (numberMonth == 0) {
            return customerRepository.getCustomerTop();
        }

        return customerRepository.getCustomerTop(numberMonth);
    }

}
