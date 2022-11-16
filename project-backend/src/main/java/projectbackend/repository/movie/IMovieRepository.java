package projectbackend.repository.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.model.movie.Movie;
import projectbackend.model.show_times.ShowTimes;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    //TruongNT
    @Query(value = "SELECT movie.start_day AS startDay, " +
            "movie.name AS name, " +
            "movie.image AS image, " +
            "movie.director AS director, " +
            "movie.end_day AS endDay, " +
            "movie.film_time AS filmTime," +
            "movie.trailer AS trailer, " +
            "movie.content AS content, " +
            "movie.film_studio AS filmStudio, " +
            "movie.actor AS actor, " +
            "movie.version AS version ," +
            "movie_type.name AS movieType " +
            "            FROM movie " +
            "INNER JOIN movie_type ON movie.movie_type_id = movie_type.id" +
            "             WHERE movie.id = :id", nativeQuery = true)
    Optional<IMovieDto> movieDetail(@Param("id") Integer id);


    //NamHV
    @Query(value = "select movie.name as name,movie.image as image,show_times.date_projection as showTimeDate" +
            ",movie.film_time as filmTime from movie " +
            "join show_times on movie.id = show_times.movie_id " +
            "where ((day(show_times.date_projection)+3) >= day(curdate()) " +
            "    and  month(show_times.date_projection) >= month(curdate())) " +
            "or" +
            "((day(show_times.date_projection)+3) < day(curdate()) " +
            "    and  month(show_times.date_projection) > month(curdate()))" +
            "AND (year(show_times.date_projection) = year(curdate())) " +
            "and name like %:keywordName% " +
            "and movie.is_delete=0",
            countQuery = "select count(*) " +
                    "from movie " +
                    "join show_times on movie.id = show_times.movie_id " +
                    "where ((day(show_times.date_projection)+3) >= day(curdate()) " +
                    "    and  month(show_times.date_projection) >= month(curdate())) " +
                    "or" +
                    "((day(show_times.date_projection)+3) < day(curdate()) " +
                    "    and  month(show_times.date_projection) > month(curdate()))" +
                    "AND (year(show_times.date_projection) = year(curdate())) " +
                    "and name like %:keywordName% " +
                    "and movie.is_delete=0", nativeQuery = true)
    Page<IMovieDto> findAllHome(@Param("keywordName") String name, Pageable pageable);

    //TriHM
    @Query(value = "SELECT id, name, start_day as startDay, film_studio as filmStudio, film_time as filmTime, version FROM movie  WHERE name" +
            " LIKE %:keyword% AND is_delete = false", nativeQuery = true)
    Page<IMovieDto> findAllMovie(Pageable pageable, @Param("keyword") String name);

    //TriHM
    @Modifying
    @Query(value = "update movie set is_delete = true where id=:idDelete", nativeQuery = true)
    void deleteById(@Param("idDelete") int idDelete);

    @Query(value = "select s.date_projection as dateProjection, t.start_time as startTime, t.id as timeId , r.name as roomName, r.id as roomId " +
            "from show_times as s " +
            "join movie as m on m.id = s.movie_id " +
            "join times as t on s.times_id = t.id " +
            "join room as r on s.room_id = r.id " +
            "where s.is_delete = 0 and m.id = :id", nativeQuery = true)
    List<ShowTimes> findShowTimeById(@Param("id") Integer id);

    //QuyetND
    @Query(value = "select * " +
            "from movie as m join show_times as s on s.movie_id = m.id where m.is_delete = 0 and m.id = :id " +
            "group by m.id", nativeQuery = true)
    Movie findMovieById(@Param("id") Integer id);

}
