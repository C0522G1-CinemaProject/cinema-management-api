package projectbackend.repository.promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projectbackend.dto.promotion.IPromotionDto;
import projectbackend.model.promotion.Promotion;

public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {
    @Query(value = "select name,image, start_time as startTime, end_time as endTime, detail, discount " +
            "from promotion " +
            "where id =:keyId and is_delete=0", nativeQuery = true)
    IPromotionDto findPromotionById (@Param("keyId") Integer id);


}
