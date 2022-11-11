package projectbackend.repository.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.model.employee.Employee;

import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where name like concat('%', :searchVal, '%') and is_delete = 0 ", nativeQuery = true,
            countQuery = "select count(*) from (select * from employee where name like concat('%', :searchVal, '%') and is_delete = 0 ) employee")
    Page<Employee> findEmployeeByNameContaining(Pageable pageable, @Param("searchVal") String search);

//    @Query(value = "select e.name as employeeName, e.gender as employeeGender , e.email as employeeEmail, e.address as employeeAddress, e.phone_number as employeePhoneNumber, " +
//            " e.id_card as employeeIdCard, e.day_of_birth as employeeDayOfBirth, e.image as employeeImage, u.username as userName , u.password as pass "
//    + "from employee as e "
//    + "join `user` as u on e.username = u.username "
//    + "where e.is_delete = 0 and e.id = :keyId ", nativeQuery = true)
//    IEmployeeDto findById(@Param("keyId") Integer id);

    @Query(value = "select e.id, e.name, e.gender , e.email, e.address , e.phone_number, " +
            " e.id_card , e.day_of_birth , e.image , e.username , u.password , e.is_delete  "
            + "from employee as e "
            + "join user as u on e.username = u.username "
            + "where e.is_delete = 0 and e.id = :keyId ", nativeQuery = true)
    Optional<Employee> findEmployeeById(@Param("keyId") Integer id);
}

