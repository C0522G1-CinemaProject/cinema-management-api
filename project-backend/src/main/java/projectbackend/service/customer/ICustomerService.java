package projectbackend.service.customer;

import org.springframework.data.repository.query.Param;
import projectbackend.model.customer.Customer;

public interface ICustomerService {
    Customer findByUsername(String username);
}
