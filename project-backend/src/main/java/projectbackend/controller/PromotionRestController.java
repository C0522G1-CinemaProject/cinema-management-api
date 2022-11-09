package projectbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectbackend.model.promotion.Promotion;
import projectbackend.service.promotion.IPromotionService;

@RestController
@RequestMapping("/api/promotion")
@CrossOrigin
public class PromotionRestController {

    @Autowired
    private IPromotionService iPromotionService;

    @GetMapping("/list")
    public ResponseEntity<Page<Promotion>> showPromotion(@RequestParam(value = "name", defaultValue = "") String name,
                                                         @PageableDefault(value = 4)Pageable pageable) {
        Page<Promotion> promotions = iPromotionService.findAll(pageable, name);
        if (promotions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(promotions, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> findById(@PathVariable int id) {
        Promotion promotion = iPromotionService.findById(id).orElse(null);
        if (promotion == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(promotion, HttpStatus.OK);
        }
    }

}
