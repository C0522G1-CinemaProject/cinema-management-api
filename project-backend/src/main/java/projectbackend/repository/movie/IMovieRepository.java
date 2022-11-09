package projectbackend.repository.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.model.movie.Movie;

import javax.transaction.Transactional;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT m.name, m.startDay, m.filmStudio, m.filmTime,m.version FROM Movie as m WHERE m.name" +
            " LIKE %:keyword% AND m.isDelete = false ")
    Page<Movie> findAllMovie(Pageable pageable,@Param("keyword") String name);

    @Transactional
    @Modifying
    @Query(value = "update Movie as m set m.isDelete = true where m.id = :idDelete", nativeQuery = true)
    void deleteById(@Param("idDelete") int idDelete);
}
