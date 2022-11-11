package projectbackend.repository.show_times;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.movie.IShowTimeDto;
import projectbackend.model.show_times.ShowTimes;

import java.util.List;

public interface IShowTimesRepository extends JpaRepository<ShowTimes, Integer> {

    @Query(value = "select t.start_time as times, r.name as name, s.date_projection as dateProjection from show_times as s " +
            "join movie as m on s.movie_id = m.id " +
            "join times as t on s.times_id = m.id " +
            "join room as r on s.room_id = r.id " +
            "where s.is_delete = 0 and m.id = :id)",
            nativeQuery = true)
    List<IShowTimeDto> getShowTime(@Param("id") Integer id);
}
