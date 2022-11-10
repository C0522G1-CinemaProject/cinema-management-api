package projectbackend.repository.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.model.employee.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where name like concat('%', :searchVal, '%') and is_delete = 0 ", nativeQuery = true,
    countQuery = "select count(*) from (select * from employee where name like concat('%', :searchVal, '%') and is_delete = 0 ) employee")
    Page<Employee> findEmployeeByNameContaining(Pageable pageable, @Param("searchVal") String search);
}
