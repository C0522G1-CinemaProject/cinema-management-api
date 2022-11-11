package projectbackend.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import projectbackend.dto.promotion.IPromotionDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import projectbackend.dto.promotion.PromotionDto;
import projectbackend.model.promotion.Promotion;
import projectbackend.service.promotion.IPromotionService;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/promotion")
@CrossOrigin("*")
public class PromotionRestController {
    @Autowired
    private IPromotionService iPromotionService;

    @PostMapping("/save")
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
   

    @GetMapping("/detail/{id}")
    public ResponseEntity<Promotion> getInfo(@PathVariable int id) {
        Optional<Promotion> promotion = iPromotionService.findById(id);
        if (promotion.isPresent()) {
            return new ResponseEntity<>(promotion.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Promotion> delete(@PathVariable int id) {
        Optional<Promotion> promotion = iPromotionService.findById(id);
        if (promotion.isPresent()) {
            iPromotionService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    

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

}
