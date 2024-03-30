package shopfoodbe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import shopfoodbe.dto.ICartDto;
import shopfoodbe.dto.IFoodDto;
import shopfoodbe.dto.ITotalDto;
import shopfoodbe.model.Customer;
import shopfoodbe.model.Food;

import java.util.List;
import java.util.Optional;

public interface IFoodService {

    Page<IFoodDto> findAllFood(String nameSearch, Pageable pageable);

    Optional<Food> findFoodById(int id);

    Page<IFoodDto> findVegetable(String name, Pageable pageable);

    Page<IFoodDto> findAllMeat(String name, Pageable pageable);

    Page<IFoodDto> findAllFruit(String name, Pageable pageable);

    Page<IFoodDto> findOther(String name, Pageable pageable);

    List<ICartDto> getCartList(Integer customerId);

    ITotalDto getTotalBill(Integer customerId);

    Customer findCartByUsername(String username);

    void updateProductCart(Integer id);

    void insertProductToCart(Integer id, Integer customerId);

    void updateQty(Integer id, Integer quantity, Integer customerId);

    void deleteProduct(Integer id);

    IFoodDto findById(Integer id, String username);

    void payment(String username);

    List<ICartDto> findAllHistory(String username);
}
