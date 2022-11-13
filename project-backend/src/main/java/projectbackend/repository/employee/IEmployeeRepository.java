package projectbackend.repository.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.model.employee.Employee;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where name like concat('%', :searchVal, '%') and is_delete = 0 ", nativeQuery = true,
            countQuery = "select count(*) from (select * from employee where name like concat('%', :searchVal, '%') and is_delete = 0 ) employee")
    Page<Employee> findEmployeeByNameContaining(Pageable pageable, @Param("searchVal") String search);


    @Query(value = "select e.id, e.address, e.day_of_birth, e.email, e.gender, " +
            " e.id_card,  e.image , e.name, e.phone_number, is_delete, username "
            + " from employee as e where id =:id and is_delete = 0 ", nativeQuery = true)
//            + " join `user` as u on e.username = u.username "
//            + " where e.is_delete = 0 and e.id = :keyId ", nativeQuery = true)
    Optional<Employee> findEmployeeById(@Param("id") Integer id);


    @Modifying
    @Query(value = "call sp_insert_employee( :#{#e.address}, :#{#e.dayOfBirth}, :#{#e.email}," +
            " :#{#e.gender}, :#{#e.idCard}, :#{#e.image}, :#{#e.name}, :#{#e.phoneNumber}, " +
            " :#{#e.user.username}, :#{#e.user.password})", nativeQuery = true)
    void saveEmployee(@Param("e") Employee employee);

    @Modifying
    @Query(value = "UPDATE employee SET address = :#{#u.address}," +
            "day_of_birth = :#{#u.dayOfBirth}, " +
            "email = :#{#u.email}," +
            " gender = :#{#u.gender}, " +
            "id_card = :#{#u.idCard},  " +
            "image = :#{#u.image}, " +
            "name = :#{#u.name}, " +
            "phone_number = :#{#u.phoneNumber}, " +
            " is_delete = 0 " +
            "WHERE id = :#{#u.id}", nativeQuery = true)
    void updateEmployee(@Param("u") Employee employee);

    /*@Modifying
    @Query(value = "insert  into employee(address,day_of_birth,email,gender,id_card,image,name,phone_number,username) " +
            " values ( :#{#e.address}, :#{#e.dayOfBirth}, :#{#e.email}, " +
            "            :#{#e.gender}, :#{#e.idCard}, :#{#e.image}, :#{#e.name}, :#{#e.phoneNumber}, :#{#e.user.username} )",
            nativeQuery = true)
    void saveEmployee(@Param("e") Employee employee);*/

//    @Query(value = "select e.id, e.address, e.day_of_birth as dayOfBirth, e.email, e.gender, " +
//            " e.id_card as idCard,  e.image as image, e.name, e.phone_number as phoneNumber "
//            + " from employee as e where id =:id and is_delete = 0 ", nativeQuery = true)
////            + " join `user` as u on e.username = u.username "
////            + " where e.is_delete = 0 and e.id = :keyId ", nativeQuery = true)
//    Optional<Employee> findEmployeeById(@Param("id") Integer id);

}

