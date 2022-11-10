package projectbackend.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.promotion.IPromotionDto;
import projectbackend.dto.promotion.PromotionDto;
import projectbackend.model.promotion.Promotion;
import projectbackend.service.promotion.IPromotionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/promotion")
public class PromotionRestController {
    @Autowired
    private IPromotionService iPromotionService;

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> createPromotion(@RequestBody @Valid PromotionDto promotionDto,
                                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.BAD_REQUEST);
        }
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDto, promotion);
        iPromotionService.savePromotion(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    @PatchMapping("/edit/{id}")
//    public ResponseEntity<Promotion> editPromotion(@RequestBody PromotionDto promotionDto,
//                                                @PathVariable Integer id) {
//        Promotion promotion = iPromotionService.findById(id).get();
//        BeanUtils.copyProperties(promotionDto, promotion);
//        iPromotionService.updatePromotion(promotion);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editPromotion(@RequestBody @Valid PromotionDto promotionDto,
                                           BindingResult bindingResult,
                                           Integer id
    ) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(),
                    HttpStatus.BAD_REQUEST);
        }

        Promotion promotion = new Promotion();
        promotion.setId(id);
        BeanUtils.copyProperties(promotionDto, promotion);
        iPromotionService.updatePromotion(promotion);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IPromotionDto> editPromotion(@PathVariable Integer id) {
        IPromotionDto iPromotionDto = iPromotionService.findPromotionById(id);
        return new ResponseEntity<>(iPromotionDto, HttpStatus.OK);
    }
}
