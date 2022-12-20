package shopfoodbe.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopfoodbe.dto.FoodDto;
import shopfoodbe.dto.ICartDto;
import shopfoodbe.dto.IFoodDto;
import shopfoodbe.dto.ITotalDto;
import shopfoodbe.model.Food;
import shopfoodbe.service.ICartService;
import shopfoodbe.service.IFoodService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/food")
public class ProductController {
    @Autowired
    private IFoodService foodService;
    @Autowired
    private ICartService cartService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<IFoodDto>> getAllFood(@RequestParam(value = "name", defaultValue = "") String name,
                                                     Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findAllFood(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }

    @GetMapping(value = "/vegetable")
    public ResponseEntity<Page<IFoodDto>> getVegetable(@RequestParam(value = "name", defaultValue = "") String name,
                                                       Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findVegetable(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }

    @GetMapping(value = "/meat")
    public ResponseEntity<Page<IFoodDto>> getAllMeat(@RequestParam(value = "name", defaultValue = "") String name,
                                                     Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findAllMeat(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }

    @GetMapping(value = "/fruit")
    public ResponseEntity<Page<IFoodDto>> getAllFruit(@RequestParam(value = "name", defaultValue = "") String name,
                                                      Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findAllFruit(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }

    @GetMapping(value = "/other")
    public ResponseEntity<Page<IFoodDto>> getOther(@RequestParam(value = "name", defaultValue = "") String name,
                                                   Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findOther(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDto> getEmployee(@PathVariable int id) {
        Optional<Food> food = foodService.findFoodById(id);
        if (!food.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        FoodDto foodDto = new FoodDto();
        BeanUtils.copyProperties(food.get(), foodDto);
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }


    @GetMapping("/cart")
    public ResponseEntity<List<ICartDto>> getCartList() {
        List<ICartDto> cartDtos = cartService.getCartList();
        if (cartDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cartDtos, HttpStatus.OK);
    }

    @GetMapping("/total-bill")
    public ResponseEntity<ITotalDto> getTotalBill() {
        ITotalDto totalBill = cartService.getTotalBill();
        if (totalBill == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(totalBill, HttpStatus.OK);
    }

    @PostMapping("/cart-update")
    public ResponseEntity<?> updateCart(@RequestParam Integer id) {
        ICartDto cartDto = cartService.findById(id);
        if (cartDto == null) {
            cartService.insertToCart(id);
        } else {
            cartService.updateCart(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/qty-update")
    public ResponseEntity<?> updateQty(@RequestParam Integer id,
                                       @RequestParam Integer qty) {
        if (qty == 0) {
            cartService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        cartService.updateQty(id, qty);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/del-product")
    public ResponseEntity<?> deleteProduct(@RequestParam Integer id) {

        cartService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
