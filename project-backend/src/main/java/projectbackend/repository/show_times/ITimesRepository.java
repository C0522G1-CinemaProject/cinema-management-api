package projectbackend.repository.show_times;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.movie.ITimeDto;
import projectbackend.model.show_times.Times;

import java.util.List;

public interface ITimesRepository extends JpaRepository<Times, Integer> {

    @Query(value = "select t.start_time as times, t.id as id from times as t where t.start_time " +
            "not in (select t.start_time as times from movie as m " +
            "join show_times as s on s.movie_id = m.id join times as t on s.times_id = t.id " +
            "join room as r on s.room_id = r.id " +
            "where m.is_delete = 0 and s.date_projection = :dateProjection and r.name = :room)",
            nativeQuery = true)
    List<ITimeDto> getTime(@Param("dateProjection") String dateProjection,
                           @Param("room") String room);
}
