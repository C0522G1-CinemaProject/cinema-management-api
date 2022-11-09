package projectbackend.repository.show_times;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectbackend.model.show_times.Times;

import java.util.List;

public interface ITimesRepository extends JpaRepository<Times, Integer> {

    @Query(value = "select start_time from times where is_delete = 0", nativeQuery = true)
    List<Times> findAll();
}
