package projectbackend.repository.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.movie.IMovieStatementDto;
import projectbackend.model.movie.Movie;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select movie.id as id, movie.name as name, count(ticket.id) as tickets, sum(seat_type.price) as turnover " +
            "from movie join show_times on movie.id = show_times.movie_id  " +
            "join seat_detail on show_times.id = seat_detail.show_time_id " +
            "join ticket on ticket.seat_detail_id = seat_detail.id " +
            "join seat_room on seat_room.id = seat_detail.seat_room_id " +
            "join seat_type on seat_type.id = seat_room.seat_type_id " +
            "where show_times.date_projection < curdate() and ticket.status_ticket = 3 " +
            "group by movie.id " +
            "order by sum(seat_type.price)",
            countQuery = "select count(movie.id) " +
                    "from movie join show_times on movie.id = show_times.movie_id  " +
                    "join seat_detail on show_times.id = seat_detail.show_time_id " +
                    "join ticket on ticket.seat_detail_id = seat_detail.id " +
                    "join seat_room on seat_room.id = seat_detail.seat_room_id " +
                    "join seat_type on seat_type.id = seat_room.seat_type_id " +
                    "where show_times.dateProjection< curdate() and ticket.status_ticket = 3 " +
                    "group by movie.id " +
                    "order by sum(seat_type.price)", nativeQuery = true)
    Page<IMovieStatementDto> getMovieTop(Pageable pageable);


    @Query(value = "select movie.id as id, movie.name as name, count(ticket.id) as tickets, sum(seat_type.price) as turnover " +
            "from movie join show_times on movie.id = show_times.movie_id  " +
            "join seat_detail on show_times.id = seat_detail.show_time_id " +
            "join ticket on ticket.seat_detail_id = seat_detail.id " +
            "join seat_room on seat_room.id = seat_detail.seat_room_id " +
            "join seat_type on seat_type.id = seat_room.seat_type_id " +
            "where show_times.date_projection < curdate() and ticket.status_ticket = 3 " +
            "group by movie.id " +
            "order by sum(seat_type.price) " +
            "limit 100 "
           , nativeQuery = true)
    List<IMovieStatementDto> getMovieTop( );

    @Query(value = "select movie.id as id, movie.name as name, count(ticket.id) as tickets, sum(seat_type.price) as turnover " +
            "from movie join show_times on movie.id = show_times.movie_id  " +
            "   join seat_detail on show_times.id = seat_detail.show_time_id " +
            "   join ticket on ticket.seat_detail_id = seat_detail.id " +
            "   join seat_room on seat_room.id = seat_detail.seat_room_id " +
            "   join seat_type on seat_type.id = seat_room.seat_type_id " +
            "where show_times.date_projection < curdate() " +
            "   and show_times.date_projection >=  DATE_SUB(curdate(),INTERVAL :numberMonth MONTH) " +
            "   and ticket.status_ticket = 1 " +
            "group by movie.id " +
            "order by sum(seat_type.price) "+
            "limit 100 "
            , nativeQuery = true)
    List<IMovieStatementDto> getMovieTop(@Param("numberMonth") int numberMonth);
}
