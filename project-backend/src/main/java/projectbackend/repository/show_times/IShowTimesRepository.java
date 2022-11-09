package projectbackend.repository.show_times;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.booking_ticket.IMovie;
import projectbackend.dto.booking_ticket.IShowDates;
import projectbackend.dto.booking_ticket.IShowTimes;
import projectbackend.model.show_times.ShowTimes;

import java.util.List;

public interface IShowTimesRepository extends JpaRepository<ShowTimes, Integer> {
    @Query(value = "select show_times.date_projection as showDate from show_times " +
            "where show_times.movie_id = :idMovie and show_times.is_delete = 0 group by show_times.date_projection",
            nativeQuery = true)
    List<IShowDates> findAllShowDate(@Param("idMovie") Integer idMovie);

    @Query(value = "select show_times.id as id, times.start_time as times, room.name as room " +
            "from show_times join times on times.id = show_times.times_id join room on room.id = show_times.room_id " +
            "where show_times.date_projection = :showDate and show_times.is_delete = 0;",
            nativeQuery = true)
    List<IShowTimes> findAllShowTimesInDay(@Param("showDate") String showDate);

    @Query(value = "select movie.id as id, movie.name as name from movie " +
            "join show_times on show_times.movie_id = movie.id " +
            "where movie.is_delete = 0 and timestampdiff(day, curdate(), show_times.date_projection) <= 7 " +
            "group by movie.id;", nativeQuery = true)
    List<IMovie> findAllMovie();
}
