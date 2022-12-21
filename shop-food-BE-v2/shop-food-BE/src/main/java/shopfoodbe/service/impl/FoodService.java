package shopfoodbe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shopfoodbe.dto.ICartDto;
import shopfoodbe.dto.IFoodDto;
import shopfoodbe.dto.ITotalDto;
import shopfoodbe.model.Customer;
import shopfoodbe.model.Food;
import shopfoodbe.repository.ICustomerRepository;
import shopfoodbe.repository.IFoodRepository;
import shopfoodbe.service.IFoodService;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private IFoodRepository foodRepository;

    @Autowired
    private ICustomerRepository customerRepository;

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

    @Override
    public List<ICartDto> getCartList(Integer customerId) {
        return foodRepository.getCartList(customerId);
    }

    @Override
    public ITotalDto getTotalBill(Integer customerId) {
        return foodRepository.getTotalBill(customerId);
    }

    @Override
    public Customer findCartByUsername(String username) {
        return foodRepository.findCartId(username);
    }

    @Override
    public void updateProductCart(Integer id) {
        foodRepository.updateProductCart(id);
    }

    @Override
    public void insertProductToCart(Integer id, Integer customerId) {
        foodRepository.insertProductToCart(id, customerId);
    }

    @Override
    public void updateQty(Integer id, Integer quantity, Integer customerId) {
        foodRepository.updateQty(id, quantity, customerId);

    }

    @Override
    public void deleteProduct(Integer id) {
        foodRepository.deleteProduct(id);
    }

    @Override
    public IFoodDto findById(Integer id, String username) {
        return foodRepository.findByIdProduct(id, username);
    }

    @Override
    public void payment(String username) {
        Customer customer = customerRepository.findByUsername(username);
        foodRepository.payment(customer.getId());
    }

    @Override
    public List<ICartDto> findAllHistory(String username) {
        return foodRepository.findAllHistory(username);
    }
}
