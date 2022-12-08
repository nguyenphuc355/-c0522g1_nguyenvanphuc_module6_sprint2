package shopfoodbe.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopfoodbe.dto.FoodDto;
import shopfoodbe.dto.IFoodDto;
import shopfoodbe.model.Food;
import shopfoodbe.service.IFoodService;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/food")
public class ProductController {
    @Autowired
    private IFoodService foodService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<IFoodDto>> getAllFood(@RequestParam(value = "name", defaultValue = "") String name,
                                                     Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findAllFood(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto,HttpStatus.OK);
    }
    @GetMapping(value = "/vegetable")
    public ResponseEntity<Page<IFoodDto>> getVegetable(@RequestParam(value = "name", defaultValue = "") String name,
                                                     Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findVegetable(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto,HttpStatus.OK);
    }
    @GetMapping(value = "/meat")
    public ResponseEntity<Page<IFoodDto>> getAllMeat(@RequestParam(value = "name", defaultValue = "") String name,
                                                     Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findAllMeat(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto,HttpStatus.OK);
    }
    @GetMapping(value = "/fruit")
    public ResponseEntity<Page<IFoodDto>> getAllFruit(@RequestParam(value = "name", defaultValue = "") String name,
                                                     Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findAllFruit(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto,HttpStatus.OK);
    }
    @GetMapping(value = "/other")
    public ResponseEntity<Page<IFoodDto>> getOther(@RequestParam(value = "name", defaultValue = "") String name,
                                                     Pageable pageable) {
        Page<IFoodDto> foodDto = foodService.findOther(name, pageable);
        if (foodDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodDto,HttpStatus.OK);
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

}
