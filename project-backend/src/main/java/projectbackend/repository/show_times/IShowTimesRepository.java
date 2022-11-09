package projectbackend.repository.show_times;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.show_date.IShowDate;
import projectbackend.model.show_times.ShowTimes;

import java.util.List;

public interface IShowTimesRepository extends JpaRepository<ShowTimes, Integer> {
    @Query(value = "select show_tives.date_projection as showDate from show_tives " +
            "where show_tives.movie_id = :idMovie and show_tives.is_delete = 0 group by show_tives.date_projection",
            nativeQuery = true)
    List<String> findAllShowDateByMovie(@Param("idMovie") Integer idMovie);
}
