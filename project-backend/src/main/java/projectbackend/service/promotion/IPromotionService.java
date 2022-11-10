package projectbackend.service.promotion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import projectbackend.dto.promotion.IPromotionDto;
import projectbackend.model.promotion.Promotion;

import java.util.List;
import java.util.Optional;

public interface IPromotionService {
//    Page<Promotion> findAll(Pageable pageable,String name);

    void savePromotion(Promotion promotion);

    Optional<Promotion> findById(Integer id);

    void updatePromotion(Promotion promotion);
    IPromotionDto findPromotionById(Integer id);
}
