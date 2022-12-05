package shopfoodbe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shopfoodbe.dto.IFoodDto;
import shopfoodbe.model.Food;
import shopfoodbe.repository.IFoodRepository;
import shopfoodbe.service.IFoodService;

import java.util.List;
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


}
