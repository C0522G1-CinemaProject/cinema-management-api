package projectbackend.repository.promotion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import projectbackend.model.promotion.Promotion;

@Transactional
public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {

    @Modifying
    @Query(value = "update Promotion set is_delete = 1 where id =:id", nativeQuery = true)
    void deletePromotion(int id);

    @Query(value = "select * from Promotion  where Promotion.name like %:name% and   is_delete = 0  ", nativeQuery = true)
    Page<Promotion> findAllPromotion(Pageable pageable, String name);
}
