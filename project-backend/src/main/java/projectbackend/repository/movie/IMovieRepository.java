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
import projectbackend.dto.movie.IMovieDtoHome;
import projectbackend.model.movie.Movie;

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
    //6.5.1.1. Danh Sách Phim – Xem danh sách phim
    //6.5.1.3. Danh sách Phim – Tìm kiếm Phim
    @Query(value = "select movie.id as id, movie.name as name,movie.image as image,show_times.date_projection as showTimeDate" +
            ",movie.film_time as filmTime from movie " +
            "join show_times on movie.id = show_times.movie_id " +
            "where (day(date_projection) >= (day(curdate())+3) " +
            "    and month(date_projection)  >=  month(curdate()) " +
            "    and year(date_projection) = year(curdate())" +
            "    and name like %:keywordName% " +
            "    and movie.is_delete=0) " +
            "or" +
            "(day(date_projection) < (day(curdate())+3) " +
            "    and month(date_projection)  >  month(curdate())" +
            "    and year(date_projection) = year(curdate())" +
            "    and name like %:keywordName% " +
            "    and movie.is_delete=0) " +
            "or" +
            "(day(date_projection) < (day(curdate())+3) " +
            "    and month(date_projection)  <  month(curdate())" +
            "    and year(date_projection) > year(curdate())" +
            "    and name like %:keywordName% " +
            "    and movie.is_delete=0)" +
            "order by show_times.date_projection " ,
            countQuery = "select count(*) " +
                    "from movie " +
                    "join show_times on movie.id = show_times.movie_id " +
                    "where (day(date_projection) >= (day(curdate())+3) " +
                    "    and month(date_projection)  >=  month(curdate()) " +
                    "    and year(date_projection) = year(curdate())" +
                    "    and name like %:keywordName% " +
                    "    and movie.is_delete=0) " +
                    "or" +
                    "(day(date_projection) < (day(curdate())+3) " +
                    "    and month(date_projection)  >  month(curdate())" +
                    "    and year(date_projection) = year(curdate())" +
                    "    and name like %:keywordName% " +
                    "    and movie.is_delete=0) " +
                    "or" +
                    "(day(date_projection) < (day(curdate())+3) " +
                    "    and month(date_projection)  <  month(curdate())" +
                    "    and year(date_projection) > year(curdate())" +
                    "    and name like %:keywordName% " +
                    "    and movie.is_delete=0) " +
                    "order by show_times.date_projection ", nativeQuery = true)
    Page<IMovieDtoHome> findAllHome(@Param("keywordName") String name, Pageable pageable);

    @Query(value = "select movie.id as id, movie.name as name,movie.image as image,show_times.date_projection as showTimeDate" +
            ",movie.film_time as filmTime from movie " +
            "join show_times on movie.id = show_times.movie_id " +
            "where (day(date_projection) >= (day(curdate())+10) " +
            "    and month(date_projection)  >=  month(curdate()) " +
            "    and year(date_projection) = year(curdate())" +
            "    and name like %:keywordName% " +
            "    and movie.is_delete=0) " +
            "or" +
            "(day(date_projection) < (day(curdate())+10) " +
            "    and month(date_projection)  >  month(curdate())" +
            "    and year(date_projection) = year(curdate())" +
            "    and name like %:keywordName% " +
            "    and movie.is_delete=0) " +
            "or" +
            "(day(date_projection) < (day(curdate())+10) " +
            "    and month(date_projection)  <  month(curdate())" +
            "    and year(date_projection) > year(curdate())" +
            "    and name like %:keywordName% " +
            "    and movie.is_delete=0) " +
            "order by show_times.date_projection desc " ,
            countQuery = "select count(*) " +
                    "from movie " +
                    "join show_times on movie.id = show_times.movie_id " +
                    "where (day(date_projection) >= (day(curdate())+10) " +
                    "    and month(date_projection)  >=  month(curdate()) " +
                    "    and year(date_projection) = year(curdate())" +
                    "    and name like %:keywordName% " +
                    "    and movie.is_delete=0) " +
                    "or" +
                    "(day(date_projection) < (day(curdate())+10) " +
                    "    and month(date_projection)  >  month(curdate())" +
                    "    and year(date_projection) = year(curdate())" +
                    "    and name like %:keywordName% " +
                    "    and movie.is_delete=0) " +
                    "or" +
                    "(day(date_projection) < (day(curdate())+10) " +
                    "    and month(date_projection)  <  month(curdate())" +
                    "    and year(date_projection) > year(curdate())" +
                    "    and name like %:keywordName% " +
                    "    and movie.is_delete=0) " +
                    "order by show_times.date_projection desc ", nativeQuery = true)
    Page<IMovieDtoHome> findAllPremiereSoon(@Param("keywordName") String name, Pageable pageable);


    //TriHM
    @Query(value = "SELECT id, name, start_day as startDay, film_studio as filmStudio, film_time as filmTime, version " +
            "FROM movie  WHERE name" +
            " LIKE %:keyword% AND is_delete = false",
            countQuery =  "SELECT count(id) " +
                    "FROM movie  WHERE name" +
                    " LIKE %:keyword% AND is_delete = false",nativeQuery = true)
    Page<IMovieDto> findAllMovie(Pageable pageable, @Param("keyword") String name);

    //TriHM
    @Modifying
    @Query(value = "update movie set is_delete = true where id=:idDelete", nativeQuery = true)
    void deleteById(@Param("idDelete") int idDelete);


    //QuyetND
    @Query(value = "select m.name, m.image, m.start_day as startDay, m.end_day as endDay, m.director, m.film_time as filmTime," +
            " m.trailer, m.movie_type_id as movieType, m.content, m.film_studio as filmStudio, m.actor, m.version " +
            "from movie as m " +
            "join show_times as s on s.movie_id = m.id" +
            "where m.is_delete = 0 and m.id = :id", nativeQuery = true)
    IMovieDto findMovieById(@Param("id") Integer id);

}
