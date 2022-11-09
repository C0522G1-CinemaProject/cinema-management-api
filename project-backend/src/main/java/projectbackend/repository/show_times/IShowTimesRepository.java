package projectbackend.repository.show_times;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectbackend.model.show_times.ShowTimes;

import java.util.List;

public interface IShowTimesRepository extends JpaRepository<ShowTimes, Integer> {

    @Query(value = "select date_projection from show_times where is_delete = 0", nativeQuery = true)
    List<ShowTimes> findAll();
}
