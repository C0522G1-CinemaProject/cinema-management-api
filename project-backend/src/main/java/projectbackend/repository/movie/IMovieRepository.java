package projectbackend.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.movie.IMovieStatementDto;
import projectbackend.model.movie.Movie;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {


    /**
     * creator: Phan Phước Đại
     * method use statistical top movie positive
     */
    @Query(value = "select idMovie as id, nameMovie as name, count(id) as countTicket," +
            " sum(money)  as turnover " +
            "from  ticket_statement " +
            "group by idMovie " +
            "order by sum(money) desc limit 100 "
            , nativeQuery = true)
    List<IMovieStatementDto> getMovieTop();


    /**
     * creator: Phan Phước Đại
     * method use statistical top movie positive
     */
    @Query(value = "select idMovie as id, nameMovie as name, count(id) as countTicket, sum(money)  as turnover," +
            "from  ticket_statement " +
            "where dateProjection >=  DATE_SUB(curdate(),INTERVAL :numberMonth MONTH)" +
            "group by idMovie " +
            "order by sum(money) " +
            "desc limit 100 "
            , nativeQuery = true)
    List<IMovieStatementDto> getMovieTop(@Param("numberMonth") int numberMonth);
}
