package projectbackend.service.promotion;

import projectbackend.model.promotion.Promotion;

import java.util.Optional;

public interface IPromotionService {
    void save(Promotion promotion);

    Optional<Promotion> findById(int id);

    void update(Promotion promotion);
}
