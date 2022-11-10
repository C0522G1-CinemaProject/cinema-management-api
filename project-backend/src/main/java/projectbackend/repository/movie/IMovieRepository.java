package projectbackend.repository.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.movie.IMovieDto;
import projectbackend.model.movie.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {


    @Query(value = "select  movie.name as movieName,movie.image as movieImage,show_times.date_projection as showTimeDate" +
            ",movie.film_time as movieFilmTime from movie " +
            "join show_times on movie.id = show_times.movie_id " +
            "where ((day(show_times.date_projection)+3) >= day(curdate())) " +
            "and  (month(show_times.date_projection) >= month(curdate())) " +
            "AND (year(show_times.date_projection) = year(curdate())) " +
            "and name like %:keywordName% " +
            "and movie.is_delete=0",
            countQuery = "select count(*) " +
                    "from movie " +
                    "join show_times on movie.id = show_times.movie_id " +
                    "where ((DAY(show_times.date_projection)+3) >= day(curdate())) " +
                    "and  (month(show_times.date_projection) >= month(curdate())) " +
                    "AND (year(show_times.date_projection) = year(curdate())) " +
                    "and name like %:keywordName% " +
                    "and movie.is_delete=0",nativeQuery = true)
    Page<IMovieDto> findAllMovie(@Param("keywordName") String name, Pageable pageable);
}
