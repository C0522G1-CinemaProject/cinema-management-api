package projectbackend.repository.show_times;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.show_date.IShowDates;
import projectbackend.dto.show_date.IShowTimes;
import projectbackend.model.show_times.ShowTimes;

import java.util.List;

public interface IShowTimesRepository extends JpaRepository<ShowTimes, Integer> {
    @Query(value = "select show_times.date_projection as showDate from show_times " +
            "where show_times.movie_id = :idMovie and show_times.is_delete = 0 group by show_times.date_projection",
            nativeQuery = true)
    List<IShowDates> findAllShowDateByMovie(@Param("idMovie") Integer idMovie);

    @Query(value = "select show_times.id as id, times.start_time as times, room.name as room from show_times " +
            "join times on times.id = show_times.")
    List<IShowTimes> findAllShowTimeByShowDate(@Param("showDate") String showDate);
}
