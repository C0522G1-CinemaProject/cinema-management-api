package projectbackend.repository.promotion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projectbackend.model.promotion.Promotion;

import java.util.Optional;

public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {

    @Query(value = "select promotion.id, promotion.name, promotion.image, promotion.start_time, promotion.end_time," +
            " promotion.detail, promotion.discount, promotion.is_delete " +
            "from promotion where promotion.name like %:name% and promotion.is_delete = 0 "
            , countQuery = "select  count(*) from promotion where promotion.name like %:name% and promotion.is_delete = 0", nativeQuery = true)
    Page<Promotion> findPromotion(Pageable pageable, String name);

    @Query(value = "select promotion.id, promotion.name, promotion.image, promotion.start_time, promotion.end_time," +
            " promotion.detail, promotion.discount, promotion.is_delete " +
            "from promotion where promotion.id = :id and promotion.is_delete = 0 "
            , countQuery = "select  count(*) from promotion where promotion.id = :id and promotion.is_delete = 0 ", nativeQuery = true)
    Optional<Promotion> findPromotionById(int id);
}
