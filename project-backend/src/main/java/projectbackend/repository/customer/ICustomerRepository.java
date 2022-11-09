package projectbackend.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.model.customer.Customer;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query
}
