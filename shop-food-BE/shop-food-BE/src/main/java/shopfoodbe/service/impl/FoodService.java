package shopfoodbe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shopfoodbe.dto.IFoodDto;
import shopfoodbe.model.Food;
import shopfoodbe.repository.IFoodRepository;
import shopfoodbe.service.IFoodService;

import java.util.Optional;

@Service
public class FoodService implements IFoodService {
    @Autowired
    protected IFoodRepository foodRepository;

    @Override
    public Page<IFoodDto> findAllFood(String nameSearch, Pageable pageable) {
        return foodRepository.findAllFood(nameSearch, pageable);
    }

    @Override
    public Optional<Food> findFoodById(int id) {
        return foodRepository.findFoodById(id);
    }

    @Override
    public Page<IFoodDto> findVegetable(String name, Pageable pageable) {
        return foodRepository.findVegetable(name, pageable);
    }

    @Override
    public Page<IFoodDto> findAllMeat(String name, Pageable pageable) {
        return foodRepository.findAllMeat(name, pageable);
    }

    @Override
    public Page<IFoodDto> findAllFruit(String name, Pageable pageable) {
        return foodRepository.findAllFruit(name, pageable);
    }

    @Override
    public Page<IFoodDto> findOther(String name, Pageable pageable) {
        return foodRepository.findOther(name, pageable);
    }


}
