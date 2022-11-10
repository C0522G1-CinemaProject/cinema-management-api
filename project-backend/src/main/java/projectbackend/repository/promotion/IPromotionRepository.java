package projectbackend.repository.promotion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.model.promotion.Promotion;

import java.util.Optional;

@Transactional
public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {

    @Modifying
    @Query(value = "update Promotion set is_delete = 1 where id =:id", nativeQuery = true)
    void deletePromotion(int id);

    @Query(value = "SELECT promotion.name , promotion.detail, promotion.start_time, promotion.end_time, promotion.discount, promotion.id, promotion.image, promotion.is_delete " +
            "FROM promotion WHERE promotion.name LIKE %:name% AND promotion.is_delete = 0"
            , countQuery = "SELECT count(*) FROM promotion WHERE promotion.name LIKE %:name% AND promotion.is_delete = 0 "
            , nativeQuery = true)
    Page<Promotion> findAllPromotion(Pageable pageable, String name);

    @Query(value = "SELECT promotion.name , promotion.detail, promotion.start_time, promotion.end_time, promotion.discount, promotion.id, promotion.image, promotion.is_delete " +
            "FROM promotion WHERE promotion.id = :id AND promotion.is_delete = 0"
            , countQuery = "SELECT count(*) FROM promotion WHERE promotion.id = :id AND promotion.is_delete = 0 "
            , nativeQuery = true)
    Optional<Promotion> findById(int id);

    @Modifying
    @Query(value = "insert into Promotion(name ,detail, start_time, end_time, discount, image, is_delete) " +
            "VALUES (:#{#promotion.name} , :#{#promotion.detail}, :#{#promotion.startTime}, :#{#promotion.endTime}, :#{#promotion.discount}, :#{#promotion.image}, 0 )", nativeQuery = true)
    void savePromotion(@Param("promotion") Promotion promotion);
}
